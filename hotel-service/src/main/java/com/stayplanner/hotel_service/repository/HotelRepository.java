package com.stayplanner.hotel_service.repository;

import com.stayplanner.hotel_service.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {
    List<Hotel> findByStateAndCity(String state, String city);

    List<Hotel> findByState(String state);

    List<Hotel> findByCity(String city);
    List<Hotel> findByOwnerName(String ownerName);
    List<Hotel> findByAcTrue();
    List<Hotel> findByWifiTrue();
    List<Hotel> findByMaintainanceTrue();
    List<Hotel> findBySingleRoomsGreaterThan(int number);
    List<Hotel> findByDoubleRoomsGreaterThan(int number);
    List<Hotel> findByTripleRoomsGreaterThan(int number);
}
