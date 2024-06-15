package com.stayplanner.booking_service.feign;
import com.stayplanner.booking_service.exception.RoomsUnavailable;
import com.stayplanner.booking_service.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "hotel-service")
public interface BookingFeign {
    @PutMapping("hotel/reduceSingleRoom/{hotelId}")
    public ResponseEntity<Hotel> reduceSingleRoomByOne(@PathVariable int hotelId) throws RoomsUnavailable;

    @PutMapping("hotel/reduceDoubleRoom/{hotelId}")
    public ResponseEntity<Hotel> reduceDoubleRoomByOne(@PathVariable int hotelId) throws RoomsUnavailable;

    @PutMapping("hotel/reduceTripleRoom/{hotelId}")
    public ResponseEntity<Hotel> reduceTripleRoomByOne(@PathVariable int hotelId) throws RoomsUnavailable;

    @GetMapping("hotel/findByName/{hotelName}")
    public ResponseEntity<List<Hotel>> findByHotelName(@PathVariable String hotelName);

    @GetMapping("hotel/findById/{hotelId}")
    public ResponseEntity<Hotel> findByHotelId(@PathVariable int hotelId) ;

    @GetMapping("hotel/tripleRooms")
    public ResponseEntity<List<Hotel>> findByTripleRoomsGreaterThan(@RequestParam int number);

    @GetMapping("hotel/doubleRooms")
    public ResponseEntity<List<Hotel>> findByDoubleRoomsGreaterThan(@RequestParam int number);

    @GetMapping("hotel/singleRooms")
    public ResponseEntity<List<Hotel>> findBySingleRoomsGreaterThan(@RequestParam int number);

    @GetMapping("hotel/maintenanceTrue")
    public ResponseEntity<List<Hotel>> findByMaintainanceTrue();

    @GetMapping("hotel/wifiTrue")
    public ResponseEntity<List<Hotel>> findByWifiTrue();

    @GetMapping("hotel/acTrue")
    public ResponseEntity<List<Hotel>> findByAcTrue();

    @GetMapping("hotel/owner/{ownerName}")
    public ResponseEntity<List<Hotel>> findByOwnerName(@PathVariable String ownerName);

    @GetMapping("hotel/findByCity/{city}")
    public ResponseEntity<?> findHotelsByCity(@PathVariable String city);

    @GetMapping("hotel/findByState/{state}")
    public ResponseEntity<?> findHotelsByState(@PathVariable String state);

    @GetMapping("hotel/findByStateAndCity/{state}/{city}")
    public ResponseEntity<?> findHotelsByStateAndCity(@PathVariable String state, @PathVariable String city);

    @GetMapping("hotel/viewAll")
    public ResponseEntity<?> getAllUser() ;
}
