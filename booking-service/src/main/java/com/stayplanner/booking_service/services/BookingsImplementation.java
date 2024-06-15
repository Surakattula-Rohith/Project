package com.stayplanner.booking_service.services;

import com.netflix.discovery.converters.Auto;
import com.stayplanner.booking_service.exception.RoomsUnavailable;
import com.stayplanner.booking_service.feign.BookingFeign;
import com.stayplanner.booking_service.model.Bookings;
import com.stayplanner.booking_service.model.Hotel;
import com.stayplanner.booking_service.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsImplementation implements BookingDAO {

    @Autowired
    private BookingsRepository repo;

    @Autowired
    BookingFeign bookingFeign ;
    @Override
    public Bookings addBooking(Bookings booking) throws RoomsUnavailable {
        if (booking.getRoomType().equals("Single")) {
            bookingFeign.reduceSingleRoomByOne(booking.getHotelId()) ;
        }else if (booking.getRoomType().equals("Double")) {
            bookingFeign.reduceDoubleRoomByOne(booking.getHotelId()) ;
        }else if(booking.getRoomType().equals("Triple")) {
            bookingFeign.reduceTripleRoomByOne(booking.getHotelId()) ;
        }else {

        }
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

    @Override
    public Hotel reduceSingleRoomByOne(int hotelId) throws RoomsUnavailable {
        return bookingFeign.reduceSingleRoomByOne(hotelId).getBody();
    }

    @Override
    public Hotel reduceDoubleRoomByOne(int hotelId) throws RoomsUnavailable {
        return bookingFeign.reduceDoubleRoomByOne(hotelId).getBody();
    }

    @Override
    public Hotel reduceTripleRoomByOne(int hotelId) throws RoomsUnavailable {
        return bookingFeign.reduceTripleRoomByOne(hotelId).getBody();
    }

    @Override
    public List<Hotel> findByHotelName(String hotelName) {
        return bookingFeign.findByHotelName(hotelName).getBody();
    }

    @Override
    public Hotel findByHotelId(int hotelId) {
        return bookingFeign.findByHotelId(hotelId).getBody();
    }

    @Override
    public List<Hotel> findByTripleRoomsGreaterThan(int number) {
        return bookingFeign.findByTripleRoomsGreaterThan(number).getBody();
    }

    @Override
    public List<Hotel> findByDoubleRoomsGreaterThan(int number) {
        return bookingFeign.findByDoubleRoomsGreaterThan(number).getBody();
    }

    @Override
    public List<Hotel> findBySingleRoomsGreaterThan(int number) {
        return bookingFeign.findBySingleRoomsGreaterThan(number).getBody();
    }

    @Override
    public List<Hotel> findByMaintainanceTrue() {
        return bookingFeign.findByMaintainanceTrue().getBody();
    }

    @Override
    public List<Hotel> findByWifiTrue() {
        return bookingFeign.findByWifiTrue().getBody();
    }

    @Override
    public List<Hotel> findByAcTrue() {
        return bookingFeign.findByAcTrue().getBody();
    }

    @Override
    public List<Hotel> findByOwnerName(String ownerName) {
        return bookingFeign.findByOwnerName(ownerName).getBody();
    }

    @Override
    public List<Hotel> findHotelsByCity(String city) {
        return (List<Hotel>) bookingFeign.findHotelsByCity(city).getBody();
    }

    @Override
    public List<Hotel> findHotelsByState(String state) {
        return (List<Hotel>) bookingFeign.findHotelsByState(state).getBody();
    }

    @Override
    public List<Hotel> findHotelsByStateAndCity(String state, String city) {
        return (List<Hotel>) bookingFeign.findHotelsByStateAndCity(state, city).getBody();
    }

    @Override
    public List<Hotel> getAllHotels() {
        return (List<Hotel>) bookingFeign.getAllUser().getBody();
    }
}
