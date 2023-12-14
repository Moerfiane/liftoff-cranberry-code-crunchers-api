package org.cranberrycodecrunchers.munchinacrunch.models.data;
import org.cranberrycodecrunchers.munchinacrunch.models.FavoriteRestaurant;
import org.cranberrycodecrunchers.munchinacrunch.models.User;
import java.util.List;

public interface FavoriteRestaurantRepository {
    List<FavoriteRestaurant> findByUser(User user);
}
