package taskLesson07.algorithmsFirstPath;

import taskLesson07.codeLesson07.Graph;

import java.util.LinkedList;

public class DepthFirstPathUpdated extends FirstPath {

    public DepthFirstPathUpdated(Graph g, int source) {
        super(g, source);
        dfs(g, source);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.getAdjList(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

}
