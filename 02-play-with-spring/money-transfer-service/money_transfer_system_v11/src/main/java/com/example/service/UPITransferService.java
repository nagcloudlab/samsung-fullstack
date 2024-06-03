package com.example.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.TransferStatus;
import com.example.entity.Account;
import com.example.exception.AccountNotFoundException;
import com.example.exception.BalanceException;
import com.example.exception.TransferLimitException;
import com.example.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service("transferService")
@RequiredArgsConstructor
public class UPITransferService implements TransferService {

    private final AccountRepository accountRepository;

    @Value("${transfer.limit:500}")
    private double transferLimit;

    @Transactional
    public TransferStatus transfer(String sourceAccountNumber, String targetAccountNumber, double amount) {
        // implementation
        // ...
        Account sourceAccount = accountRepository.findById(sourceAccountNumber)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Source account not found with number " + sourceAccountNumber));
        Account targetAccount = accountRepository.findById(targetAccountNumber)
                .orElseThrow(() -> new AccountNotFoundException(
                        "Target account not found with number " + targetAccountNumber));

        System.out.println(transferLimit);

        if (amount > transferLimit)
            throw new TransferLimitException(targetAccountNumber + " exceeded transfer limit " + transferLimit);

        if (sourceAccount.getBalance() < amount)
            throw new BalanceException("Not enough balance in source account, balance: " + sourceAccount.getBalance());

        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        accountRepository.save(sourceAccount);

        // boolean b = false;
        // if (b)
        // throw new RuntimeException("Simulating runtime exception");

        // step-6 : update target account
        accountRepository.save(targetAccount);

        return new TransferStatus("SUCCESS");

    }

}