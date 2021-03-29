package taskLesson05;

import java.util.ArrayList;

public class WorkWithRecursion {

    /**
     * 1. Написать программу по возведению числа в степень с помощью рекурсии.
     */

    public static int raisingNumberToDegree(int number, int degree) {
        if (number < 0) {
            throw new RuntimeException("Введено отрицательно число");
        }

        if (degree < 0) {
            throw new RuntimeException("Введена отрицательная степень");
        }

        if (number == 0 && degree == 0) {
            throw new RuntimeException("Выражение 0 в 0 степени лишено смысла");
        }

        if (degree == 0) {
            return 1;
        }

        return raisingNumberToDegree(number, degree - 1) * number;
    }


    public static void recFillingBackpack(ArrayList<Thing> thingsList, Backpack backpack) {
        if (thingsList.size() <= 0) {
            return;
        }
        if (backpack.getCapacity() == backpack.getMaxСapacity()) {
            return;
        }

        Thing thing = thingsList.get(0);
        double bestRatio = thingsList.get(0).ratio();

        for (int i = 0; i < thingsList.size(); i++) {
            if (bestRatio < thingsList.get(i).ratio()) {
                bestRatio = thingsList.get(i).ratio();
                thing = thingsList.get(i);
            }
        }

        thingsList.remove(thing);
        if ((backpack.getCapacity() + thing.getWeight())
                <= backpack.getMaxСapacity()) {
            backpack.add(thing);
        }
        recFillingBackpack(thingsList, backpack);

    }

    public static void main(String[] args) {
        
        System.out.println(raisingNumberToDegree(2, 10));

/**
 * 2. Написать программу «Задача о рюкзаке» с помощью рекурсии.
 * */
        ArrayList<Thing> thingsList = new ArrayList<>();
        thingsList.add(new Thing(5.5, 5.5));
        thingsList.add(new Thing(50.0, 10.0));
        thingsList.add(new Thing(45.0, 4.5));
        thingsList.add(new Thing(55.0, 5.5));

        Backpack backpack = new Backpack(20);

        recFillingBackpack(thingsList, backpack);
        backpack.show();

    }

}
