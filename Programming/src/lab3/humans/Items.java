package lab3.humans;

public enum Items {
    BLANKET("Одеяло"),
    PYJAMAS("Пижама"),
    STREET_CLOTHES("Уличная одежда");

    private final String name;

    Items(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
