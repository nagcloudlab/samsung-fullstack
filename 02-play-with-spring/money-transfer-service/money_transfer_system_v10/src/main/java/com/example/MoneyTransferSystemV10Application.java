package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.service.TransferService;

@SpringBootApplication
public class MoneyTransferSystemV10Application {

	public static void main(String[] args) {

		// -----------------------------------------
		// 1. init / booting phase
		// -----------------------------------------
		System.out.println("-".repeat(100));
		// prepare the application based on the configuration

		ConfigurableApplicationContext applicationContext = null;
		applicationContext = SpringApplication.run(MoneyTransferSystemV10Application.class, args);

		System.out.println("-".repeat(100));
		// -----------------------------------------
		// 2. use phase
		// -----------------------------------------
		System.out.println("-".repeat(100));

		TransferService transferService = applicationContext.getBean("transferService", TransferService.class);
		System.out.println("transferService: " +
				transferService.getClass().getName());
		transferService.transfer("1234-5", "1234-6", 100.0);

		// String bean1 = applicationContext.getBean("bean1", String.class);
		// System.out.println("bean1: " + bean1);

		// -----------------------------------------
		// 3. shutdown phase
		// -----------------------------------------

		// release the resources
		System.out.println("-".repeat(100));
		applicationContext.close();
	}

}
