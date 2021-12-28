package lab4;

import lab4.location.City;
import lab4.location.Settlement;
import lab4.organisms.Human;
import lab4.organisms.Villager;

import java.util.List;

public class World {
    private int nowDay;
    private List<Settlement> settlements;
    private List<Villager> villagers;

    public World(List<Settlement> settlements, List<Villager> villages) {
        this.settlements = settlements;
        this.villagers = villages;
        nowDay = 0;
    }

    public void addSettlement(Settlement settlement) {
        settlements.add(settlement);
    }

    public void skipDays(int days) {
        nowDay += days;
        for (Settlement s : settlements) {
            s.skipDays(days);
            if (s.getClass().getSimpleName().equals("City")) {
                ((City) s).checkResources();
            }
        }
        for (Villager v: villagers) {
            if (!v.getClass().getSimpleName().equals("Shorty")) {
                ((Human)v).earnMoney();
            }

        }
        System.out.println("Прошло " + days + " дней");
    }
}
