package lab4.organisms;

import lab4.Backpack;
import lab4.HasName;
import lab4.Items;
import lab4.Traits;
import lab4.location.City;
import lab4.location.Settlement;

import java.util.List;

public abstract class Villager extends Organism implements HasName {
    private Backpack backpack;
    private String profession;
    private Settlement settlement;

    public Villager(String name, int age, List<Traits> traits, String profession, Settlement settlement) {
        super(name, age, traits);

        backpack = new Backpack();
        this.profession = profession;
        this.settlement = settlement;
    }

    public Villager(String name, int age, String profession, Settlement settlement) {
        super(name, age);

        this.profession = profession;
        this.settlement = settlement;
    }
    public Villager(String name, int age, Settlement settlement) {
        super(name, age);

        this.profession = "безработный";
        this.settlement = settlement;
    }

    public Backpack getBackpack() {
        return backpack;
    }

    public Items findItem(String item) {
        return backpack.getItem(item);
    }

    public boolean hasItem(String item) {
        return getBackpack().getItem(item) != null;
    }

    public void useItem(Items item) {
        // TODO: use item
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getProfession() {
        return profession;
    }

    public Settlement getSettlement() {
        return settlement;
    }

    public void changeCity(Settlement settlement) {
        System.out.println(this.getName() + " переезжает из " + getSettlement().getName() + " в " + settlement.getName());
        this.settlement = settlement;
    }

    @Override
    public String getTypeName() {
        return "Житель";
    }
}
