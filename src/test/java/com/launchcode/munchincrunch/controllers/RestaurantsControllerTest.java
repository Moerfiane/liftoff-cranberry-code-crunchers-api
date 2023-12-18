package com.launchcode.munchincrunch.controllers;

import com.launchcode.munchincrunch.models.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestaurantsControllerTest {
    @Test
    public void testSearchRestaurants() {
        String location = "nyc";
        RestaurantsController restaurantsController = new RestaurantsController();
        List<Restaurant> restaurants = restaurantsController.searchRestaurants(location);
        assertFalse(restaurants.isEmpty());
    }

}
