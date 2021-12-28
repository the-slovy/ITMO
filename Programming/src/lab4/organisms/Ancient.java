package lab4.organisms;

import lab4.Descriptions;
import lab4.HasName;
import lab4.Traits;
import lab4.exceptions.InvalidCommandException;
import lab4.exceptions.OrganismCreateException;
import sun.security.krb5.internal.crypto.Des;

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
            try {
                return ((Builder) worker).createShoggot();
            } catch (OrganismCreateException e) {
                System.out.println(e.getMessage());
            }
        } else if (command.equals("Glowworm") && worker.getClass().getSimpleName().equals("Builder")) {
            try {
            return ((Builder) worker).createGlowworm();
            } catch (OrganismCreateException e) {
                System.out.println(e.getMessage());
            }
        } else if (worker.getClass().getSimpleName().equals("Shoggot") && Arrays.asList("Mine", "WoodCutter", "M", "H", "T", "S").stream().anyMatch(i -> i.equals(command))) {
            try {
                ((Shoggot) worker).buildBuilding(command);
            } catch (InvalidCommandException e) {
                System.out.println(e.getMessage());
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
    public String toString() {
        return "Это " + getTypeName() + ", его имя " + getName() + ", его возраст " + getAge() + " лет";
    }

    @Override
    public Descriptions getDescription() {
        return Descriptions.INTELLIGENCE;
    }

    @Override
    public String getLocation() {
        return "У старца нет дома, он гражданин мира";
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
