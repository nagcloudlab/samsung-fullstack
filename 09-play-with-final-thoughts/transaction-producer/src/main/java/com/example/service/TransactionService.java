package com.example.service;

import com.example.domain.Transaction;
import com.example.domain.TransactionKey;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class TransactionService {

    public void sendTransactionEvent(Transaction transaction) {
        System.out.println("Transaction sent: " + transaction);
    }

    private TransactionKey buildKey(Transaction transaction) {
        return TransactionKey.builder()
                .fromAccount(transaction.getFromAccount())
                .toAccount(transaction.getToAccount())
                .build();
    }
}
