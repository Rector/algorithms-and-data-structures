package taskLesson04;

import taskLesson04.lessonCode.MyLinkedList;

public class MyLinkedStackUpdated<T> {

    /**
     * 1. Реализовать классы стек и очередь на базе линкед листа.
     */

    private MyLinkedList<T> ll = new MyLinkedList<>();

    public void push(T item){
        ll.insertFirst(item);
    }

    public T pop(){
        return ll.removeFirst();
    }

    public T peek(){
        return ll.getFirst();
    }

    public int size(){
        return ll.size();
    }

    public boolean isEmpty(){
        return ll.isEmpty();
    }
}