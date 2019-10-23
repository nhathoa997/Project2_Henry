package com.ex.yummy.dao;

import com.ex.yummy.entities.Doop;
import com.ex.yummy.entities.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;

@Configuration
@Transactional
@Repository
public class FunSearchDaoImpl implements FunSearchDao {
    SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ,
            propagation = Propagation.REQUIRES_NEW)
    public Doop getDoop(int id){
        Session session = this.sessionFactory.openSession();

        String hql = "From Doop where id = :x";


        Query q = session.createQuery(hql);
        q.setInteger("x",id);
        Doop doop = (Doop)q.list().get(0);
        System.out.println(doop);
        System.out.println(doop.getId());
        System.out.println(doop.getLink());
        session.close();
        return doop;

    }
}
