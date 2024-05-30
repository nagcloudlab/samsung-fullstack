package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

// @Component("transferService")
@Service("transferService")
@RequiredArgsConstructor
public class UPITransferService implements TransferService {

    private final AccountRepository accountRepository;

    @Transactional
    public void transfer(String sourceAccountNumber, String targetAccountNumber, double amount) {
        // implementation
        // ...
        Account sourceAccount = accountRepository.loadAccount(sourceAccountNumber);
        Account targetAccount = accountRepository.loadAccount(targetAccountNumber);

        // boolean isSufficientBalance = true;
        // if (!isSufficientBalance)
        // throw new RuntimeException("Insufficient balance");

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        accountRepository.updateAccount(sourceAccount);

        boolean b = false;
        if (b)
            throw new RuntimeException("Simulating runtime exception");

        // step-6 : update target account
        accountRepository.updateAccount(targetAccount);

    }

}