package lab2.moves;

import ru.ifmo.se.pokemon.*;

public class Waterfall extends PhysicalMove {
    private boolean flag;

    public Waterfall() {
        super(Type.WATER, 80, 100);
    }

    @Override
    protected String describe() {
        if (flag) return "Наносит урон и с вероятностью 20% заставляет вздрогнуть";
        return "Наносит урон";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() <= 0.2) {
            flag = true;
            Effect.flinch(pokemon);
        }
    }
}
