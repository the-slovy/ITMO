package lab2.pokemons;

import lab2.moves.*;
import ru.ifmo.se.pokemon.*;

public class Regirock extends Pokemon {
    public Regirock(String name, int level) {
        super(name, level);

        setType(Type.ROCK);
        setStats(80, 10, 200, 50, 10, 50);
        setMove(new AncientPower(), new MudShot(), new Swagger(), new RockSlide());
    }
}
