package lab4.organisms;

import lab4.Descriptions;
import lab4.Traits;
import lab4.location.Settlement;
import sun.security.krb5.internal.crypto.Des;

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
    public Descriptions getDescription() {
        return Descriptions.INTELLIGENCE;
    }
}
