package com.stayplanner.booking_service.services;

import com.stayplanner.booking_service.model.Bookings;
import com.stayplanner.booking_service.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsImplementation implements BookingDAO {

    @Autowired
    private BookingsRepository repo;
    @Override
    public Bookings addBooking(Bookings booking) {
        return repo.save(booking);
    }

    @Override
    public List<Bookings> viewAllBookings() {
        return repo.findAll();
    }

    @Override
    public Bookings updateBooking(int bookingsId, Bookings booking) {
        booking.setBookingsId(bookingsId);
        return repo.save(booking);
    }

    @Override
    public void deleteBooking(int bookingsId) {
        repo.deleteById(bookingsId);
    }

    @Override
    public Bookings getBookingById(int bookingsId) {
        return repo.findById(bookingsId).get();
    }
}
