package com.example.exception;

public class TransferLimitException extends RuntimeException {

    public TransferLimitException(String message) {
        super(message);
    }

}
