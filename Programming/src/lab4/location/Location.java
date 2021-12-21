package lab4.location;

import lab4.HasDescription;
import lab4.HasName;

public abstract class Location implements HasName, HasDescription {
    private String name;

    public Location(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Локация: " + name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getTypeName() {
        return "Абстрактная локация " + name;
    }
}
