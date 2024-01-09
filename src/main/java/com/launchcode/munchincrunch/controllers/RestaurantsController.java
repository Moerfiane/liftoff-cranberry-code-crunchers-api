package com.launchcode.munchincrunch.controllers;


import com.launchcode.munchincrunch.models.Restaurant;
import com.launchcode.munchincrunch.models.Restaurants;
import com.launchcode.munchincrunch.services.RestaurantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RestaurantsController {

  @Autowired
  private RestaurantsService restaurantsService;

  @GetMapping("/restaurants/{location}")
    public List<Restaurant> searchRestaurants(@PathVariable String location) {
     return  restaurantsService.searchRestaurants(location);
  }
}
