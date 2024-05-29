package com.stayplanner.booking_service.controller;

import com.stayplanner.booking_service.exception.RoomsUnavailable;
import com.stayplanner.booking_service.model.Bookings;
import com.stayplanner.booking_service.services.BookingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("booking")

public class BookingsController {

    @Autowired
    private BookingDAO service;

    @PostMapping("addBooking")
    public ResponseEntity<Bookings> addBooking(@RequestBody Bookings booking) throws RoomsUnavailable {
        return new ResponseEntity<>(service.addBooking(booking), HttpStatus.CREATED);
    }

    @GetMapping("viewAllBookings")
    public ResponseEntity<List<Bookings>> viewAllBookings() {
        return new ResponseEntity<>(service.viewAllBookings(), HttpStatus.OK);
    }

    @GetMapping("getBookingById/{bookingsId}")
    public ResponseEntity<Bookings> getBookingById(@PathVariable int bookingsId) {

        return new ResponseEntity<>(service.getBookingById(bookingsId), HttpStatus.OK);

    }

    @PutMapping("updateBookingById/{bookingsId}")
    public ResponseEntity<Bookings> updateBooking(@PathVariable int bookingsId, @RequestBody Bookings booking) {

        return new ResponseEntity<>(service.updateBooking(bookingsId, booking), HttpStatus.OK);

    }

    @DeleteMapping("deleteBookingById/{bookingsId}")
    public ResponseEntity<String> deleteBooking(@PathVariable int bookingsId) {

        service.deleteBooking(bookingsId);
        return new ResponseEntity<>("Successfully delete.", HttpStatus.OK);

    }
}

