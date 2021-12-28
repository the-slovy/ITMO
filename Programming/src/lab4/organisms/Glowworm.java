package lab4.organisms;

import lab4.Descriptions;
import lab4.Traits;

import java.util.List;

public class Glowworm extends Organism {
    private int size;

    public Glowworm(String name, List<Traits> traits, int size, Builder.GlowwormRecipe recipe) {
        super(name, 0, traits);

        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public String getLight() {
        return getName() + " светится, заменяя полярные сияния";
    }


    @Override
    public Descriptions getDescription() {
        return Descriptions.FASTER;
    }

    @Override
    public String getLocation() {
        return "Всегда рядом со старцами";
    }
}
