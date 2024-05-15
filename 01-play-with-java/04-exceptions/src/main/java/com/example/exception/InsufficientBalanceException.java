package com.example.exception;

public class InsufficientBalanceException extends RuntimeException {

    private double balance;
    private double amount;

    public InsufficientBalanceException(double balance, double amount) {
        this.balance = balance;
        this.amount = amount;
    }

    public double getBalance() {
        return balance;
    }

    public double getAmount() {
        return amount;
    }

    public String getMessage() {
        return "Insufficient balance. Current balance: " + balance + ", amount: " + amount;
    }

}
