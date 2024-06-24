package com.example.booking;

import com.example.exception.BookingException;

public interface BookingService {
    void buyTicket(double amount) throws BookingException;
}
