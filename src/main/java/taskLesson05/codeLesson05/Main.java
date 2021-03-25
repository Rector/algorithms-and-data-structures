package taskLesson05.codeLesson05;

import taskLesson02.MyArrayList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        System.out.println(fact(5));
//        System.out.println(recFact(5));

//        System.out.println(fibo(47));
//        System.out.println(recFibo(10));

//        System.out.println(triangleNum(5));
//        System.out.println(recTriangleNum(5));

        System.out.println(multiply(3,8));
        System.out.println(recMultiply(3,8));

        MySortedArrayListWithRecursion<Integer> msal = new MySortedArrayListWithRecursion<>();
//        msal.add(5);
//        msal.add(1);
//        msal.add(8);
//        msal.add(2);
//        msal.add(3);
//        System.out.println(msal);
//        msal.add(4);
//        System.out.println(msal);
//        System.out.println(msal.binaryIndexOf(1));

        Random r = new Random();
        MyArrayList<Integer> mal = new MyArrayList<>(50000);
        for (int i = 0; i < 50000; i++) {
            mal.add(r.nextInt(1000 ) + i );
        }
        System.out.println(mal);

        long begin = System.currentTimeMillis();

//        mal.selectionSort(); // 3584
//        mal.insertionSort(); // 1614
//        mal.bubbleSort();    //9500
//        mal.bubbleSortO();
//        mal.qSort(); // 47


        long end = System.currentTimeMillis();
        System.out.printf("Time:  %d ms\n", end - begin);

//        System.out.println(mal);


//        MySortedArrayList<Integer> msal = new MySortedArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            msal.add(r.nextInt(10));
//        }
//        System.out.println(msal);
//
//        System.out.println(msal.recFind(5));

    }

    public static int fact(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static int recFact(int n) {
        if (n == 1) {
            return 1;
        }
        return recFact(n - 1) * n;
    }

    public static long fibo(long n) {
        long a = 1;
        long b = 1;
        for (int i = 3; i <= n; i++) {
            b = b + a;
            a = b - a;
        }
        return b;
    }

    public static long recFibo(long n) {
        System.out.print(n + " ");
        if (n < 3) {
            return 1;
        }

        return recFibo(n - 1) + recFibo(n - 2);
    }

    public static long triangleNum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static long recTriangleNum(int n) {
        if (n == 1) {
            return 1;
        }
        return recTriangleNum(n - 1) + n;
    }

    public static int multiply(int a, int b) {
        int value = 0;
        for (int i = 0; i < b; i++) {
            value += a;
        }
        return value;
    }

    public static int recMultiply(int a, int b) {
        if (b == 1) {
            return a;
        }
        return recMultiply(a, b - 1) + a;
    }


}
