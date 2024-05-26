package com.stayplanner.auth_service.services;

import com.stayplanner.auth_service.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> store = new ArrayList<>() ;
    public UserService(){
        store.add(new User(UUID.randomUUID().toString(),"Rohith","rohith@mail.com")) ;
        store.add(new User(UUID.randomUUID().toString(),"Suresh","sureah@mail.com")) ;
        store.add(new User(UUID.randomUUID().toString(),"Mayank","Mayank@mail.com")) ;
        store.add(new User(UUID.randomUUID().toString(),"Shiva","shiva@mail.com")) ;

    }
    public List<User> getUser(){
        return this.store ;
    }
}
