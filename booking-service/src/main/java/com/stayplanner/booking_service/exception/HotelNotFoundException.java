package com.stayplanner.booking_service.exception;

public class HotelNotFoundException extends Exception {
    public HotelNotFoundException(String message) {
        super(message);
    }
}