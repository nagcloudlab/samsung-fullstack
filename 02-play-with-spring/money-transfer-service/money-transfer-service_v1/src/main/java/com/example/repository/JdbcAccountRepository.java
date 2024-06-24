package com.example.repository;

import org.apache.log4j.Logger;

import com.example.entity.Account;

public class JdbcAccountRepository {

    private static final Logger log = Logger.getLogger("money-transfer-service"); // singleton

    public JdbcAccountRepository() {
        log.info("JdbcAccountRepository instance created");
    }

    public Account loadAccount(String accountNumber) {
        log.info("loading account with account number: " + accountNumber);
        // implementation
        // ...
        return new Account(accountNumber, "holder-name", 1000.00);
    }

    public void updateAccount(Account account) {
        log.info("updating account with account number: " + account.getAccountNumber());
        // implementation
        // ...
    }

}
