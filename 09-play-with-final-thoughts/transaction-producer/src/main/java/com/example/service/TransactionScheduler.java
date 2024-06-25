package com.example.service;


import com.example.domain.Transaction;
import com.example.util.TransactionLoader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Iterator;

@Slf4j
@RequiredArgsConstructor
@Component
public class TransactionScheduler {

    private static final String CSV_FILE = "transactions.csv";
    private static final Iterator<Transaction> TRANSACTIONS = TransactionLoader.loadTransactions(CSV_FILE).iterator();

    private final TransactionService transactionService;

//    @Scheduled(fixedRate = 1000)
    @Scheduled(
            // every minute
//            cron = "0 * * * * *"
            // every day at 1:00 AM
//            cron = "0 0 1 * * *"
            // every month at 30th day at 1:00 AM
            cron = "0 0 1 30 * *"
    )
    public void scheduleFixedRateTask() {
        System.out.println("tick");
        if (TRANSACTIONS.hasNext()) {
            Transaction transaction = TRANSACTIONS.next();
            transactionService.sendTransactionEvent(transaction);
            log.info("Transaction sent: {}", transaction);
        }
    }
}
