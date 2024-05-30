package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.service.TransferService;

// @Configuration
// @EnableAutoConfiguration
// @ComponentScan(basePackages = "com.example")
// or
@SpringBootApplication
@EntityScan(basePackages = "com.example.entity")
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {

        // -----------------------------------------
        // 1. init / booting phase
        // -----------------------------------------
        System.out.println("-".repeat(100));
        // prepare the application based on the configuration

        ConfigurableApplicationContext applicationContext = null;
        applicationContext = SpringApplication.run(Application.class, args);

        System.out.println("-".repeat(100));
        // -----------------------------------------
        // 2. use phase
        // -----------------------------------------
        System.out.println("-".repeat(100));

        TransferService transferService = applicationContext.getBean("transferService", TransferService.class);
        System.out.println("transferService: " + transferService.getClass().getName());
        transferService.transfer("1234-5", "1234-6", 100.0);
        // -----------------------------------------
        // 3. shutdown phase
        // -----------------------------------------

        // release the resources
        System.out.println("-".repeat(100));
        applicationContext.close();

    }
}
