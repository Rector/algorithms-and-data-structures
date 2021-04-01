package taskLesson06;

import java.util.Random;

public class WorkWithTree {

    public static void main(String[] args) {

/**
 * 1. Создать и запустить программу для построения двоичного дерева.
 * В цикле построить двадцать деревьев с глубиной в 6 уровней.
 * Данные, которыми необходимо заполнить узлы деревьев,
 * представляются в виде чисел типа int.
 * Число, которое попадает в узел, должно генерироваться случайным образом
 * в диапазоне от -100 до 100.
 * */

        int limitTree = 200_000;
        int limitHeight = 6;

        int counterBalancedTree = 0;

        Random random = new Random();
        int temp = 0;
        for(int i = 0; i < limitTree;i++){
            MyTreeMapUpdated<Integer, String> mtmu = new MyTreeMapUpdated<>();
            while(mtmu.height() < limitHeight){
                temp = random.nextInt(201) - 100;
                mtmu.put(temp, "a");
            }
            mtmu.delele(temp);
/**
 * 2. Проанализировать, какой процент созданных деревьев
 * являются несбалансированными.
 * */
            if(mtmu.isBalanced()){
                counterBalancedTree++;
            }
        }

        double balanced = Double.valueOf(counterBalancedTree) / Double.valueOf(limitTree) * 100;
        double notBalanced = 100 - balanced;
        System.out.printf("Из %d деревьев - %d сбалансировано." +
                        "\nПроцент несбалансированных деревьев - %.2f\n" +
                        "Процент сбалансированных деревьев - %.2f\n",
                limitTree, counterBalancedTree, notBalanced, balanced);

    }
}
