package com.launchcode.munchincrunch.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "favorite_restaurants") //maps to MySQL
public class FavoriteRestaurantEntity {
    @Id //primary key for fav rest. table
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;
    private double rating;
    private String address;
    private String number;

// Constructors, getters, setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        // Set rating only if it's greater than or equal to 4
        if (rating >= 4) {
            this.rating = rating;
        } else {
            throw new IllegalArgumentException("Rating must be 4 or higher.");
        }
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}