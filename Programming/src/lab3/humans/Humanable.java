package lab3.humans;


import lab3.place.locations.Location;

public interface Humanable {
    void runToLocation(Location location);
    void sleep();
    void wakeUp();
    void run();

}
