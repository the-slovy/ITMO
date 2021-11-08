package lab3.place.locations;

public enum LocationType implements HasAccident{
    ROOM("Комната"),
    YARD("Двор") {
        @Override
        public String getDescription() {
            return "Обломки деревьев падают сверху, виден столб дыма";
        }
    },
    HANGAR("Ангар") {
        @Override
        public String getDescription() {
            return "Ангар разрушен";
        }
    },
    RUINS("Развалины");

    private final String name;
    LocationType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
