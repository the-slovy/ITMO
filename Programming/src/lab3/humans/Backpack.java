package lab3.humans;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private final int capacity;
    private List<Items> backpack;
    private String owner;

    public Backpack(int capacity, String owner) {
        this.capacity = capacity;
        backpack = new ArrayList<>();
        this.owner = owner;
    }

    public void addItemToBackpack(Items item) {
        if (backpack.size() < capacity) {
            backpack.add(item);
            System.out.println("Предмет " + item + " помещен в рюкзак коротышке: " + owner);
        } else {
            System.out.println("В рюкзаке нет места");
        }
    }

    public Items takeItemFromBackpack(String itemName) {
        for (Items item : backpack) {
            if (item.toString().equals(itemName)) {
                System.out.println("Коротышка: " + getOwner() + " достал предмет " + itemName);
                backpack.remove(item);
                return item;
            }
        }

        System.out.println(getOwner() + "не нашел предмета в своем рюкзаке");
        return null;
    }

    public List<Items> getItems() {
        return backpack;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
