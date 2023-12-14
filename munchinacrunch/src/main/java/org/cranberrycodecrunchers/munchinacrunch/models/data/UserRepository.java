package org.cranberrycodecrunchers.munchinacrunch.models.data;
import org.cranberrycodecrunchers.munchinacrunch.models.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
}