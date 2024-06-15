package com.stayplanner.booking_service.controller;

import com.stayplanner.booking_service.exception.RoomsUnavailable;
import com.stayplanner.booking_service.model.Bookings;
import com.stayplanner.booking_service.model.Hotel;
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
@CrossOrigin("*")
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



    @GetMapping("hotel/findByName/{hotelName}")
    public ResponseEntity<List<Hotel>> findByHotelName(@PathVariable String hotelName) {
        List<Hotel> hotels = service.findByHotelName(hotelName);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/findById/{hotelId}")
    public ResponseEntity<Hotel> findByHotelId(@PathVariable int hotelId) {
        Hotel hotel = service.findByHotelId(hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("hotel/tripleRooms")
    public ResponseEntity<List<Hotel>> findByTripleRoomsGreaterThan(@RequestParam int number) {
        List<Hotel> hotels = service.findByTripleRoomsGreaterThan(number);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/doubleRooms")
    public ResponseEntity<List<Hotel>> findByDoubleRoomsGreaterThan(@RequestParam int number) {
        List<Hotel> hotels = service.findByDoubleRoomsGreaterThan(number);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/singleRooms")
    public ResponseEntity<List<Hotel>> findBySingleRoomsGreaterThan(@RequestParam int number) {
        List<Hotel> hotels = service.findBySingleRoomsGreaterThan(number);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/maintenanceTrue")
    public ResponseEntity<List<Hotel>> findByMaintainanceTrue() {
        List<Hotel> hotels = service.findByMaintainanceTrue();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/wifiTrue")
    public ResponseEntity<List<Hotel>> findByWifiTrue() {
        List<Hotel> hotels = service.findByWifiTrue();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/acTrue")
    public ResponseEntity<List<Hotel>> findByAcTrue() {
        List<Hotel> hotels = service.findByAcTrue();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/owner/{ownerName}")
    public ResponseEntity<List<Hotel>> findByOwnerName(@PathVariable String ownerName) {
        List<Hotel> hotels = service.findByOwnerName(ownerName);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/findByCity/{city}")
    public ResponseEntity<?> findHotelsByCity(@PathVariable String city) {
        List<Hotel> hotels = service.findHotelsByCity(city);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/findByState/{state}")
    public ResponseEntity<?> findHotelsByState(@PathVariable String state) {
        List<Hotel> hotels = service.findHotelsByState(state);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/findByStateAndCity/{state}/{city}")
    public ResponseEntity<?> findHotelsByStateAndCity(@PathVariable String state, @PathVariable String city) {
        List<Hotel> hotels = service.findHotelsByStateAndCity(state, city);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("hotel/viewAll")
    public ResponseEntity<?> getAllHotels() {
        List<Hotel> hotels = service.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }
}

