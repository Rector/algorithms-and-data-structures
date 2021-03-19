package taskLesson03;

import java.util.NoSuchElementException;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    //0 1 2 3 4
    //b
    //  e
    //8


    public MyDeque(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Object[capacity];
    }

        public void insertLeft(T item) throws IllegalStateException {
        if (isFull()) {
            //реализовать расширение массива
            throw new IllegalStateException("Очередь заполнена");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);

    }

    public void insertRight(T item) throws IllegalStateException {
        if (isFull()) {
            //реализовать расширение массива
            throw new IllegalStateException("Очередь заполнена");
        }
        size++;
        begin = previousIndex(begin);
        list[begin] = item;

    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if(end > 0){
            return list[end - 1];
        } else{
            return list[list.length - 1];
        }


    }

    public T removeLeft() {
        T temp = peekLeft();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeRight() {
        T temp = peekRight();
        size--;
        end = previousIndex(end);
        list[end] = null;
        return temp;
    }


    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int previousIndex(int index) {
        if (index > 0) {
            return (index - 1) % list.length;
        } else {
            return list.length - 1;
        }

    }

//    @Override
//    public String toString() {
//        StringBuilder sb = new StringBuilder("[ ");
//        int i = begin;
//        while (i != end) {
//            sb.append(list[i]).append(", ");
//            i = nextIndex(i);
//        }
//        if (size > 0) {
//            sb.setLength(sb.length() - 2);
//        }
//        sb.append(" ]");
//        return sb.toString();
//    }


}
