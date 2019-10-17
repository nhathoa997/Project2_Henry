package com.ex.yummy;


import com.ex.yummy.dao.UserDaoImpl;
import com.ex.yummy.entities.Preferences;
import com.ex.yummy.entities.Trips;
import com.ex.yummy.entities.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;


public class Main {
    SessionFactory sessionFactory;
    int bearId = 0;
    public static void main(String[] args){
        Main m = new Main();
        m.configure();
        m.initEntities();

        UserDaoImpl dao = new UserDaoImpl();
        m.sessionFactory.close();
    }
    private void configure() {
        //create our config object
        final Configuration config = new Configuration().configure();
        final StandardServiceRegistryBuilder builder =
                new StandardServiceRegistryBuilder().applySettings(config.getProperties());
        this.sessionFactory = config.buildSessionFactory(builder.build());
    }

    private void initEntities() {
        Users user = new Users(); // bear is transient
        user.setEmail("hoadinh997@gmail.com");
        user.setUserName("Henry Dinh");
        user.setPassword("password");
        user.setZipCode(92721);

        Users user2 = new Users(); // bear is transient
        user2.setEmail("user2@gmail.com");
        user2.setUserName("David Locanthi");
        user2.setPassword("password");
        user2.setZipCode(93065);

        Preferences pref = new Preferences();
        pref.setUserName(user.getUserName());

        Preferences pref2 = new Preferences();
        pref2.setUserName(user2.getUserName());

        Trips trip = new Trips();
        trip.setRestaurantName("Panda Express");
        trip.setLatitude(99.98);
        trip.setLatitude(123.456);

        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        this.bearId = (Integer)session.save(user); // bear becomes persistent
//        this.bearId = (Integer)session.save(user2); // bear becomes persistent
//        this.bearId = (Integer)session.save(user); // bear becomes persistent
//        this.bearId = (Integer)session.save(user); // bear becomes persistent


        tx.commit();
        session.close();

        // bear is now detached
    }
}
