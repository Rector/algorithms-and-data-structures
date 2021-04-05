package taskLesson08;

public class WorkWithHashMap {
    public static void main(String[] args) {

        ChainingHashMapUpdated<Integer, Integer> chmu = new ChainingHashMapUpdated<>(2);
        chmu.put(10,0);
        chmu.put(20,1);
        chmu.put(30,2);
        chmu.put(40,3);
        System.out.println(chmu);
        System.out.println(chmu.size());

        System.out.println(chmu.remove(10));
        System.out.println(chmu.removeIf(40));

        System.out.println(chmu.size());
        System.out.println(chmu);

        LinearProbingHashMapUpdated<Integer, String> lphm = new LinearProbingHashMapUpdated<>(5);
        lphm.put(1, "one");
        lphm.put(2, "two");
        lphm.put(3, "three");
        lphm.remove(1);
        System.out.println(lphm.get(1));

        lphm.put(1, "oneNew");
        System.out.println(lphm.get(1));

    }
}
