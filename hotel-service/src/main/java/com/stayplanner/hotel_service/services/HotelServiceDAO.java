package com.stayplanner.hotel_service.services;

import com.stayplanner.hotel_service.exception.HotelIdDoesNotExist;
import com.stayplanner.hotel_service.model.Hotel;

import java.util.List;

public interface HotelServiceDAO {
    Hotel addHotel(Hotel hotel) ;
    List<Hotel> viewAllHotels() ;
    Hotel updateHotel(int hotelId, Hotel hotel) throws HotelIdDoesNotExist;
    void deleteHotel(int hotelId) throws HotelIdDoesNotExist;
    List<Hotel> findHotelsByStateAndCity(String state, String city);
    List<Hotel> findHotelsByState(String state);
    List<Hotel> findHotelsByCity(String city);
}

