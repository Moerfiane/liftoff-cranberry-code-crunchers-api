package org.cranberrycodecrunchers.munchinacrunch.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    private Object GenerationType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String username;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "favorite_restaurants",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "restaurants_id")
    )

    private List<FavoriteRestaurant> favoriteRestaurant;

    // Constructors, getters, setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
