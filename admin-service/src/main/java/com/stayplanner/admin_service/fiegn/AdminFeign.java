package com.stayplanner.admin_service.fiegn;

import com.stayplanner.admin_service.exception.RoomsUnavailable;
import com.stayplanner.admin_service.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@FeignClient(name = "hotel-service")
public interface AdminFeign {

    @PutMapping("hotel/toggleAdminAccess/{hotelId}")
    public ResponseEntity<Hotel> toggleAdminAccess(@PathVariable int hotelId)  ;

    @GetMapping("owner/{ownerName}")
    public ResponseEntity<List<Hotel>> findByOwnerName(@PathVariable String ownerName);

    @DeleteMapping("delete/{hotelId}")
    public ResponseEntity<?> deleteHotel(@PathVariable int hotelId);

    @GetMapping("viewAll")
    public ResponseEntity<?> getAllHotels();

}
