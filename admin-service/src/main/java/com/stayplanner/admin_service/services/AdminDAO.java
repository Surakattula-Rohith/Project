package com.stayplanner.admin_service.services;

import com.stayplanner.admin_service.exception.HotelNotFoundException;
import com.stayplanner.admin_service.exception.RoomsUnavailable;
import com.stayplanner.admin_service.model.Admin;
import com.stayplanner.admin_service.model.Hotel;

import java.util.List;

public interface AdminDAO {

    Admin addAdmin(Admin admmin) throws RoomsUnavailable;
    List<Admin> viewAllAdmins();
    Admin updateAdmin(int adminId, Admin admin) ;
    void deleteAdmin(int adminId) ;
    Admin getAdminById(int adminId);
    Hotel toggleAdminAccess(int hotelId) throws HotelNotFoundException;

}
