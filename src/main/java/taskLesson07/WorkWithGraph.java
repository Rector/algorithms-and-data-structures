package taskLesson07;

import taskLesson07.algorithmsFirstPath.BreadthFirstPathUpdated;
import taskLesson07.codeLesson07.Graph;

public class WorkWithGraph {
    public static void main(String[] args){
/**
 * 1. Реализовать программу, в которой задается граф из 10 вершин.
 * Задать ребра и найти кратчайший путь с помощью поиска в ширину.
 * */

        Graph graph = new Graph(10);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);

        graph.addEdge(1,4);
        graph.addEdge(4,5);
        graph.addEdge(2,6);
        graph.addEdge(6,7);

        graph.addEdge(0,8);
        graph.addEdge(8,3);
        graph.addEdge(3,9);


        BreadthFirstPathUpdated bfpu = new BreadthFirstPathUpdated(graph, 0);
        System.out.println(bfpu.pathTo(9));
        System.out.println("Длина пути: " + bfpu.countPath());

        bfpu = new BreadthFirstPathUpdated(graph, 3);
        System.out.println(bfpu.pathTo(7));
        System.out.println("Длина пути: " + bfpu.countPath());

        bfpu = new BreadthFirstPathUpdated(graph, 5);
        System.out.println(bfpu.pathTo(8));
        System.out.println("Длина пути: " + bfpu.countPath());

    }
}
