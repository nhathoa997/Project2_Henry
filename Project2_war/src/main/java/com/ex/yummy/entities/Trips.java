package com.ex.yummy.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table

public class Trips {
    public Trips(String restaurantName, double longitude, double latitude, int tripRating) {
        this.restaurantName = restaurantName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.tripRating = tripRating;
    }

    @Id
    @Column(name="trip_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="restaurant_name")
    private String restaurantName;
    @Column(name="longitude")
    private double longitude;
    @Column(name="latitude")
    private double latitude;
    @Column(name="trip_rating")
    private int tripRating;



}
