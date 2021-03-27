package taskLesson05;

import java.util.ArrayList;

public class Backpack {
    private double maxСapacity;
    private double capacity;

    public double getMaxСapacity() {
        return maxСapacity;
    }

    public double getCapacity() {
        return capacity;
    }

    private ArrayList<Thing> al;

    public Backpack(double backpackMaxСapacity){
        al = new ArrayList<>();
        this.maxСapacity = backpackMaxСapacity;
        capacity = 0;
    }

    public void add(Thing thing){
        al.add(thing);
        capacity += thing.getWeight();
    }

    public void show(){
        for(int i = 0; i < al.size(); i++){
            System.out.printf("Thing - cost: %.2f | weight: %.2f\n",
                    al.get(i).getCost(), al.get(i).getWeight());
        }
    }
}
