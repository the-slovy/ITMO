package lab4.location;

import lab4.Buildings;
import lab4.Items;
import lab4.organisms.Organism;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class City extends Settlement {
    private List<Organism> leaders;
    private List<SpecialBuilding> specialBuildingList;
    private List<Items> resources;

    public City(String name, int population, Region region, List<Organism> leaders) {
        super(name, population, region);

        this.leaders = leaders;
        resources = new ArrayList<>();
        specialBuildingList = new ArrayList<>();
    }


    public List<Organism> getLeaders() {
        return leaders;
    }

    public List<Items> getResources() {
        System.out.println("Ресуры в городе");
        return resources;
    }

    public boolean hasResource(Items item) {
        return resources.contains(item);
    }

    public void useResource(Items item) {
        resources.remove(item);
    }

    public void checkResources() {
        for (SpecialBuilding b : specialBuildingList) {
            if (b.getSymbol().equals("O")) {
                for (int i = 0; i < 10; i++) {
                    addToResources(Items.STONE);
                }
            }
        }
    }

    @Override
    public void skipDays(int n) {
        List<Buildings> temp = new ArrayList<>();

        class BuildingAdder {
            void addBuilding(Buildings b) {
                b.setRequiredTime(b.getRequiredTime() - n);
                if (b.getRequiredTime() <= 0) {
                   if (!b.getName().equals("Шахта")) {
                      getBuildingsList().add(new Building(b.getName(), b.getSymbol()));
                   } else {
                    specialBuildingList.add(new SpecialBuilding(b.getName(), b.getSymbol(), b.getRequiredTime()));
                   }
                   temp.add(b);
                }
            }
        }
        BuildingAdder adder = new BuildingAdder();
        for (Buildings b : getUnderConstruction()) {
            adder.addBuilding(b);
        }

        for (Buildings b : temp) {
            getUnderConstruction().remove(b);
        }
    }

    public List<String> getSpecialBuildingNamesList() {
        System.out.println("Здания в городе " + getName());
        
        // specialBuildingList.stream().map(i -> i.getName()).collect(Collectors.toList());
        return specialBuildingList.stream().map(new Function<SpecialBuilding, String>(){
            @Override
            public String apply(SpecialBuilding b) {
                return b.getName();
            }
        }).collect(Collectors.toList());
    }

    public void addToResources(Items item) {
        resources.add(item);
    }

    public void buildSpecialBuilding(Buildings building, double speed) {
        building.setRequiredTime((int) (building.getRequiredTime() / speed));
        if (building.getRequiredTime() > 0) getUnderConstruction().add(building);
        else
            specialBuildingList.add(new SpecialBuilding(building.getName(), building.getSymbol(), building.getRequiredTime()));
    }

    @Override
    public String getTypeName() {
        return "Город " + getName();
    }

    public static class SpecialBuilding extends Settlement.Building {
        private int requiredTime;

        SpecialBuilding(String name, String symbol, int requiredTime) {
            super(name, symbol);
            this.requiredTime = requiredTime;
        }

        public int getRequiredTime() {
            return requiredTime;
        }
    }
}
