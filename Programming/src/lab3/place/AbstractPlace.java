package lab3.place;

import java.util.Objects;

public abstract class AbstractPlace {
    private final int capacity;
    private String name;

    public AbstractPlace(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlace that = (AbstractPlace) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "Локация " + name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }
}
