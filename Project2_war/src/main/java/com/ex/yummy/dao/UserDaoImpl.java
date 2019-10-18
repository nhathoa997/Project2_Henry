package com.ex.yummy.dao;

import com.ex.yummy.entities.Users;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ,
    propagation = Propagation.REQUIRES_NEW)
    public Users getById(int id) {
        return null;
    }

    @Override
    @Transactional(readOnly=true, isolation= Isolation.REPEATABLE_READ,
            propagation= Propagation.REQUIRES_NEW)
    public Users getByUserName(String userName) {
        return null;
    }

    @Override
    @Transactional(readOnly=true, isolation= Isolation.REPEATABLE_READ,
            propagation= Propagation.REQUIRES_NEW)
    public Users getByEmail(String email) {
        return null;
    }
}
