package com.stayplanner.hotel_service.services;

import com.stayplanner.hotel_service.model.Hotel;
import com.stayplanner.hotel_service.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImplementation implements HotelServiceDAO{

    @Autowired
    HotelRepository repo ;

    @Override
    public Hotel addHotel(Hotel hotel) {
        return repo.save(hotel);
    }

    @Override
    public List<Hotel> viewAllHotels() {
        return repo.findAll();
    }
}
