package com.example;

import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.errors.WakeupException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BarService {
    private static final Logger logger = LoggerFactory.getLogger(BarService.class);

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "bar-group");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("auto.offset.reset", "earliest"); // "latest", "none"
        props.put("enable.auto.commit", "false");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);

        consumer.subscribe(List.of("topic1"));

        final Thread mainThread = Thread.currentThread();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Detected a shutdown, let's exit by calling consumer.wakeup()...");
            consumer.wakeup();
            // join the main thread to allow the execution of the code in the main thread
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));

       try {
            while (true) {
//                logger.info("Polling...");
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
//                logger.info("Received {} records", records.count());
                records.forEach(record -> {
                    logger.info(
                            "Received new record\nTopic: {}\nKey: {}\nValue: {}\nPartition: {}\nOffset: {}\nTimestamp: {}",
                            record.topic(),
                            record.key(),
                            "record.value()",
                            record.partition(),
                            record.offset(),
                            record.timestamp());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });

                consumer.commitSync(); // Commit the offsets

            }
    } catch (WakeupException e) {
        System.out.println("Wake up exception! " + e);
    } catch (Exception e) {
        System.out.println("Unexpected exception " + e);
    } finally {
        consumer.close(); // Leaving Request to Group Coordinator
        System.out.println("The consumer is now gracefully closed");
    }



    }
}