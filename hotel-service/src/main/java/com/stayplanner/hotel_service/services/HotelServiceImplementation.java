package com.stayplanner.hotel_service.services;

import com.stayplanner.hotel_service.exception.HotelIdDoesNotExist;
import com.stayplanner.hotel_service.exception.HotelNotFoundException;
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

    @Override
    public List<Hotel> findByOwnerName(String ownerName) {
        return repo.findByOwnerName(ownerName);
    }

    @Override
    public List<Hotel> findByAcTrue() {
        return repo.findByAcTrue();
    }

    @Override
    public List<Hotel> findBySingleRoomsGreaterThan(int number) {
        return repo.findBySingleRoomsGreaterThan(number);
    }

    @Override
    public List<Hotel> findByDoubleRoomsGreaterThan(int number) {
        return repo.findByDoubleRoomsGreaterThan(number);
    }

    @Override
    public List<Hotel> findByTripleRoomsGreaterThan(int number) {
        return repo.findByTripleRoomsGreaterThan(number);
    }




    @Override
    public List<Hotel> findByWifiTrue() {
        return repo.findByWifiTrue();
    }

    @Override
    public List<Hotel> findByMaintainanceTrue() {
        return repo.findByMaintainanceTrue();
    }

    @Override
    public Hotel reduceSingleRoomByOne(int hotelId) throws HotelNotFoundException {
        Optional<Hotel> optionalHotel = repo.findById(hotelId);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            if (hotel.getSingleRooms() > 0) {
                hotel.setSingleRooms(hotel.getSingleRooms() - 1);
                return repo.save(hotel);
            } else {
                throw new IllegalArgumentException("No single rooms available to reduce");
            }
        } else {
            throw new HotelNotFoundException("Hotel not found with id: " + hotelId);
        }
    }

    @Override
    public Hotel reduceDoubleRoomByOne(int hotelId) throws HotelNotFoundException {
        Optional<Hotel> optionalHotel = repo.findById(hotelId);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            if (hotel.getDoubleRooms() > 0) {
                hotel.setDoubleRooms(hotel.getDoubleRooms() - 1);
                return repo.save(hotel);
            } else {
                throw new IllegalArgumentException("No double rooms available to reduce");
            }
        } else {
            throw new HotelNotFoundException("Hotel not found with id: " + hotelId);
        }
    }

    @Override
    public Hotel reduceTripleRoomByOne(int hotelId) throws HotelNotFoundException {
        Optional<Hotel> optionalHotel = repo.findById(hotelId);
        if (optionalHotel.isPresent()) {
            Hotel hotel = optionalHotel.get();
            if (hotel.getTripleRooms() > 0) {
                hotel.setTripleRooms(hotel.getTripleRooms() - 1);
                return repo.save(hotel);
            } else {
                throw new IllegalArgumentException("No triple rooms available to reduce");
            }
        } else {
            throw new HotelNotFoundException("Hotel not found with id: " + hotelId);
        }
    }

    public Hotel toggleAdminAccess(int hotelId) throws HotelNotFoundException {
        Hotel hotel = repo.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel not found with id: " + hotelId));
        hotel.setAdminAccess(!hotel.isAdminAccess());
        return repo.save(hotel);
    }

    @Override
    public Hotel findByHotelId(int hotelId) {
        return repo.findByHotelId(hotelId);
    }

    @Override
    public List<Hotel> findByHotelName(String hotelName) {
        return repo.findByHotelName(hotelName);
    }


}
