package lab4.organisms;

import lab4.HasDescription;
import lab4.Traits;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Organism implements HasDescription {
    private String name;
    private  int age;
    private List<Traits> traits;

    public Organism(String name, int age, List<Traits> traits) {
        this.name = name;
        this.age = age;
        this.traits = traits;
    }

    public Organism(String name, int age) {
        this.name = name;
        this.age = age;
        this.traits = new ArrayList<Traits>();
        // TODO: рандомное заполнение черт
    }

    public void happyBirthday() {
        age++;
        System.out.println("Сегодня у " + name + " День Рождения, ему уже " + age);
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public List<Traits> getTraits() {
        return traits;
    }

    public boolean HasTrait(Traits trait) {
        // TODO: проверить наличие черты
        return true;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Organism organism = (Organism) o;
        return age == organism.age && Objects.equals(name, organism.name) && Objects.equals(traits, organism.traits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, traits);
    }
}
