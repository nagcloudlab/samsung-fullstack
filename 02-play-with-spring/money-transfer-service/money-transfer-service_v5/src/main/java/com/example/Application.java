package com.example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.TransferServiceConfiguration;
import com.example.service.TransferService;

public class Application {

    public static void main(String[] args) {

        // -----------------------------------------
        // 1. init / booting phase
        // -----------------------------------------
        System.out.println("-".repeat(100));
        // prepare the application based on the configuration

        ConfigurableApplicationContext applicationContext = null;
        applicationContext = new AnnotationConfigApplicationContext(TransferServiceConfiguration.class);

        System.out.println("-".repeat(100));
        // -----------------------------------------
        // 2. use phase
        // -----------------------------------------
        TransferService transferService = applicationContext.getBean("transferService", TransferService.class);
        System.out.println("-".repeat(100));
        transferService.transfer("1001", "1002", 100.0);
        System.out.println();
        transferService.transfer("1002", "1001", 50.0);
        System.out.println("-".repeat(100));
        // -----------------------------------------
        // 3. shutdown phase
        // -----------------------------------------

        // release the resources
        System.out.println("-".repeat(100));
        applicationContext.close();

    }
}
