package com.stayplanner.booking_service.services;

import com.stayplanner.booking_service.model.Bookings;

import java.util.List;

public interface BookingDAO {

    Bookings addBooking(Bookings booking);
    List<Bookings> viewAllBookings();
    Bookings updateBooking(int bookingsId, Bookings booking) ;
    void deleteBooking(int bookingsId) ;
    Bookings getBookingById(int bookingsId);
}
