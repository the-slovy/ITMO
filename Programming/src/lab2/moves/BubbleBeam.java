package lab2.moves;

import ru.ifmo.se.pokemon.*;

public class BubbleBeam extends SpecialMove {
    public BubbleBeam() {
        super(Type.WATER, 65, 100);
    }

    @Override
    protected String describe() {
        return "Пузырит";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() <= 0.1) pokemon.setMod(Stat.SPEED, -1);
    }
}
