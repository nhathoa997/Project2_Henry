package com.ex.yummy;

import com.ex.yummy.dao.UserDaoImpl;
import com.ex.yummy.entities.Trips;
import com.ex.yummy.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.support.WebApplicationContextUtils;


import javax.security.auth.login.Configuration;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Component
@Scope(value="session")
public class Main {


    @Autowired
    public static SessionFactory sessionFactory(UserDaoImpl dao){
        return dao.getSessionFactory();
    }

    public static void main(String[] args) {
        UserDaoImpl dao = new UserDaoImpl();
        SessionFactory session_factory = sessionFactory(dao);
        ArrayList<Trips> trips = new ArrayList<>();
        Trips trip = new Trips("Panda Express", 56.23,23.23, 9);
        trips.add(trip);
        Users new_user = new Users("Henry Dinh", "abc@gmail.com", "password", 93065, trips);
        dao.saveUserInfo(new_user);



    }

}

