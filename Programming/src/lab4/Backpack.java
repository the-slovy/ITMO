package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Backpack {
    private List<Items> items = new ArrayList<>();

    public Items getItem(String item) {
        Items searchItem = items.stream().filter(i -> i.getName().equals(item)).collect(Collectors.toList()).get(0);
        return searchItem;
    }
    public void addItem(Items item) {
        items.add(item);
    }
}
