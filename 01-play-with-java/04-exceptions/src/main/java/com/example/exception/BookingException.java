package com.example.exception;

public class BookingException extends RuntimeException{
    public BookingException(String message) {
        super(message);
    }
}
