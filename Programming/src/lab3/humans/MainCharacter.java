package lab3.humans;

import lab3.place.locations.Location;


public class MainCharacter extends Shorty {
    public MainCharacter(String name, int age, int speed, Location startLocation) {
        super(name, age, speed, startLocation);
    }

    public void surprised() {
        System.out.println(getName() + " увидел груду дымящихся развалин");
    }
}
