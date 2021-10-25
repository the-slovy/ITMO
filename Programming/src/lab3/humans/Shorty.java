package lab3.humans;

import lab3.place.locations.Location;

import java.util.ArrayList;
import java.util.List;

public class Shorty extends AbstractShorty implements Humanable {
    private boolean isSleeping;
    private Location totalLocation;
    private List<Items> items;

    public Shorty(Location startLocation) {
        super();
        setAge(20);
        items = new ArrayList<>();

        startLocation.addShortyToLocation(this);
    }

    public Shorty(String name, int age, int speed, Location startLocation) {
        super(name, age);
        setSpeed(speed);
        items = new ArrayList<>();

        startLocation.addShortyToLocation(this);
    }

    public void addItem(Items item) {
        items.add(item);
    }

    public void removeItem(Items item) {
        if (items.contains(item)) {
            items.remove(item);
            System.out.println("Предмет " + item + " удален");
        } else System.out.println("Такой предмет не найден");
    }

    public void setTotalLocation(Location location) {
        totalLocation = location;
    }

    @Override
    public void runToLocation(Location location) {
        totalLocation.deleteShortyFromLocation(this);
        location.addShortyToLocation(this);
        totalLocation = location;
    }

    @Override
    public void sleep() {
        if (isSleeping) {
            System.out.println("Уже спит");
        } else {
            if (items.contains(Items.BLANKET) && items.contains(Items.PYJAMAS)) {
                isSleeping = true;
                System.out.println(getName() + " заснул");
            } else {
                System.out.println("У коротышки: " + getName() + " нет пижамы или одеяла, а без этого плохо спится");
            }
        }
    }

    @Override
    public void wakeUp() {
        if (isSleeping) {
            isSleeping = false;
            System.out.println(getName() + " проснулся и огляделся");
        } else {
            System.out.println(getName() + " не спал");
        }
    }

    @Override
    public void run() {
        System.out.println(getName() + " бежит по локации " + totalLocation.getName());
    }
}
