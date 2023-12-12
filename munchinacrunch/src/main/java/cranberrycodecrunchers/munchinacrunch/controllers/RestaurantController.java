package cranberrycodecrunchers.munchinacrunch.controllers;
import cranberrycodecrunchers.munchinacrunch.models.RestaurantsService;
import cranberrycodecrunchers.munchinacrunch.models.Restaurants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//why is this underlined?
public class RestaurantController {

    private final RestaurantsService restaurantService;

    public RestaurantController(RestaurantsService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public ResponseEntity<List<Restaurants>> getAllRestaurants() {
        List<Restaurants> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<List<Restaurants>>(restaurants, HttpStatus.OK);
    }
}