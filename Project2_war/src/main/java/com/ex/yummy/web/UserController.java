package com.ex.yummy.web;

import com.ex.yummy.services.Authentication;
import com.ex.yummy.services.Register;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/login")
public class UserController {
    Authentication auth;
    Register register;

    @Autowired
    public UserController(Authentication auth, Register register) {
        this.auth = auth;
        this.register = register;
    }

    @PostMapping(path = "/authentication")
    public void loginUser(HttpServletRequest request, HttpServletResponse response){

        String user_name = request.getParameter("user_name");
        String password = request.getParameter("password");
        if (auth.authenticate(user_name, password)){
            System.out.println("Authentication successful!");
        }
        else System.out.println("Authentication failed");
    }
    @PostMapping(path = "/register")
    public void registerUser(HttpServletRequest request, HttpServletResponse response){

        String user_name = request.getParameter("user_name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        int zip = Integer.parseInt(request.getParameter("zip"));
        register.create(user_name, password, email, zip);
        System.out.println("A new user has been created!");
    }



    
}
