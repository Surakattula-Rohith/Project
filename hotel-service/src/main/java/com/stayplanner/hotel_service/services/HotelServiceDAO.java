package com.stayplanner.hotel_service.services;

import com.stayplanner.hotel_service.exception.HotelIdDoesNotExist;
import com.stayplanner.hotel_service.exception.HotelNotFoundException;
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
    List<Hotel> findByOwnerName(String ownerName);
    List<Hotel> findByAcTrue();
    List<Hotel> findByWifiTrue();
    List<Hotel> findByMaintainanceTrue();
    List<Hotel> findBySingleRoomsGreaterThan(int number);
    List<Hotel> findByDoubleRoomsGreaterThan(int number);
    List<Hotel> findByTripleRoomsGreaterThan(int number);
    Hotel reduceSingleRoomByOne(int hotelId) throws HotelNotFoundException;
    Hotel reduceDoubleRoomByOne(int hotelId) throws HotelNotFoundException;
    Hotel toggleAdminAccess(int hotelId) throws HotelNotFoundException ;
    Hotel reduceTripleRoomByOne(int hotelId) throws HotelNotFoundException;

    Hotel findByHotelId(int hotelId);

    List<Hotel> findByHotelName(String hotelName);
}

