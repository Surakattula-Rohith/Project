package com.stayplanner.hotel_service.services;

import com.stayplanner.hotel_service.model.Hotel;

import java.util.List;

public interface HotelServiceDAO {
    Hotel addHotel(Hotel hotel) ;
    List<Hotel> viewAllHotels() ;
}

