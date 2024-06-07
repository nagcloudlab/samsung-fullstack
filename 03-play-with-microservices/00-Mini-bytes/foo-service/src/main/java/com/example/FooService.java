package com.example;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class FooService {
    public static void main(String[] args) throws InterruptedException {

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092"); // to get cluster metadata
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer<String,String> producer = new KafkaProducer<String, String>(props);

        String topic = "topic1";
        List<String> languages=List.of("en", "fr", "de", "es", "it", "pt", "ru", "zh", "ja", "ko");
        for(int i = 0; i < 100; i++) {
            String key = languages.get(Math.abs(i % languages.size()));
            String value = "Hey Kafka!".repeat(100); // 1kb
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic,key, value);
            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    exception.printStackTrace();
                } else {
                    System.out.println("Record sent to partition " + metadata.partition() + " with offset " + metadata.offset());
                }
            });
            TimeUnit.MILLISECONDS.sleep(1);
        }

        producer.close();

    }
}