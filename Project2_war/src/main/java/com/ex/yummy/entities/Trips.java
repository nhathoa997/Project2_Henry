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
@Table(name="Trips")

public class Trips {
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

    public Trips(String restaurantName, double longitude, double latitude, int tripRating) {
        this.restaurantName = restaurantName;
        this.longitude = longitude;
        this.latitude = latitude;
        this.tripRating = tripRating;
    }

    @Column(name="trip_rating")


    private int tripRating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getTripRating() {
        return tripRating;
    }

    public void setTripRating(int tripRating) {
        this.tripRating = tripRating;
    }
}
