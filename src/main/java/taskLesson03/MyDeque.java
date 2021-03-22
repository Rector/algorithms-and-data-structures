package taskLesson03;

import java.util.NoSuchElementException;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

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

        public void insertLast(T item) throws IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException("Очередь заполнена");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);

    }

    public void insertFirst(T item) throws IllegalStateException {
        if (isFull()) {
            throw new IllegalStateException("Очередь заполнена");
        }
        size++;
        begin = previousIndex(begin);
        list[begin] = item;

    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return list[begin];
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return list[previousIndex(end)];
    }

    public T removeFirst() {
        T temp = peekFirst();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T removeLast() {
        T temp = peekLast();
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
        return (list.length + index - 1) % list.length;

    }

}
