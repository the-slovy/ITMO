package lab4;

public enum Items {
    BLANKET("Одеяло"),
    PYJAMAS("Пижама"),
    PLASMA("Протоплазма"),
    STREET_CLOTHES("Уличная одежда"),
    STONE("Камень"),
    WOOD("Дерево");

    private final String name;

    Items(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}