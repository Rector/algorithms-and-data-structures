package taskLesson04;


import java.util.Iterator;
import java.util.ListIterator;

public class WorkWithList {
    public static void main(String[] args){
        System.out.println("Тестирование MyLinkedStackUpdated");
        MyLinkedStackUpdated<Integer> mlsu = new MyLinkedStackUpdated<>();
        mlsu.push(1);
        mlsu.push(2);
        mlsu.push(3);
        System.out.println(mlsu.peek());
        while(!mlsu.isEmpty()){
            System.out.print(mlsu.pop() + " ");
        }
        System.out.println();

        System.out.println("Тестирование MyLinkedQueue");
        MyLinkedQueue<Integer> mlq = new MyLinkedQueue<>();
        mlq.insert(10);
        mlq.insert(20);
        mlq.insert(30);
        System.out.println(mlq.peekFront());

        while(!mlq.isEmpty()){
            System.out.print(mlq.remove() + " ");
        }
        System.out.println();

        MyLinkedListUpdated<Integer> mllu = new MyLinkedListUpdated<>();
        mllu.insertLast(100);
        mllu.insertLast(200);
        mllu.insertLast(300);

/**
 * 3. В методе main проверить работу итератора и лист итератора
 * */

        System.out.println("Тестирование Iterator");
        Iterator<Integer> iter = mllu.iterator();
        System.out.println(iter.hasNext());

        while(iter.hasNext()){
            System.out.print(iter.next() + " ");
        }
        System.out.println();

        System.out.println("Тестирование ListIterator");
        ListIterator<Integer> listiter = mllu.listiterator();
        System.out.println(listiter.hasNext());

        System.out.println(mllu);
        System.out.println(listiter.next());
        System.out.println(listiter.next());
        System.out.println(listiter.nextIndex());
        System.out.println(listiter.previousIndex());

        System.out.println(listiter.hasPrevious());
        System.out.println(listiter.previous());
        listiter.remove();

        listiter.add(3000);
        System.out.println(listiter.next());
        listiter.set(1000);
        System.out.println(mllu);

    }
}
