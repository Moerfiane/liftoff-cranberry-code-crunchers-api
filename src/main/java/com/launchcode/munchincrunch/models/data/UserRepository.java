package com.launchcode.munchincrunch.models.data;

import com.launchcode.munchincrunch.models.UserEntity;
import java.util.Optional;

public interface UserRepository {
    Optional<UserEntity> findByUsername(String username);
}
