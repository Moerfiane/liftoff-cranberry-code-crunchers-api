package com.launchcode.munchincrunch.services;

import com.launchcode.munchincrunch.models.Restaurant;
import com.launchcode.munchincrunch.models.Restaurants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantsService {

    @Value("${api_key}")
    private String apiKey;

    @Value("${yelp_api_url}")
    private String yelpApiUrl;

    public List<Restaurant> searchRestaurants(@PathVariable String location){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        ResponseEntity<Restaurants> response = restTemplate.exchange(yelpApiUrl+"?location="+location, HttpMethod.GET,httpEntity,Restaurants.class);
        if( response.getBody()!=null){
            return  response.getBody().getBusinesses();
        }
        return new ArrayList<>();
    }

}
