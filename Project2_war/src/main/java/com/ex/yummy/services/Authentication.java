package com.ex.yummy.services;

import com.ex.yummy.dao.UserDao;
import com.ex.yummy.dao.UserDaoImpl;
import com.ex.yummy.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service()
public class Authentication {
    UserDao dao;

    @Autowired
    public Authentication(UserDao user_dao) {
        this.dao = user_dao;
    }

    public boolean authenticate(String userName, String password){
        Users user = dao.getByUserName(userName);
        if (user != null){
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)){
                return true;
            }
            return false;
        }
        return false;
    }

}
