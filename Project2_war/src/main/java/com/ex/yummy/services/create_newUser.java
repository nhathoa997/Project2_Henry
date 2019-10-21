package com.ex.yummy.services;

import com.ex.yummy.entities.Trips;
import com.ex.yummy.entities.Users;

import java.util.ArrayList;

public class create_newUser {
    public void create(String userName, String password){
        ArrayList<Trips> trips = new ArrayList<Trips>();
        Users new_user = new Users(userName, password, "abc@gmail.com", 93065,trips);
        System.out.println("A new user has been created");
        
    }
}
