package taskLesson02;

import java.util.Random;

public class WorkWithSorting {
    private static final int LIST_CAPACITY;

    static {
        LIST_CAPACITY = 100_000;
    }

    public static void main(String[] args) {

// 1. Создать массив большого размера (100000 элементов).

        MyArrayList<Integer> mal1 = new MyArrayList<>(LIST_CAPACITY);
        MyArrayList<Integer> mal2 = new MyArrayList<>(LIST_CAPACITY);
        MyArrayList<Integer> mal3 = new MyArrayList<>(LIST_CAPACITY);

// 3. Заполнить массив случайными числами.
        int limitRandom = 101;
        Random r = new Random();
        for (int i = 0; i < LIST_CAPACITY; i++) {
            mal1.add(r.nextInt(limitRandom));
            mal2.add(r.nextInt(limitRandom));
            mal3.add(r.nextInt(limitRandom));
        }

// 4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.
//    (Можете в комментариях написать измеренное время).

        long time = System.currentTimeMillis();

        mal1.selectionSort();
        System.out.println("Сортировка методом выбора. Время выполнения (мс.): "
                + (System.currentTimeMillis() - time));

        time = System.currentTimeMillis();
        mal2.insertionSort();
        System.out.println("Сортировка методом вставки. Время выполнения (мс.): "
                + (System.currentTimeMillis() - time));


        time = System.currentTimeMillis();
        mal3.bubbleSortO();
        System.out.println("Пузырьковая сортировка. Время выполнения (мс.): "
                + (System.currentTimeMillis() - time));

    }
}
