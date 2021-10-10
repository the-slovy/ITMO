package lab2.pokemons;

import lab2.moves.*;
import ru.ifmo.se.pokemon.*;

public class Carvanha extends Pokemon {
    public Carvanha(String name, int level) {
        super(name, level);

        setType(Type.WATER, Type.DARK);
        setStats(45, 90, 20, 65, 20, 65);
        setMove(new DoubleTeam(), new Facade(), new Swagger());
    }
}
