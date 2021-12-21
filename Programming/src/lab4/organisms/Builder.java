package lab4.organisms;

import lab4.Items;
import lab4.Traits;
import lab4.exceptions.OrganismCreateException;
import lab4.location.City;
import lab4.location.Settlement;

import java.util.Arrays;
import java.util.List;

public class Builder extends Human {
    public Builder(String name, int age, List<Traits> traits, Settlement settlement, int money, int salary) {
        super(name, age, traits, "строитель", settlement, money, salary);
    }

    public Glowworm createGlowworm() {
        if (hasItem(Items.PLASMA.getName())) {
            useItem(Items.PLASMA);
            Glowworm glowworm = new Glowworm("glowworm", Arrays.asList(Traits.HARDWORKING, Traits.CLEVER), 10, new GlowwormRecipe());
            return glowworm;
        }
        throw new OrganismCreateException("НЕТ ПЛАЗМЫ");
    }

    public Shoggot createShoggot() {
        if (hasItem(Items.PLASMA.getName())) {
            useItem(Items.PLASMA);
            Shoggot shoggot = new Shoggot("shoggot", Arrays.asList(Traits.HARDWORKING, Traits.CLEVER), 10, Math.random(), 10, this.getSettlement(), new ShoggotRecipe());
            return shoggot;
        }
        throw new OrganismCreateException("НЕТ ПЛАЗМЫ");
    }

    static class ShoggotRecipe {
        String secretRecipe = "СУПЕР_СЕКРЕТНЫЙ_РЕЦЕПТ_ШОГГОТА";
    }

    static class GlowwormRecipe {
        String secretRecipe = "СУПЕР_СЕКРЕТНЫЙ_РЕЦЕПТ_ФОСФОРИЦИРУЮЩЕГО_ОРГАНИЗМА";
    }
}
