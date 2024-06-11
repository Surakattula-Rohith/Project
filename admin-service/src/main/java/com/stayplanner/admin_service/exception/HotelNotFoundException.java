package com.stayplanner.admin_service.exception;

public class HotelNotFoundException extends Exception {
    public HotelNotFoundException(String message) {
        super(message);
    }
}