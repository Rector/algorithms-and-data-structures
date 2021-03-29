package taskLesson06;

import taskLesson06.codeLesson06.MyTreeMap;

import java.util.Random;

public class WorkWithTree {

    public static void main(String[] args) {

//        MyTreeMapUpdated<Integer, String> mtmu = new MyTreeMapUpdated<>();
//        mtmu.put(1, "one");
//        mtmu.put(2, "two");
//        mtmu.put(3, "three");
//        mtmu.put(4, "four");
//        mtmu.put(-5, "zero");
//        mtmu.put(-3, "zero");
//
//
//
//        System.out.println(mtmu);
//        System.out.println(mtmu.isBalanced());




        int limitTree = 200_000;
        int limitHeight = 5;

        int counterBalancedTree = 0;

        Random random = new Random();
        int temp;
        for(int i = 0; i < limitTree;i++){
            MyTreeMapUpdated<Integer, String> mtmu = new MyTreeMapUpdated<>();
            while(true){
                temp = random.nextInt(201) - 100;
                mtmu.put(temp, "a");
                if(mtmu.height() >= limitHeight){
                    break;
                }
            }


            if(mtmu.isBalanced() == 1){
                counterBalancedTree++;
            }
        }

        double balance = 100 - (Double.valueOf(counterBalancedTree) / Double.valueOf(limitTree) * 100);
        System.out.printf("Из %d деревьев - %d сбалансировано.\nПроцент несбалансированных деревьев - %.2f\n",
                limitTree, counterBalancedTree, balance);



    }
}
