package com.launchcode.munchincrunch.controllers;

import com.launchcode.munchincrunch.models.Restaurant;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RestaurantsControllerTest {
    @Test
    public void testSearchRestaurants(){
        //input
        String location = "nyc";

        // call
     RestaurantsController restaurantsController = new RestaurantsController();
    List<Restaurant> restaurants = restaurantsController.searchRestaurants(location);


        //verification

      assertFalse(restaurants.isEmpty());



    }

}
