package com.launchcode.munchincrunch.models;

import java.util.List;

public class Restaurants {
    public List<Restaurant> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Restaurant> businesses) {
        this.businesses = businesses;
    }

    private List<Restaurant> businesses;
}
