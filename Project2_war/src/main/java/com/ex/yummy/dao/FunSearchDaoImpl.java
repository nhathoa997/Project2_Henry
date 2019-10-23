package com.ex.yummy.dao;

import com.ex.yummy.entities.Doop;
import com.ex.yummy.entities.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;

@Configuration
@Transactional
@Repository("fun_dao")
public class FunSearchDaoImpl implements FunSearchDao {
    private static SessionFactory sessionFactory;

    @Autowired
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ,
            propagation = Propagation.REQUIRES_NEW)
    public Doop getDoop(int num){
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        System.out.println("Hey I was at getDoop 1");
        String hql = "From Doop where id = :x " ;
        System.out.println("Hey I was at getDoop 2");

        Query q = session.createQuery(hql);
        q.setString("x", Integer.toString(num)); //dont ask...(Dark Magic)
        System.out.println(num);
        System.out.println("Hey I was at getDoop 4");
        System.out.println(q.list());
        Doop doop = (Doop)q.list().get(0);

        System.out.println("Hey I was at getDoop 5");
        System.out.println(doop);
        System.out.println(doop.getId());
//        System.out.println(doop.getLink());
        tx.commit();
        session.close();
        return doop;

    }
}
