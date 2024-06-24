package com.example;

import com.example.booking.BookingService;
import com.example.booking.BookingServiceImpl;
import com.example.exception.AccountNotFoundException;
import com.example.exception.BookingException;
import com.example.exception.InsufficientBalanceException;
import com.example.payment.TransferService;
import com.example.payment.UPITransferService;

public class App {
    public static void main(String[] args) {

        TransferService upiTransferService = new UPITransferService();
        BookingService bookingService = new BookingServiceImpl(upiTransferService);

        try {
            bookingService.buyTicket(10000.00);
            System.out.println("Booking successful");
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("Booking failed: " + e.getMessage());
        } catch (Throwable e) {
            System.out.println("Booking failed: " + e.getMessage());
        }


        // way-1
//        FileResource fileResource = null;
//        try {
//            fileResource = new FileResource();
//            fileResource.read("path");
//        } catch (RuntimeException e) {
//            System.out.println("File system is not available");
//        } finally {
//            System.out.println("Finally block");
//            // why do we need finally block?
//            // close connection to file system
//            if (fileResource != null) {
//                fileResource.close();
//            }
//        }

        // way-2 (try-with-resources) - Java 7
        try (FileResource fileResource = new FileResource()) {
            fileResource.read("path");
        } catch (RuntimeException e) {
            System.out.println("File system is not available");
        } finally {
            System.out.println("Finally block");
        }

    }
}
