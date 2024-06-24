package com.example.repository;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.entity.Account;

@Component("jdbcAccountRepository")
public class JdbcAccountRepository implements AccountRepository {

    private DataSource dataSource; // dependency

    @Autowired
    public JdbcAccountRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Account loadAccount(String accountNumber) {
        // implementation
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            // use connection to load account
        } catch (Exception e) {
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
            }
        }
        return new Account(accountNumber, "holder-name", 1000.00);
    }

    public void updateAccount(Account account) {
        // implementation
        // ...
    }

}
