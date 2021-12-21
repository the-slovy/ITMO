package lab3;

import lab3.humans.MainCharacter;
import lab3.humans.Movable;
import lab3.place.locations.Location;
import lab3.place.locations.LocationType;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

class Test {
    public void test() {
        Runnable run = () -> System.out.println("aaa");
        Runnable run1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("bbb");
            }
        };
        run.run();
        run1.run();

        Predicate<Integer> isEven = x -> x % 2 == 0; // возвращает булевое значение
        System.out.println(isEven.test(2));

        Consumer<String> sayHello = x -> System.out.println("Hello " + x); // принимает объект и что-то делает
        sayHello.accept("world");

        // Supplier - ничего не принимает, возвращает объект
        // Function - принимает объект и приводит его к другому типу
        // UnaryOperator - принимает объект, выполняет операцию и возвращает объект того же типа
        // BinaryOperator - принимает два объекта, выполняет операции и возвращает один объект

        BinaryOperator<Integer> lam = (x, y) -> {
             return x + y;
        };
        BinaryOperator<Integer> lam1 = Integer::sum;

        Cat cat = new Cat("a");
        Converter<Cat, Dog> converter = x -> new Dog(x.name);
        Dog dog = converter.convert(cat);

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        UnaryOperator<Integer> uniOpt = i -> i*i;
        unaryFun(uniOpt, list).forEach(System.out::println);

        Map<String, String> map = new HashMap<>();
        map.put("X", "A");
        map.put("Y", "B");
        BinaryOperator<String> binaryOpt = (x, y) -> x + "-" + y;
        binaryFun(binaryOpt, map).forEach(System.out::println);
    }

    private static List<Integer> unaryFun(UnaryOperator<Integer> unaryOpt, List<Integer> list) {
        List<Integer> uniList = new ArrayList<>();
        list.forEach(i->uniList.add(unaryOpt.apply(i)));
        return uniList;
    }

    private static List<String> binaryFun(BinaryOperator<String> binaryOpt, Map<String, String> map) {
        List<String> biList = new ArrayList<>();
        map.forEach((x, y) -> biList.add(binaryOpt.apply(x, y)));
        return biList;
    }

    @FunctionalInterface
    public interface Converter<T, N> {
        N convert(T t);
    }
}