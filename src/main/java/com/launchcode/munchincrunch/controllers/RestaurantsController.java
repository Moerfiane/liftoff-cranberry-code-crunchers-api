package com.launchcode.munchincrunch.controllers;


import com.launchcode.munchincrunch.models.Restaurant;
import com.launchcode.munchincrunch.models.Restaurants;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantsController {

  private String API_KEY = "-3viEYwHOmenfpRiVWvs1PWXFxNVe77RQxnFUIAjyPbjePPmt2FmCapNDsEpkZr2j1I-UIPr8177APs5N64pg_9kgvuQP0-getDJPpoJaTO4mPkRjGf6-x38zLd3ZXYx";
  private String YELP_API_URL = "https://api.yelp.com/v3/businesses/search";
  @GetMapping("/restaurants/{location}")
    public List<Restaurant> searchRestaurants(@PathVariable String location){
      RestTemplate restTemplate = new RestTemplate();
      HttpHeaders headers = new HttpHeaders();
      headers.set("Authorization", "Bearer " + API_KEY);
      HttpEntity<?> httpEntity = new HttpEntity<>(headers);
      ResponseEntity<Restaurants> response = restTemplate.exchange(YELP_API_URL+"?location="+location, HttpMethod.GET,httpEntity,Restaurants.class);
     if( response.getBody()!=null){
       return  response.getBody().getBusinesses();
     }
     return new ArrayList<>();
    }
}
