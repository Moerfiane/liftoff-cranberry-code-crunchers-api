package org.cranberrycodecrunchers.munchinacrunch.controllers;
import org.cranberrycodecrunchers.munchinacrunch.models.UserEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId) {
        // Implement logic to retrieve and return user information
        return "User with ID " + userId;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody UserEntity userEntity) {
        // Implement logic to create a new user
        return "User created";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable Long userId, @RequestBody UserEntity userEntity) {
        // Implement logic to update user information
        return "User updated";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        // Implement logic to delete a user
        return "User deleted";
    }
}