package com.company.services;

import com.company.data.dao.EmpRepositoryImpl;
import com.company.data.dao.ManagerRepositoryImpl;
import com.company.models.EmployeeInfo;
import com.company.models.ManagerInfo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class Authenticate {
    private ManagerRepositoryImpl man_dao;
    private EmpRepositoryImpl dao;

    public Authenticate() throws SQLException, ClassNotFoundException {
    }

    public String authenticate(HttpServletRequest request) throws SQLException, ClassNotFoundException {
        String userName = request.getParameter("emp_userName");
        String password = request.getParameter("emp_password");
        String position = "employee";
        if (userName == null || password == null){
            userName = request.getParameter("manager_userName");
            password = request.getParameter("manager_password");
            position = "manager";
        }

        if (position.equals("employee")){
            dao = new EmpRepositoryImpl();
            EmployeeInfo user = dao.findUserName(userName);
            if ((user != null) && user.getPassword().equals(password)) return "employeeHomePage.html";
            else return "LoginPage.html";
        }
        else if (position.equals("manager")){
            man_dao = new ManagerRepositoryImpl();
            ManagerInfo user = man_dao.findUserName(userName);
            if ((user!= null) && user.getPassword().equals(password)) return "managerHomePage.html";
            else return "LoginHomePage.html";
        }
        return "LoginHomePage.html";
    }
    public boolean authenticate(String userName) throws SQLException, ClassNotFoundException {

        dao = new EmpRepositoryImpl();
        EmployeeInfo user = dao.findUserName(userName);
        if ((user != null)) return true;
        else return false;
    }
}
