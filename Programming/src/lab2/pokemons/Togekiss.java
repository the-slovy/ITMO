package lab2.pokemons;

import lab2.moves.*;

public class Togekiss extends Togetic {
    public Togekiss(String name, int level) {
        super(name, level);

        setStats(85, 50, 95, 120, 115, 80);
        addMove(new Tackle());
    }
}
