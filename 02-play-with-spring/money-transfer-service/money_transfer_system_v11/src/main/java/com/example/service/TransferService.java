package com.example.service;

import com.example.dto.TransferStatus;

public interface TransferService {
    TransferStatus transfer(String sourceAccountNumber, String targetAccountNumber, double amount);
}