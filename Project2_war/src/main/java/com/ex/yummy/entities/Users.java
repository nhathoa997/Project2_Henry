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
@Table


public class Users {
    public Users(String userName, String email, String password, int zipCode, ArrayList<Trips> trips) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.zipCode = zipCode;
        this.trips = trips;
    }
    public Users(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

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

//    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name="preferences", referencedColumnName = "preference_id", columnDefinition = "INT")
//    private Preferences preferences;
//
//    @OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="trips", referencedColumnName = "trip_id", columnDefinition = "INT")
    private ArrayList<Trips> trips;







}
