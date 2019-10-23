package com.ex.yummy.services;

import com.ex.yummy.dao.UserDao;
import com.ex.yummy.dao.UserDaoImpl;
import com.ex.yummy.entities.Trips;
import com.ex.yummy.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service("register")
public class Register {
    UserDao dao;

    @Autowired
    public Register(UserDao user_dao) {
        this.dao = user_dao;
    }

    public void create(String userName, String password, String email, Integer zip){
        ArrayList<Trips> trips = new ArrayList<Trips>();
        Users new_user = new Users(userName, email ,password, zip ,trips);
        dao.saveUserInfo(new_user);
        System.out.println("A new user has been created");
    }
}
