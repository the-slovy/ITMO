package lab3;

import lab3.humans.Items;
import lab3.humans.Shorty;
import lab3.humans.MainCharacter;
import lab3.place.locations.Location;
import lab3.place.locations.LocationType;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Location room = new Location("комната Знайки и Звездочкина", 2, LocationType.ROOM);
        Location yard = new Location("Двор коротышек", 100, LocationType.YARD);
        Location hangar = new Location("Ангар коротышек", 100, LocationType.HANGAR);
        System.out.println();

        TimeUnit.SECONDS.sleep(1);

        MainCharacter znaika = new MainCharacter("Знайка", 20, 10, room);
        MainCharacter zvezdochkin = new MainCharacter("Звездочкин", 20, 8, room);
        System.out.println();

        TimeUnit.SECONDS.sleep(3);

        zvezdochkin.getBackpack().addItemToBackpack(Items.BLANKET);
        zvezdochkin.getBackpack().addItemToBackpack(Items.PYJAMAS);
        System.out.println();
        znaika.getBackpack().addItemToBackpack(Items.STREET_CLOTHES);
        System.out.println();

        TimeUnit.SECONDS.sleep(3);

        znaika.sleep();
        zvezdochkin.sleep();
        System.out.println();

        TimeUnit.SECONDS.sleep(3);

        znaika.wakeUp();
        zvezdochkin.wakeUp();
        System.out.println();

        TimeUnit.SECONDS.sleep(3);

        znaika.moveToLocation(yard);
        zvezdochkin.moveToLocation(yard);
        zvezdochkin.getBackpack().addItemToBackpack(Items.STREET_CLOTHES);
        zvezdochkin.moveToLocation(yard);

        TimeUnit.SECONDS.sleep(3);

        System.out.println();
        znaika.run();
        zvezdochkin.run();
        System.out.println();

        System.out.println(yard.getType().getDescription());

        TimeUnit.SECONDS.sleep(3);

        System.out.println();
        znaika.moveToLocation(hangar);
        zvezdochkin.moveToLocation(hangar);
        System.out.println();

        TimeUnit.SECONDS.sleep(3);

        znaika.surprised();
        zvezdochkin.surprised();
        System.out.println(hangar.getType().getDescription());
        hangar.changeType(LocationType.RUINS);

        for (int i = 0; i < 2; i++) {
            Shorty shorty = new Shorty(yard);
            shorty.run();
        }
    }
}
