package com.example.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(String sourceAccount) {
        super("Account not found: " + sourceAccount);
    }
}
