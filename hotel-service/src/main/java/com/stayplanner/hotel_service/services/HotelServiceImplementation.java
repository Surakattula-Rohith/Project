package com.stayplanner.hotel_service.services;

import com.stayplanner.hotel_service.exception.HotelIdDoesNotExist;
import com.stayplanner.hotel_service.model.Hotel;
import com.stayplanner.hotel_service.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Hotel updateHotel(int hotelId, Hotel hotel) throws HotelIdDoesNotExist {
        Optional<Hotel> optionalHotel = repo.findById(hotelId);
        if (optionalHotel.isPresent()) {
            Hotel existingHotel = optionalHotel.get();

            // Update the fields of the existing hotel with the new hotel details
            existingHotel.setHotelName(hotel.getHotelName());
            existingHotel.setState(hotel.getState());
            existingHotel.setCity(hotel.getCity());
            existingHotel.setAddress(hotel.getAddress());
            existingHotel.setGstNumber(hotel.getGstNumber());
            existingHotel.setOwnerName(hotel.getOwnerName());
            existingHotel.setDescription(hotel.getDescription());
            existingHotel.setAc(hotel.isAc());
            existingHotel.setWifi(hotel.isWifi());
            existingHotel.setMaintainance(hotel.isMaintainance());
            existingHotel.setSingleRooms(hotel.getSingleRooms());
            existingHotel.setDoubleRooms(hotel.getDoubleRooms());
            existingHotel.setTripleRooms(hotel.getTripleRooms());

            return repo.save(existingHotel);
        } else {
            throw new HotelIdDoesNotExist("Hotel not found with id: " + hotelId);
        }
    }

    @Override
    public void deleteHotel(int hotelId) throws HotelIdDoesNotExist {
        Optional<Hotel> optionalHotel = repo.findById(hotelId);
        if (optionalHotel.isPresent()) {
            repo.deleteById(hotelId);
        } else {
            throw new HotelIdDoesNotExist("Hotel not found with id: " + hotelId);
        }
    }

    @Override
    public List<Hotel> findHotelsByStateAndCity(String state, String city) {
        return repo.findByStateAndCity(state, city);
    }

    @Override
    public List<Hotel> findHotelsByState(String state) {
        return repo.findByState(state);
    }

    @Override
    public List<Hotel> findHotelsByCity(String city) {
        return repo.findByCity(city);
    }


}
