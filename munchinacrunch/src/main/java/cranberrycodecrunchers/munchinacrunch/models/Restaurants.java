package cranberrycodecrunchers.munchinacrunch.models;

@RestaurantEntity
public class Restaurants {
    private Long id;
    private String name;
    private String address;
    private String cuisineType;
    private String ambience;

    // Constructors
    public Restaurants() {

    }

    public Restaurants(String name, String address, String cuisineType,
                       String ambience) {
        this.name = name;
        this.address = address;
        this.cuisineType = cuisineType;
        this.ambience = ambience;
    }

    //getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public String getAmbience() {
        return ambience;
    }

    public void setAmbience(String ambience) {
        this.ambience = ambience;
    }
}