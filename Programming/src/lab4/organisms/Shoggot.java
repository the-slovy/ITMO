package lab4.organisms;

import lab4.*;
import lab4.exceptions.InvalidCommandException;
import lab4.location.City;

import java.util.List;

public class Shoggot extends Organism {
    private int size;
    private double speed;
    private int intelligence;
    private City city;
    private Voice voice;

    public Shoggot(String name, List<Traits> traits, int size, double speed, int intelligence, City city, Builder.ShoggotRecipe recipe) {
        super(name, 0, traits);

        this.size = size;
        this.speed = speed;
        this.intelligence = intelligence;
        this.city = city;
        this.voice = new Voice();
    }

    public int getSize() {
        return size;
    }

    public double getSpeed() {
        return speed;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void buildBuilding(String buildSymbol) throws InvalidCommandException {
        voice.say("Я начинаю строить здание");
        switch (buildSymbol) {
            case "H":
                if (city.hasResource(Items.WOOD)) {
                    city.useResource(Items.WOOD);
                    city.buildBuilding(Buildings.HOUSE, speed);
                } else {
                    System.out.println("Для постройки " + Buildings.HOUSE + " нужен " + Items.WOOD);
                }
                break;
            case "S":
                if (city.hasResource(Items.WOOD)) {
                    city.useResource(Items.WOOD);
                    city.buildBuilding(Buildings.STABLE, speed);
                } else {
                    System.out.println("Для постройки " + Buildings.STABLE + " нужен " + Items.WOOD);
                }
                break;
            case "M":
                if (city.hasResource(Items.STONE)) {
                    city.useResource(Items.STONE);
                    city.buildBuilding(Buildings.MARKET, speed);
                } else {
                    System.out.println("Для постройки " + Buildings.MARKET + " нужен " + Items.STONE);
                }
                break;
            case "T":
                if (city.hasResource(Items.STONE)) {
                    city.useResource(Items.STONE);
                    city.buildBuilding(Buildings.TAVERN, speed);
                } else {
                    System.out.println("Для постройки " + Buildings.TAVERN + " нужен " + Items.STONE);
                }
                break;
            case "Mine":
                city.buildSpecialBuilding(Buildings.MINE, speed);
                break;
            case "WoodCutter":
                city.buildSpecialBuilding(Buildings.WOODCUTTER, speed);
                break;
            default:
                throw new InvalidCommandException("НЕТ ТАКОЙ КОМАНДЫ");
        }

    }

    public City getCity() {
        return city;
    }

    @Override
    public Descriptions getDescription() {
        return Descriptions.BIG;
    }

    @Override
    public String getLocation() {
        return "Находится в " + getCity().getName();
    }

    public static class Voice implements HasDescription {
        public void say(String phrase) {
            System.out.println("Шоггот сказал: " + phrase + ", его голос был " + getDescription().toString());
        }

        @Override
        public Descriptions getDescription() {
            return Descriptions.MELODIC;
        }

        @Override
        public String getLocation() {
            return "Внутри шоггота";
        }
    }
}
