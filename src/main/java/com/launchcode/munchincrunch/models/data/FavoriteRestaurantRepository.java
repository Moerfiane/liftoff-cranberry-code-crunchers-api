package com.launchcode.munchincrunch.models.data;

import com.launchcode.munchincrunch.models.FavoriteRestaurantEntity;
import com.launchcode.munchincrunch.models.UserEntity;
import java.util.List;

public interface FavoriteRestaurantRepository {
    List<FavoriteRestaurantEntity> findByUser(UserEntity user);

    List<FavoriteRestaurantEntity> findAll();

    void save(FavoriteRestaurantEntity restaurant);
}
