package com.stayplanner.admin_service.repository;

import com.stayplanner.admin_service.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
