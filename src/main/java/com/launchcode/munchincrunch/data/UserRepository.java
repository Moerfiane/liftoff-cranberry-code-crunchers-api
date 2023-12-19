package com.launchcode.munchincrunch.data;

import com.launchcode.munchincrunch.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}