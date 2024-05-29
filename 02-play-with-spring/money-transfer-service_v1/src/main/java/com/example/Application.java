package com.example;

import com.example.service.UPITransferService;

public class Application {

    public static void main(String[] args) {

        // -----------------------------------------
        // 1. init / booting phase
        // -----------------------------------------
        System.out.println("-".repeat(100));
        // prepare the application based on the configuration
        UPITransferService transferService = new UPITransferService();

        System.out.println("-".repeat(100));
        // -----------------------------------------
        // 2. use phase
        // -----------------------------------------
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

    }
}
