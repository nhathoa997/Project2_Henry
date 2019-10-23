package com.ex.yummy.dao;

import com.ex.yummy.entities.Users;

import java.sql.SQLException;

public interface UserDao {
    Users getById (int id) throws SQLException;
    Users getByUserName(String userName);
    Users getByEmail(String email);
    void saveUserInfo(Users user);
}
