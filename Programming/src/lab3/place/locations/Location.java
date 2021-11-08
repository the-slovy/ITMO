package lab3.place.locations;

import lab3.humans.Shorty;
import lab3.place.AbstractPlace;

import java.util.ArrayList;
import java.util.List;

public class Location extends AbstractPlace implements Locatable {
    private List<Shorty> shorties;
    private LocationType type;

    public Location(String name, int capacity, LocationType type) {
        super(name, capacity);
        this.type = type;
        this.shorties = new ArrayList<>();

        System.out.println("Заспавнена локация " + name + ". Вместимость локации " + capacity);
    }

    @Override
    public void addShortyToLocation(Shorty shorty) {
        if (shorties.contains(shorty)) {
            System.out.println(shorty.getName() + " уже на локации");
        } else if (shorties.size() < getCapacity()) {
            System.out.println("Коротышка " + shorty.getName() + " вошел в локацию " + getName());
            shorties.add(shorty);
            shorty.setTotalLocation(this);
        } else System.out.println("В локации больше нет мест");
    }

    @Override
    public void deleteShortyFromLocation(Shorty shorty) {
        if (shorties.contains(shorty)) {
            shorties.remove(shorty);
            System.out.println("Коротышка " + shorty.getName() + " покинул локацию");
        } else {
            System.out.println("Коротышка " + shorty.getName() + " не находится здесь");
        }
    }

    public LocationType getType() {
        return type;
    }

    public void changeType(LocationType type) {
        System.out.println("Локация " + this.type + " теперь " + type);
        this.setName(type.toString());
        this.type = type;
    }

    public List<Shorty> getShorties() {
        return shorties;
    }
}
