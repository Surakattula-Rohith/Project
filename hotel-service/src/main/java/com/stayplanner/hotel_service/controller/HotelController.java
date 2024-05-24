package com.stayplanner.hotel_service.controller;

import com.stayplanner.hotel_service.exception.HotelIdDoesNotExist;
import com.stayplanner.hotel_service.model.Hotel;
import com.stayplanner.hotel_service.services.HotelServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
@CrossOrigin("*")
public class HotelController {
    @Autowired
    HotelServiceImplementation service ;

    @PostMapping("addHotel")
    public ResponseEntity<?> registerUser(@RequestBody Hotel hotel){
        return new ResponseEntity<Hotel>(service.addHotel(hotel), HttpStatus.CREATED);
    }

    @GetMapping("viewAll")
    public ResponseEntity<?> getAllUser(){
        return new ResponseEntity<List>(service.viewAllHotels() , HttpStatus.OK) ;
    }

    @PutMapping("/update/{hotelId}")
    public ResponseEntity<?> updateHotel(@PathVariable int hotelId, @RequestBody Hotel hotel) {
        try {
            Hotel updatedHotel = service.updateHotel(hotelId, hotel);
            return new ResponseEntity<Hotel>(updatedHotel, HttpStatus.OK);
        } catch (HotelIdDoesNotExist e) {
            return new ResponseEntity<String>("Hotel not found with id: " + hotelId, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable int hotelId) {
        try {
            service.deleteHotel(hotelId);
            return new ResponseEntity<String>("Hotel deleted successfully.", HttpStatus.OK);
        } catch (HotelIdDoesNotExist e) {
            return new ResponseEntity<String>("Hotel not found with id: " + hotelId, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findByStateAndCity/{state}/{city}")
    public ResponseEntity<?> findHotelsByStateAndCity(@PathVariable String state, @PathVariable String city) {
        List<Hotel> hotels = service.findHotelsByStateAndCity(state, city);
        if (hotels.isEmpty()) {
            return new ResponseEntity<String>("No hotels found in " + city + ", " + state, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
        }
    }

    @GetMapping("/findByState/{state}")
    public ResponseEntity<?> findHotelsByState(@PathVariable String state) {
        List<Hotel> hotels = service.findHotelsByState(state);
        if (hotels.isEmpty()) {
            return new ResponseEntity<String>("No hotels found in " + state, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
        }
    }

    @GetMapping("/findByCity/{city}")
    public ResponseEntity<?> findHotelsByCity(@PathVariable String city) {
        List<Hotel> hotels = service.findHotelsByCity(city);
        if (hotels.isEmpty()) {
            return new ResponseEntity<String>("No hotels found in " + city, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
        }
    }
}
