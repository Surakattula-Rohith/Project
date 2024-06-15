package com.stayplanner.booking_service.services;

import com.stayplanner.booking_service.exception.RoomsUnavailable;
import com.stayplanner.booking_service.model.Bookings;
import com.stayplanner.booking_service.model.Hotel;

import java.util.List;

public interface BookingDAO {

    Bookings addBooking(Bookings booking) throws RoomsUnavailable;
    List<Bookings> viewAllBookings();
    Bookings updateBooking(int bookingsId, Bookings booking) ;
    void deleteBooking(int bookingsId) ;
    Bookings getBookingById(int bookingsId);

    Hotel reduceSingleRoomByOne(int hotelId) throws RoomsUnavailable;

    Hotel reduceDoubleRoomByOne(int hotelId) throws RoomsUnavailable;

    Hotel reduceTripleRoomByOne(int hotelId) throws RoomsUnavailable;

    List<Hotel> findByHotelName(String hotelName);

    Hotel findByHotelId(int hotelId);

    List<Hotel> findByTripleRoomsGreaterThan(int number);

    List<Hotel> findByDoubleRoomsGreaterThan(int number);

    List<Hotel> findBySingleRoomsGreaterThan(int number);

    List<Hotel> findByMaintainanceTrue();

    List<Hotel> findByWifiTrue();

    List<Hotel> findByAcTrue();

    List<Hotel> findByOwnerName(String ownerName);

    List<Hotel> findHotelsByCity(String city);

    List<Hotel> findHotelsByState(String state);

    List<Hotel> findHotelsByStateAndCity(String state, String city);

    List<Hotel> getAllHotels();
}
