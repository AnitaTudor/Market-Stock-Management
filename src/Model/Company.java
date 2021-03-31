package Model;

public class Company {
    private final Integer id;
    private String name;
    private Long marketCap;
    private String website;
    private Location location;

    public Company(Integer id, String name, Long marketCap,String website, Location location){

        this.id= id;
        this.name=name;
        this.marketCap=marketCap;
        this.website= website;
        this.location= location;
    }

    public Integer getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public Long getMarketCap() {
        return marketCap;
    }

    public String getWebsite() {
        return website;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarketCap(Long marketCap) {
        this.marketCap = marketCap;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marketCap=" + marketCap +
                ", website='" + website + '\'' +
                '}';
    }
}
