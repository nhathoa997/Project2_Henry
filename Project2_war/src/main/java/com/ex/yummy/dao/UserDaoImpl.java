package com.ex.yummy.dao;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.awt.print.Book;
import java.sql.*;



@Repository("user_dao")
public class UserDaoImpl implements UserDao {


    public UserDaoImpl() {
        System.out.println("Creating UserDao Bean");
    }

    private static SessionFactory sessionFactory;
    @Autowired
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void saveUserInfo(Users new_user){
        Session session = sessionFactory.getCurrentSession();
        session.persist(new_user);
    }


    @Override
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ,
    propagation = Propagation.REQUIRES_NEW)
    public Users getById(int id) throws SQLException {

        Users new_user = null;
        String sql = "SELECT * FROM Users WHERE id = " + id;
//        java.sql.Connection conn = DriverManager.getConnection("jdbc:postgresql://henrydinh.cdrs9lfdhqu1.us-east-2.rds." +
//                "amazonaws.com:5432/henrydb?user=henry_dinh&password=Henry8354392.");
//
//        Statement statement = conn.createStatement();
//        statement.execute(sql);
//        Statement statement = Connection.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
        return null;
    }

    @Override
    @Transactional(readOnly=true, isolation= Isolation.REPEATABLE_READ,
            propagation= Propagation.REQUIRES_NEW)
    public Users getByUserName(String userName) {

        Session session = this.sessionFactory.openSession();

        String hql = "From Users where userName = :x";


        Query q = session.createQuery(hql);
        q.setString("x",userName);
        Users user = (Users)q.list().get(0);
        session.close();
        return user;
    }


    @Override
    @Transactional(readOnly=true, isolation= Isolation.REPEATABLE_READ,
            propagation= Propagation.REQUIRES_NEW)
    public Users getByEmail(String email) {
        Session session = this.sessionFactory.openSession();

        String hql = "From Users where email = :x";


        Query q = session.createQuery(hql);
        q.setString("x",email);
        Users user = (Users)q.list().get(0);
        session.close();
        return user;
    }
}
