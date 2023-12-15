package org.cranberrycodecrunchers.munchinacrunch.services;

import org.cranberrycodecrunchers.munchinacrunch.models.FavoriteRestaurant;
import org.cranberrycodecrunchers.munchinacrunch.models.data.FavoriteRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteRestaurantService {

    private final FavoriteRestaurantRepository favoriteRestaurantRepository;

    @Autowired
    public FavoriteRestaurantService(FavoriteRestaurantRepository favoriteRestaurantRepository) {
        this.favoriteRestaurantRepository = favoriteRestaurantRepository;
    }

    public void addFavoriteRestaurant(FavoriteRestaurant restaurant) {
        // Implement logic to add the restaurant to the user's favorites
        // Use the user's authentication information to associate the restaurant with the correct user
        favoriteRestaurantRepository.save(restaurant);
    }

    public List<FavoriteRestaurant> getFavoriteRestaurant() {
        // Implement logic to retrieve the list of favorite restaurants for the logged-in user
        // You can use the user's authentication information to filter the results
        return favoriteRestaurantRepository.findAll();
    }

    // Add other methods for CRUD operations and additional business logic as needed
}