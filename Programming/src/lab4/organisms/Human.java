package lab4.organisms;

import lab4.Items;
import lab4.Traits;
import lab4.location.Settlement;
import lab4.location.Settlement;

import java.util.List;

public class Human extends Villager {
    private int money;
    private int salary;

    public Human(String name, int age, List<Traits> traits, String profession, Settlement settlement, int money, int salary) {
        super(name, age, traits, profession, settlement);

        this.money = money;
        this.salary = salary;
    }

    public Human(String name, int age, String profession, Settlement settlement, int money, int salary) {
        super(name, age, profession, settlement);

        this.money = money;
        this.salary = salary;
    }

    public Human(String name, int age, Settlement settlement, int money) {
        super(name, age, settlement);

        this.money = money;
        this.salary = 0;
    }

    public Human(String name, int age, Settlement settlement) {
        super(name, age, settlement);

        this.money = 0;
        this.salary = 0;
    }

    public int getMoney() {
        return money;
    }

    public void earnMoney() {
        money += salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
