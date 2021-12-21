package lab4.organisms;

import lab4.Buildings;
import lab4.Traits;
import lab4.exceptions.InvalidCommandException;
import lab4.location.City;
import lab4.location.Settlement;

import java.util.List;

public class Shoggot extends Organism {
    private int size;
    private double speed;
    private int intelligence;
    private Settlement settlement;

    public Shoggot(String name, List<Traits> traits, int size, double speed, int intelligence, Settlement settlement, Builder.ShoggotRecipe recipe) {
        super(name, 0, traits);

        this.size = size;
        this.speed = speed;
        this.intelligence = intelligence;
        this.settlement = settlement;
    }

    public int getSize() {
        return size;
    }

    public double getSpeed() {
        return speed;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void buildBuilding(String buildSymbol) throws InvalidCommandException {
        switch (buildSymbol) {
            case "H":
                settlement.buildBuilding(Buildings.HOUSE, speed);
                break;
            case "S":
                settlement.buildBuilding(Buildings.STABLE, speed);
                break;
            case "M":
                settlement.buildBuilding(Buildings.MARKET, speed);
                break;
            case "T":
                settlement.buildBuilding(Buildings.TAVERN, speed);
                break;
            case "Mine":
                ((City) settlement).buildSpecialBuilding(Buildings.MINE, speed);
                break;
            default:
                throw new InvalidCommandException("НЕТ ТАКОЙ КОМАНДЫ");
        }
    }

    public Settlement getSettlement() {
        return settlement;
    }

    @Override
    public String getDescription() {
        return "Большой умный шоггот, общающийся со старцем, подражая голос";
    }
}
