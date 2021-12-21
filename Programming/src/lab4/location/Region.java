package lab4.location;

public class Region extends Location {
    private String country;
    private String terrain;
    public Region(String name, String country, String terrain) {
        super(name);

        this.country = country;
        this.terrain = terrain;
    }

    @Override
    public String toString() {
        return "Страна: " + country + " регион: " + getTypeName() + " территория: " + terrain;
    }

    public String getCountry() {
        return country;
    }

    public String getTerrain() {
        return terrain;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
