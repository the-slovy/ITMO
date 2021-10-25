package lab3;

import lab3.humans.Items;
import lab3.humans.MainCharacter;
import lab3.humans.Shorty;
import lab3.place.locations.Location;
import lab3.place.locations.Locations;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Location room = new Location("комната Знайки и Звездочкина", 2, Locations.ROOM);
        Location yard = new Location("Двор коротышек", 100, Locations.YARD);
        Location hangar = new Location("Ангар коротышек", 100, Locations.HANGAR);
        System.out.println();

        TimeUnit.SECONDS.sleep(1);

        MainCharacter znaika = new MainCharacter("Знайка", 20, 10, room);
        MainCharacter zvezdochkin = new MainCharacter("Звездочкин", 20, 8, room);
        System.out.println();

        TimeUnit.SECONDS.sleep(3);

        zvezdochkin.addItem(Items.BLANKET);
        zvezdochkin.addItem(Items.PYJAMAS);
        zvezdochkin.addItem(Items.STREET_CLOTHES);

        znaika.addItem(Items.STREET_CLOTHES);

        TimeUnit.SECONDS.sleep(3);

        znaika.sleep();
        zvezdochkin.sleep();
        System.out.println();

        TimeUnit.SECONDS.sleep(3);

        znaika.wakeUp();
        zvezdochkin.wakeUp();
        System.out.println();

        TimeUnit.SECONDS.sleep(3);

        znaika.runToLocation(yard);
        zvezdochkin.runToLocation(yard);
        System.out.println();

        TimeUnit.SECONDS.sleep(3);
        znaika.run();
        zvezdochkin.run();
        TimeUnit.SECONDS.sleep(3);

        znaika.runToLocation(hangar);
        zvezdochkin.runToLocation(hangar);
        TimeUnit.SECONDS.sleep(3);

        System.out.println();
        znaika.surprised();
        zvezdochkin.surprised();
        hangar.changeType(Locations.RUINS);
        System.out.println();
        TimeUnit.SECONDS.sleep(3);

        List<Shorty> shorties = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            shorties.add(new Shorty(yard));
        }

        for (Shorty shorty: shorties) {
            shorty.run();
            shorty.runToLocation(hangar);
            TimeUnit.SECONDS.sleep(1);
        }

    }
}
