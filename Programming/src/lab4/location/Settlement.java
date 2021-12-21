package lab4.location;

import lab4.Buildings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Settlement extends Location {
    private int population;
    private Region region;
    private List<Building> buildingList;
    private List<Buildings> underConstruction;

    public Settlement(String name, int population, Region region) {
        super(name);

        this.population = population;
        this.region = region;
        buildingList = new ArrayList<>();
        underConstruction = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Селение " + getTypeName() + " в стране " + region.getCountry();
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void spawnBuilding(Buildings building) {
        buildingList.add(new Building(building.getName(), building.getSymbol()));
    }

    public void buildBuilding(Buildings building, double speed) {
        building.setRequiredTime((int) (building.getRequiredTime() / speed));
        if (building.getRequiredTime() > 0) underConstruction.add(building);
        else buildingList.add(new Building(building.getName(), building.getSymbol()));
    }

    public void skipDays(int n) {
        List<Buildings> temp = new ArrayList<>();
        for (Buildings b : underConstruction) {
            b.setRequiredTime(b.getRequiredTime() - n);
            if (b.getRequiredTime() <= 0) {
                if (b.getName() != "Mine")
                    buildingList.add(new Building(b.getName(), b.getSymbol()));
                temp.add(b);
            }
        }

        for (Buildings b: temp) {
            underConstruction.remove(b);
        }
    }

    public List<String> getBuildingNamesList() {
        System.out.println("Здания в городе " + getName());
        return buildingList.stream().map(i -> i.name).collect(Collectors.toList());
    }

    public List<Building> getBuildingsList() {
        return buildingList;
    }

    public List<Buildings> getUnderConstruction() {
        return underConstruction;
    }

    @Override
    public String getTypeName() {
        return "Деревня " + getName();
    }

    @Override
    public String getDescription() {
        return "Деревня " + getTypeName();
    }

    public static class Building {
        private String name;
        private String symbol;

        Building(String name, String symbol) {
            this.name = name;
            this.symbol = symbol;
        }

        public String getName() {
            return name;
        }

        public String getSymbol() {
            return symbol;
        }
    }
}
