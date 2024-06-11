package com.stayplanner.admin_service.contoller;


import com.netflix.discovery.converters.Auto;
import com.stayplanner.admin_service.exception.HotelNotFoundException;
import com.stayplanner.admin_service.exception.RoomsUnavailable;
import com.stayplanner.admin_service.model.Admin;
import com.stayplanner.admin_service.model.Hotel;
import com.stayplanner.admin_service.services.AdminImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminImplementation service;

    @PostMapping("addAdmin")
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws RoomsUnavailable {
        return new ResponseEntity<>(service.addAdmin(admin), HttpStatus.CREATED);
    }

    @GetMapping("viewAllAdmins")
    public ResponseEntity<List<Admin>> viewAllAdmins() {
        return new ResponseEntity<>(service.viewAllAdmins(), HttpStatus.OK);
    }

    @GetMapping("getAdminById/{adminId}")
    public ResponseEntity<Admin> getAdminById(@PathVariable int adminId) {
        Admin admin = service.getAdminById(adminId);
        if (admin != null) {
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("updateAdminById/{adminId}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable int adminId, @RequestBody Admin adminDetails) {
        Admin updatedAdmin = service.updateAdmin(adminId, adminDetails);
        if (updatedAdmin != null) {
            return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("toggleAdminAccess/{hotelId}")
    public ResponseEntity<Hotel> toggleAdminAccess(@PathVariable int hotelId) {
        try {
            Hotel updatedHotel = service.toggleAdminAccess(hotelId);
            return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
        } catch (HotelNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




    @DeleteMapping("deleteAdminById/{adminId}")
    public ResponseEntity<String> deleteAdmin(@PathVariable int adminId) {
        service.deleteAdmin(adminId);
        return new ResponseEntity<>("Admin successfully deleted.", HttpStatus.OK);
    }
}