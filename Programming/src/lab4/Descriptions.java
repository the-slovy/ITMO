package lab4;

public enum Descriptions {
    DARK("Мрачное"),
    BIG("Фантастически большой"),
    INTELLIGENCE("Неимоверно умный"),
    ACCURATE("Точный"),
    FASTER("Молниеносный"),
    MELODIC("Мелодичный"),
    ORGANISTIC("Организм"),
    SHORTIES("Коротышка"),
    VILLAGE("Селение");
    private final String name;

    Descriptions(String name) {
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
