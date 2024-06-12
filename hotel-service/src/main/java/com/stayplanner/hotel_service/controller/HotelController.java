package com.stayplanner.hotel_service.controller;

import com.stayplanner.hotel_service.exception.HotelIdDoesNotExist;
import com.stayplanner.hotel_service.exception.HotelNotFoundException;
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

    @PutMapping("update/{hotelId}")
    public ResponseEntity<?> updateHotel(@PathVariable int hotelId, @RequestBody Hotel hotel) {
        try {
            Hotel updatedHotel = service.updateHotel(hotelId, hotel);
            return new ResponseEntity<Hotel>(updatedHotel, HttpStatus.OK);
        } catch (HotelIdDoesNotExist e) {
            return new ResponseEntity<String>("Hotel not found with id: " + hotelId, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("delete/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable int hotelId) {
        try {
            service.deleteHotel(hotelId);
            return new ResponseEntity<String>("Hotel deleted successfully.", HttpStatus.OK);
        } catch (HotelIdDoesNotExist e) {
            return new ResponseEntity<String>("Hotel not found with id: " + hotelId, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("findByStateAndCity/{state}/{city}")
    public ResponseEntity<?> findHotelsByStateAndCity(@PathVariable String state, @PathVariable String city) {
        List<Hotel> hotels = service.findHotelsByStateAndCity(state, city);
        if (hotels.isEmpty()) {
            return new ResponseEntity<String>("No hotels found in " + city + ", " + state, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
        }
    }

    @GetMapping("findByState/{state}")
    public ResponseEntity<?> findHotelsByState(@PathVariable String state) {
        List<Hotel> hotels = service.findHotelsByState(state);
        if (hotels.isEmpty()) {
            return new ResponseEntity<String>("No hotels found in " + state, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
        }
    }

    @GetMapping("findByCity/{city}")
    public ResponseEntity<?> findHotelsByCity(@PathVariable String city) {
        List<Hotel> hotels = service.findHotelsByCity(city);
        if (hotels.isEmpty()) {
            return new ResponseEntity<String>("No hotels found in " + city, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Hotel>>(hotels, HttpStatus.OK);
        }
    }




    @GetMapping("owner/{ownerName}")
    public ResponseEntity<List<Hotel>> findByOwnerName(@PathVariable String ownerName) {
        List<Hotel> hotels = service.findByOwnerName(ownerName);
        if (hotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("acTrue")
    public ResponseEntity<List<Hotel>> findByAcTrue() {
        List<Hotel> hotels = service.findByAcTrue();
        if (hotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("wifiTrue")
    public ResponseEntity<List<Hotel>> findByWifiTrue() {
        List<Hotel> hotels = service.findByWifiTrue();
        if (hotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("maintenanceTrue")
    public ResponseEntity<List<Hotel>> findByMaintainanceTrue() {
        List<Hotel> hotels = service.findByMaintainanceTrue();
        if (hotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("singleRooms")
    public ResponseEntity<List<Hotel>> findBySingleRoomsGreaterThan(@RequestParam int number) {
        List<Hotel> hotels = service.findBySingleRoomsGreaterThan(number);
        if (hotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("doubleRooms")
    public ResponseEntity<List<Hotel>> findByDoubleRoomsGreaterThan(@RequestParam int number) {
        List<Hotel> hotels = service.findByDoubleRoomsGreaterThan(number);
        if (hotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("tripleRooms")
    public ResponseEntity<List<Hotel>> findByTripleRoomsGreaterThan(@RequestParam int number) {
        List<Hotel> hotels = service.findByTripleRoomsGreaterThan(number);
        if (hotels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @PutMapping("reduceSingleRoom/{hotelId}")
    public ResponseEntity<Hotel> reduceSingleRoomByOne(@PathVariable int hotelId) {
        try {
            Hotel updatedHotel = service.reduceSingleRoomByOne(hotelId);
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } catch (HotelNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("reduceDoubleRoom/{hotelId}")
    public ResponseEntity<Hotel> reduceDoubleRoomByOne(@PathVariable int hotelId) {
        try {
            Hotel updatedHotel = service.reduceDoubleRoomByOne(hotelId);
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } catch (HotelNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("reduceTripleRoom/{hotelId}")
    public ResponseEntity<Hotel> reduceTripleRoomByOne(@PathVariable int hotelId) {
        try {
            Hotel updatedHotel = service.reduceTripleRoomByOne(hotelId);
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } catch (HotelNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("toggleAdminAccess/{hotelId}")
    public ResponseEntity<Hotel> toggleAdminAccess(@PathVariable int hotelId) {
        try {
            Hotel updatedHotel = service.toggleAdminAccess(hotelId);
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } catch (HotelNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
