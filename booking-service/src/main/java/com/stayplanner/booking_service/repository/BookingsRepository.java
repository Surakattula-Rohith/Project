package com.stayplanner.booking_service.repository;

import com.stayplanner.booking_service.model.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings,Integer> {
}
