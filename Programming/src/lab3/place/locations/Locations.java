package lab3.place.locations;

public enum Locations {
    ROOM("Комната"),
    YARD("Двор"),
    HANGAR("Ангар"),
    RUINS("Развалины");

    private final String name;
    Locations(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
