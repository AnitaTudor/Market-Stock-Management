package Model;

public class Provider {
    private final Integer id;
    private String name;
    private Location location;
    private Description description;

    public Provider(Integer id, String name, Location location, Description description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }
}
