package com.stayplanner.hotel_service.controller;

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

}
