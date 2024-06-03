package com.example.service;

import org.apache.log4j.Logger;

import com.example.entity.Account;
import com.example.repository.JdbcAccountRepository;

public class UPITransferService {

    private static final Logger log = Logger.getLogger("money-transfer-service"); // singleton

    public UPITransferService() {
        log.info("UPITransferService instance created");
    }

    public void transfer(String sourceAccountNumber, String targetAccountNumber, double amount) {
        log.info("transferring amount: " + amount + " from account: " + sourceAccountNumber + " to account: "
                + targetAccountNumber);
        // implementation
        // ...
        JdbcAccountRepository accountRepository = new JdbcAccountRepository();
        // step-1 : load source account
        Account sourceAccount = accountRepository.loadAccount(sourceAccountNumber);
        // step-2 : load target account
        Account targetAccount = accountRepository.loadAccount(targetAccountNumber);
        // step-3 : debit source account
        sourceAccount.setBalance(sourceAccount.getBalance() - amount);
        // step-4 : credit target account
        targetAccount.setBalance(targetAccount.getBalance() + amount);
        // step-5 : update source account
        accountRepository.updateAccount(sourceAccount);
        // step-6 : update target account
        accountRepository.updateAccount(targetAccount);

        log.info("transfer successful");

    }

}