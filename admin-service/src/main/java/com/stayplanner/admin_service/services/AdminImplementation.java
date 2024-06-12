package com.stayplanner.admin_service.services;

import com.stayplanner.admin_service.exception.HotelNotFoundException;
import com.stayplanner.admin_service.exception.RoomsUnavailable;
import com.stayplanner.admin_service.fiegn.AdminFeign;
import com.stayplanner.admin_service.model.Admin;
import com.stayplanner.admin_service.model.Hotel;
import com.stayplanner.admin_service.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminImplementation implements AdminDAO {

    @Autowired
    private AdminRepository repo;

    @Autowired
    AdminFeign adminFeign ;

    @Override
    public Admin addAdmin(Admin admin) throws RoomsUnavailable {
        return repo.save(admin);
    }

    @Override
    public List<Admin> viewAllAdmins() {
        return repo.findAll();
    }

    @Override
    public Admin updateAdmin(int adminId, Admin admin) {
        admin.setAdminId(adminId);
        return repo.save(admin);
    }

    @Override
    public void deleteAdmin(int adminId) {
        repo.deleteById(adminId);
    }

    @Override
    public Admin getAdminById(int adminId) {
        return repo.findById(adminId).get();
    }

    public Hotel toggleAdminAccess(int hotelId) throws HotelNotFoundException {
        ResponseEntity<Hotel> response = adminFeign.toggleAdminAccess(hotelId);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        } else if (response.getStatusCode().is4xxClientError()) {
            throw new HotelNotFoundException("Hotel not found with id: " + hotelId);
        } else {
            throw new RuntimeException("Failed to toggle admin access for hotel with id: " + hotelId);
        }
    }

    @Override
    public List<Hotel> findByOwnerName(String ownerName) {
        ResponseEntity<List<Hotel>> response = adminFeign.findByOwnerName(ownerName);
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return response.getBody();
        } else {
            throw new RuntimeException("Failed to find hotels by owner name: " + ownerName);
        }
    }

    @Override
    public void deleteHotel(int hotelId) throws HotelNotFoundException {
        ResponseEntity<?> response = adminFeign.deleteHotel(hotelId);
        if (!response.getStatusCode().is2xxSuccessful()) {
            if (response.getStatusCode().is4xxClientError()) {
                throw new HotelNotFoundException("Hotel not found with id: " + hotelId);
            } else {
                throw new RuntimeException("Failed to delete hotel with id: " + hotelId);
            }
        }
    }

    @Override
    public List<Hotel> getAllHotels() {
        ResponseEntity<?> response = adminFeign.getAllHotels();
        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return (List<Hotel>) response.getBody();
        } else {
            throw new RuntimeException("Failed to retrieve all hotels");
        }
    }




}
