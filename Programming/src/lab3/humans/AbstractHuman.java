package lab3.humans;


import java.util.Objects;

public abstract class AbstractHuman {
    private String name;
    private int age;
    private int speed;

    public AbstractHuman() {
        this("Ноунейм", 5);
    }

    public AbstractHuman(String name, int age) {
        this.name = name;
        this.age = age;
        speed = 5;
    }

    public void happyBirthday() {
        age++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractHuman that = (AbstractHuman) o;
        return Objects.equals(name + this.hashCode(), that.name + that.hashCode());
    }

    @Override
    public String toString() {
        return "Коротышка " + name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, speed, Math.random());
    }
}
