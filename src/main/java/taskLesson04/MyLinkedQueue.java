package taskLesson04;

import taskLesson04.codeLesson04.MyLinkedList;

public class MyLinkedQueue<T> {

    /**
     * 1. Реализовать классы стек и очередь на базе линкед листа.
     */

    private MyLinkedList<T> mll = new MyLinkedList<>();

    public void insert(T item) {
        mll.insertLast(item);
    }

    public T peekFront() {
        return mll.getFirst();
    }

    public T remove() {
        return mll.removeFirst();
    }

    public int size() {
        return mll.size();
    }

    public boolean isEmpty() {
        return mll.isEmpty();
    }
}
