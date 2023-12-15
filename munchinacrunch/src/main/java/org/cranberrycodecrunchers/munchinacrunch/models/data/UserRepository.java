package org.cranberrycodecrunchers.munchinacrunch.models.data;

import org.cranberrycodecrunchers.munchinacrunch.models.UserEntity;
import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findByUsername(String username);
}
