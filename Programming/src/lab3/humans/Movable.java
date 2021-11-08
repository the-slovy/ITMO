package lab3.humans;

import lab3.place.locations.Location;

public interface Movable {
    void moveToLocation(Location location);
    void run();
}
