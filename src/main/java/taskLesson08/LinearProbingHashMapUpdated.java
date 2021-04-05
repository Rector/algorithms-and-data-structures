package taskLesson08;

public class LinearProbingHashMapUpdated<Key, Value> {
    private int capacity;
    private int size;
    private final int DEFAULT_CAPACITY = 17;
    private final float LOAD_FACTOR = 0.75F;

    private Key[] keys;
    private Value[] values;

    public LinearProbingHashMapUpdated(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        this.capacity = capacity;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    public LinearProbingHashMapUpdated() {
        capacity = DEFAULT_CAPACITY;
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % capacity;
    }

    private int hash2(Key key) {
        return 7 - Math.abs(key.hashCode() % 7);
    }

    private void checkKeyNotNull(Key key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
    }

    public void put(Key key, Value value){
        // проверка на превышение лоад фактора. Либо бросаем эксепшн либо
        // перехиширование на массив размером больше, но простое число
        if(size > capacity * LOAD_FACTOR){
            throw new RuntimeException("Превышен LOAD_FACTOR");
        }

        checkKeyNotNull(key);
        int i = hash(key);
        int step = hash2(key);
        while (keys[i] != null){
            if(keys[i].equals(key)){
                values[i]= value;
                return;
            }
            i = (i+step) % capacity;
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

/**
 * 2*. Реализовать удаление в методе открытой адресации.
 * */

    public Key remove (Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = hash2(key);
        while (keys[i] != null){
            if(keys[i].equals(key)){
                keys[i] = null;
                values[i] = null;
                size--;
                return key;
            }
            i = (i+step) % capacity;
        }
        return null;
    }


    public Value get(Key key){
        checkKeyNotNull(key);
        int i = hash(key);
        int step = 1;

        while (keys[i] != null){
            if(keys[i].equals(key)){
                return values[i];
            }
            i = (i+step) % capacity;
        }
        return null;
    }
}
