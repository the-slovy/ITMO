package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Backpack {
    private List<Items> items = new ArrayList<>();

    public Items getItem(String item) {
        List<Items> searchItems = items.stream().filter(i -> i.getName().equals(item)).collect(Collectors.toList());
        if (searchItems.isEmpty()) {
            System.out.println("Нет такого предмета: " + item);
            return null;
        } else{
            return searchItems.get(0);
        }
    }

    public void addItem(Items item) {
        items.add(item);
    }

    public void removeItem(Items item) {
        items.remove(item);
    }
}
