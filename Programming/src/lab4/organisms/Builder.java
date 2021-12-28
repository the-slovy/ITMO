package lab4.organisms;

import lab4.Descriptions;
import lab4.Items;
import lab4.Traits;
import lab4.exceptions.OrganismCreateException;
import lab4.location.City;
import lab4.location.Settlement;
import sun.security.krb5.internal.crypto.Des;

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
            Shoggot shoggot = new Shoggot("shoggot", Arrays.asList(Traits.HARDWORKING, Traits.CLEVER), 10, mathCalculation(), 10, (City)this.getSettlement(), new ShoggotRecipe());
            return shoggot;
        }
        throw new OrganismCreateException("НЕТ ПЛАЗМЫ");
    }

    private double mathCalculation() {
        return Math.random() + 1;
    }

    @Override
    public Descriptions getDescription() {
        return Descriptions.ACCURATE;
    }

    static class ShoggotRecipe {
        private String secretRecipe = "СУПЕР_СЕКРЕТНЫЙ_РЕЦЕПТ_ШОГГОТА";
    }

    static class GlowwormRecipe {
        private String secretRecipe = "СУПЕР_СЕКРЕТНЫЙ_РЕЦЕПТ_ФОСФОРИЦИРУЮЩЕГО_ОРГАНИЗМА";
    }
}
