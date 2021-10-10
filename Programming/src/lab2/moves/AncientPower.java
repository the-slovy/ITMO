package lab2.moves;

import ru.ifmo.se.pokemon.*;

public class AncientPower extends SpecialMove {
    public AncientPower() {
        super(Type.ROCK, 60, 100);
    }

    @Override
    protected String describe() {
        return "Древняя сила, вносит урон и с 10% шансом апает все характеристики";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        if (Math.random() <= 0.1) {
            pokemon.setMod(Stat.ATTACK, 1);
            pokemon.setMod(Stat.DEFENSE, 1);
            pokemon.setMod(Stat.SPECIAL_ATTACK, 1);
            pokemon.setMod(Stat.SPECIAL_DEFENSE, 1);
        }
    }
}
