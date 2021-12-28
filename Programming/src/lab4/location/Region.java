package lab4.location;

import lab4.Descriptions;
import sun.security.krb5.internal.crypto.Des;

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
    public Descriptions getDescription() {
        return Descriptions.DARK;
    }

    @Override
    public String getLocation() {
        return "Находится в " + getCountry();
    }
}
