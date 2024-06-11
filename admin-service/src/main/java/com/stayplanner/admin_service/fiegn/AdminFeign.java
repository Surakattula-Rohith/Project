package com.stayplanner.admin_service.fiegn;

import com.stayplanner.admin_service.exception.RoomsUnavailable;
import com.stayplanner.admin_service.model.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "hotel-service")
public interface AdminFeign {

    @PutMapping("hotel/toggleAdminAccess/{hotelId}")
    public ResponseEntity<Hotel> toggleAdminAccess(@PathVariable int hotelId)  ;
}
