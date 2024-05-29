package com.stayplanner.booking_service.feign;

import com.stayplanner.booking_service.config.FeignConfig;
import com.stayplanner.booking_service.exception.RoomsUnavailable;
import com.stayplanner.booking_service.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient("hotel-service")
public interface BookingFeign {
    @PutMapping("reduceSingleRoom/{hotelId}")
    public ResponseEntity<Hotel> reduceSingleRoomByOne(@PathVariable int hotelId) throws RoomsUnavailable;

    @PutMapping("reduceDoubleRoom/{hotelId}")
    public ResponseEntity<Hotel> reduceDoubleRoomByOne(@PathVariable int hotelId) throws RoomsUnavailable;

    @PutMapping("reduceTripleRoom/{hotelId}")
    public ResponseEntity<Hotel> reduceTripleRoomByOne(@PathVariable int hotelId) throws RoomsUnavailable;
}
