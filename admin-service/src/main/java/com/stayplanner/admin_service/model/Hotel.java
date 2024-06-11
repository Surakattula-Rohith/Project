package com.stayplanner.admin_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity()
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId ;
    private String hotelName ;
    private String state;
    private String city ;
    private String address ;
    private String gstNumber ;
    private String ownerName ;
    private String description ;
    private boolean ac ;
    private boolean wifi;
    private boolean maintainance;
    private int singleRooms;
    private int doubleRooms ;
    private int tripleRooms ;

}