package taskLesson05;

public class Thing {
    private double cost;
    private double weight;

    public Thing(double cost, double weight){
        this.cost = cost;
        this.weight = weight;
    }

    public double ratio (){
       return cost / weight;
    }

    public double getCost(){
        return cost;
    }

    public double getWeight() {
        return weight;
    }
}
