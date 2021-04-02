package taskLesson07.algorithmsFirstPath;

import taskLesson07.codeLesson07.Graph;

import java.util.LinkedList;

/**
 * 2*. Вынести в родительский класс общую часть классов поиска в глубину и ширину.
 * */

public abstract class FirstPath {
    boolean[] marked;
    int[] edgeTo;
    int source;
    int countPath;

     public FirstPath(Graph g, int source) {
        if(source >= g.getVertexCount() ){
            throw new IllegalArgumentException("Вершины " + source + " не существует");
        }
         this.source = source;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new int[g.getVertexCount()];
        countPath = 0;
    }

    public int countPath(){
        return countPath;
    }
    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public LinkedList<Integer> pathTo(int w) {
        if (!hasPathTo(w)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();
        int vertex = w;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];

            countPath++;
        }
        return stack;
    }

}
