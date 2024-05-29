package com.example.service;

public interface TransferService {
    void transfer(String sourceAccountNumber, String targetAccountNumber, double amount);
}