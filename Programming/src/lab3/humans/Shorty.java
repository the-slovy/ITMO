package lab3.humans;

import lab3.place.locations.Location;

import java.util.ArrayList;
import java.util.List;

public class Shorty extends AbstractHuman implements Sleepable, Movable {
    private boolean isSleeping;
    private Location totalLocation;
    private Backpack backpack;

    public Shorty(Location startLocation) {
        super();
        setAge(20);
        backpack = new Backpack(5, getName());

        startLocation.addShortyToLocation(this);
    }

    public Shorty(String name, int age, int speed, Location startLocation) {
        super(name, age);
        setSpeed(speed);
        backpack = new Backpack(5, getName());

        startLocation.addShortyToLocation(this);
    }

    public void setTotalLocation(Location location) {
        totalLocation = location;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    @Override
    public void moveToLocation(Location location) {
        if (!location.getType().toString().equals("Комната")) {
            if (getBackpack().getItems().contains(Items.STREET_CLOTHES)) {
                totalLocation.deleteShortyFromLocation(this);
                location.addShortyToLocation(this);
                totalLocation = location;
            } else {
                System.out.println("Коротышке: " + getName() + " нужно взять одежду чтобы выйти на улицу");
            }
        }
    }

    @Override
    public void sleep() {
        if (isSleeping) {
            System.out.println("Уже спит");
        } else {
            if (backpack.getItems().contains(Items.BLANKET) && backpack.getItems().contains(Items.PYJAMAS)) {
                backpack.takeItemFromBackpack(Items.BLANKET.toString());
                backpack.takeItemFromBackpack(Items.PYJAMAS.toString());

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
