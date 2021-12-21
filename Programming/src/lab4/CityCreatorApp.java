package lab4;

import lab4.exceptions.InvalidCommandException;
import lab4.location.City;
import lab4.location.Region;
import lab4.location.Settlement;
import lab4.organisms.*;

import java.util.Arrays;

public class CityCreatorApp {
    public static void main(String[] args) throws InvalidCommandException {
        // create ancients
        Ancient ancient1 = new Ancient("Нерей", 120, Arrays.asList(Traits.DECADENT, Traits.CLEVER, Traits.MASTER));
        Ancient ancient2 = new Ancient("Протей", 119, Arrays.asList(Traits.DECADENT, Traits.CLEVER));

        // create region
        Region gloomySea = new Region("Мрачное море", "Magic", "Вода");
        City city = new City("Рагни", 10, gloomySea, Arrays.asList(ancient1, ancient2));
        Settlement village = new Settlement("Рифтен", 3, gloomySea);

        // create village
        village.spawnBuilding(Buildings.HOUSE);
        village.spawnBuilding(Buildings.HOUSE);
        village.spawnBuilding(Buildings.MARKET);
        village.spawnBuilding(Buildings.STABLE);
        village.spawnBuilding(Buildings.TAVERN);

        // create builders from village
        Builder builder1 = new Builder("Иоханн", 24, Arrays.asList(Traits.HARDWORKING, Traits.KINDLY), village, 100, 100);
        Builder builder2 = new Builder("Рогир", 20, Arrays.asList(Traits.HARDWORKING), village, 100, 100);
        builder1.getBackpack().addItem(Items.PLASMA);
        builder1.getBackpack().addItem(Items.PLASMA);
        builder2.getBackpack().addItem(Items.PLASMA);

        // create humans from village
        Human human1 = new Human("Симон", 28, "Конюх", village, 100, 50);

        // create humans from city
        Human citizen1 = new Human("Рандольф", 21, "Трактирщик", city, 1000, 150);
        Human citizen2 = new Human("Осберт", 24, "Лесоруб", city, 70, 80);
        Human citizen3 = new Human("Годвин", 29, "Лесоруб", city, 100, 80);
        Human citizen4 = new Human("Эддрик", 19, "Рыбак", city, 200, 60);
        Human citizen5 = new Human("Лейк", 19, "Рыбак", city, 200, 60);

        // move builders from village to city
        builder1.changeCity(city);
        builder2.changeCity(city);

        // build shoggots and glowworms
        Shoggot shoggot1 = (Shoggot) ancient1.giveCommand(builder1, "Shoggot");
        Shoggot shoggot2 = (Shoggot)ancient1.giveCommand(builder1, "Shoggot");
        Shoggot shoggot3 = (Shoggot)ancient1.giveCommand(builder1, "Shoggot");
        Shoggot shoggot4 = (Shoggot)ancient2.giveCommand(builder2, "Shoggot");
        Glowworm glowworm1 = (Glowworm) ancient2.giveCommand(builder2, "Glowworm");

        // build buildings
        ancient1.giveCommand(shoggot1, "Mine");
        ancient1.giveCommand(shoggot2, "H");
        ancient1.giveCommand(shoggot3, "M");
        System.out.println(glowworm1.getLight());

        ancient1.writeHistory("\nГлава первая\nНачинаем постройку города");
        System.out.println(ancient1.getRelliefText());

        System.out.println(city.getBuildingNamesList().toString());
        System.out.println("Строящиеся здания в городе:");
        System.out.println(city.getUnderConstruction().toString());

        // waiting a new building
        World world = new World(Arrays.asList(city, village), Arrays.asList(builder1, builder2, citizen1, citizen2, citizen3, citizen4, citizen5));
        world.skipDays(40);

        System.out.println(city.getBuildingNamesList().toString());
        System.out.println("Строящиеся здания в городе:");
        System.out.println(city.getUnderConstruction().toString());
        System.out.println(city.getResources());

        world.skipDays(1000);
        System.out.println(city.getResources());

        ancient1.giveCommand(shoggot2, "H");
        ancient1.giveCommand(shoggot3, "M");
        ancient1.giveCommand(shoggot2, "H");
        ancient1.giveCommand(shoggot3, "M");
        System.out.println(city.getBuildingNamesList().toString());
        System.out.println("Строящиеся здания в городе:");
        System.out.println(city.getUnderConstruction().toString());
        System.out.println(city.getResources());
        world.skipDays(1000);
        System.out.println(city.getBuildingNamesList().toString());
        System.out.println("Строящиеся здания в городе:");
        System.out.println(city.getUnderConstruction().toString());
        System.out.println(city.getResources());

    }
}
