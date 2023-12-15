package org.cranberrycodecrunchers.munchinacrunch.controllers;

import org.cranberrycodecrunchers.munchinacrunch.models.FavoriteRestaurant;
import org.cranberrycodecrunchers.munchinacrunch.services.FavoriteRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteRestaurantController {

    private final FavoriteRestaurantService favoriteRestaurantService;

    @Autowired
    public FavoriteRestaurantController(FavoriteRestaurantService favoriteRestaurantService) {
        this.favoriteRestaurantService = favoriteRestaurantService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addFavoriteRestaurant(@RequestBody FavoriteRestaurant restaurant) {
        favoriteRestaurantService.addFavoriteRestaurant(restaurant);
        return ResponseEntity.ok("Restaurant added to favorites.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<FavoriteRestaurant>> getFavoriteRestaurant() {
        List<FavoriteRestaurant> favorites = favoriteRestaurantService.getFavoriteRestaurant();
        return ResponseEntity.ok(favorites);
    }

}