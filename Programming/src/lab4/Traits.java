package lab4;

public enum Traits {
    KINDLY("Добрый"),
    CLEVER("Умный"),
    DECADENT("Декантский и упаднический"),
    HARDWORKING("Трудолюбивый"),
    MASTER("Мастер");

    private final String name;

    Traits(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
