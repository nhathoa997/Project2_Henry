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
        String hql = "From Doop where id = :x " ;

        Query q = session.createQuery(hql);
        q.setString("x", Integer.toString(num)); //dont ask...(Dark Magic)
        Doop doop = (Doop)q.list().get(0);
        session.close();
        return doop;

    }
}
