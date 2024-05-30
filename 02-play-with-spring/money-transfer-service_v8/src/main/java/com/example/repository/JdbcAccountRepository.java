package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.example.entity.Account;

@Component("jdbcAccountRepository")
public class JdbcAccountRepository implements AccountRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account loadAccount(String accountNumber) {
        RowMapper<Account> rowMapper = (rs, rowNum) -> {
            var account = new Account();
            account.setAccountNumber(rs.getString("number"));
            account.setBalance(rs.getDouble("balance"));
            return account;
        };
        return jdbcTemplate.queryForObject("SELECT * FROM ACCOUNTS WHERE number = ?", rowMapper, accountNumber);
    }

    public void updateAccount(Account account) {
        jdbcTemplate.update("UPDATE ACCOUNTS SET balance = ? WHERE number = ?", account.getBalance(),
                account.getAccountNumber());
    }

}
