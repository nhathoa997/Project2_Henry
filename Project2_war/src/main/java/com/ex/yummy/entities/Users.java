package com.ex.yummy.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@ToString

@Entity
@Table(name = "UserInfo")


public class Users {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="user_name")
    private String userName;
    private String email;
    private String password;
    @Column(name="zip_code")
    private int zipCode;

    public Users(String userName, String email, String password, int zipCode) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
    //    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="preferences", referencedColumnName = "preference_id", columnDefinition = "INT")
//    private Preferences preferences;
//
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="trips", referencedColumnName = "trip_id", columnDefinition = "INT")
//    private ArrayList<Trips> trips;

}
