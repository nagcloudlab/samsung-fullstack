package com.example.payment;

import com.example.exception.AccountNotFoundException;
import com.example.exception.InsufficientBalanceException;

public interface TransferService {
    boolean transfer(String sourceAccount, String targetAccount, double amount);
}
