package org.cranberrycodecrunchers.munchinacrunch.models.data;

import org.cranberrycodecrunchers.munchinacrunch.models.FavoriteRestaurant;
import org.cranberrycodecrunchers.munchinacrunch.models.UserEntity;
import java.util.List;

public interface FavoriteRestaurantRepository {
    List<FavoriteRestaurant> findByUser(UserEntity user);

    List<FavoriteRestaurant> findAll();

    void save(FavoriteRestaurant restaurant);
}
