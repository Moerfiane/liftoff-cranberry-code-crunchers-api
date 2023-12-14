package org.cranberrycodecrunchers.munchinacrunch.controllers;
import org.cranberrycodecrunchers.munchinacrunch.models.FavoriteRestaurant;
import org.cranberrycodecrunchers.munchinacrunch.models.services.FavoriteRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
public class FavoriteRestaurantController {

    @Autowired
    private FavoriteRestaurantService favoriteRestaurantService;

    @PostMapping("/add")
    public ResponseEntity<?> addFavoriteRestaurant(@RequestBody FavoriteRestaurant restaurant) {
        // Implement logic to add the restaurant to the user's favorites
        // Use the user's authentication information to associate the restaurant with the correct user
        favoriteRestaurantService.addFavoriteRestaurant(restaurant);
        return ResponseEntity.ok("Restaurant added to favorites.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<FavoriteRestaurant>> getFavoriteRestaurants() {
        // Implement logic to retrieve the list of favorite restaurants for the logged-in user
        List<FavoriteRestaurant> favorites = favoriteRestaurantService.getFavoriteRestaurants();
        return ResponseEntity.ok(favorites);
    }

    // Implement similar methods for removing and managing favorite restaurants
}
