package lab4;

public enum Buildings {
    HOUSE("Дом", 1, "H"),
    TAVERN("Таверна", 3, "T"),
    MARKET("Рынок", 5, "M"),
    STABLE("Конюшня", 5, "S"),
    MINE("Шахта", 10,"O", Items.STONE);

    String name;
    int requiredTime;
    String symbol;
    Items items;

    Buildings(String name, int requiredTime, String symbol) {
        this.name = name;
        this.requiredTime = requiredTime;
        this.symbol = symbol;
        items = null;
    }

    Buildings(String name, int requiredTime, String symbol, Items items) {
        this.name = name;
        this.requiredTime = requiredTime;
        this.symbol = symbol;
        this.items = items;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(int requiredTime) {
        this.requiredTime = requiredTime;
    }

    public Items getResourses() {
        return items;
    }
}
