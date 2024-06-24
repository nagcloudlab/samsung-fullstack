package com.example.repository;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Account;

@Component("jdbcAccountRepository")
public class JdbcAccountRepository implements AccountRepository {

    private static final Logger log = Logger.getLogger("money-transfer-service"); // singleton

    private DataSource dataSource; // dependency

    @Autowired
    public JdbcAccountRepository(DataSource dataSource) {
        log.info(dataSource.getClass().getName() + " is injected to JdbcAccountRepository");
        this.dataSource = dataSource;
        log.info("JdbcAccountRepository instance created");
    }

    public Account loadAccount(String accountNumber) {
        log.info("loading account with account number: " + accountNumber);
        // implementation
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            // use connection to load account
        } catch (Exception e) {
            log.error("Exception occurred while loading account with account number: " + accountNumber, e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                log.error("Exception occurred while closing connection", e);
            }
        }
        return new Account(accountNumber, "holder-name", 1000.00);
    }

    public void updateAccount(Account account) {
        log.info("updating account with account number: " + account.getAccountNumber());
        // implementation
        // ...
    }

}
