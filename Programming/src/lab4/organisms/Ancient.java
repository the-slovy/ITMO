package lab4.organisms;

import lab4.HasName;
import lab4.Items;
import lab4.Traits;
import lab4.location.City;

import java.util.Arrays;
import java.util.List;

public class Ancient extends Organism implements HasName {
    Rellief rellief;

    public Ancient(String name, int age, List<Traits> traits) {
        super(name, age, traits);

        rellief = new Rellief();
    }

    public void writeHistory(String text) {
        System.out.println("Старец " + getName() + " пишет на барельефе");
        rellief.writeText(text);
    }

    public Organism giveCommand(Organism worker, String command) {
        if (command.equals("Shoggot") && worker.getClass().getSimpleName().equals("Builder")) {
            return ((Builder) worker).createShoggot();
        } else if (command.equals("Glowworm") && worker.getClass().getSimpleName().equals("Builder")) {
            return ((Builder) worker).createGlowworm();
        } else if (worker.getClass().getSimpleName().equals("Shoggot") && Arrays.asList("Mine", "M", "H", "T", "S").stream().anyMatch(i -> i.equals(command))) {
            Shoggot shoggot = (Shoggot) worker;
            if (shoggot.getSettlement().getClass().getSimpleName().equals("City") && command != "Mine") {
                City city = (City) (shoggot.getSettlement());
                if (city.hasResource(Items.STONE)) ((Shoggot) worker).buildBuilding(command);
                // TODO: exception
            } else {
                ((Shoggot) worker).buildBuilding(command);
            }
        }
        return null;
    }

    public String getRelliefText() {
        return rellief.getText();
    }

    @Override
    public String getTypeName() {
        return "Старец";
    }

    @Override
    public String getDescription() {
        return "Его черты: " + getTraits().toString() + ", они преображаются и в них появляются эпические черты.";
    }

    @Override
    public String toString() {
        return "Это " + getTypeName() + ", его имя " + getName() + ", его возраст " + getAge() + " лет";
    }

    private class Rellief {
        private String text = "Этот барельеф принадлежит: " + getName();

        public String getText() {
            return text;
        }

        public void writeText(String text) {
            this.text += text;
        }
    }
}
