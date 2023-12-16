package graphconcept.cycledetection;

import java.util.ArrayList;

public class CycleDetectionDirectedGraph {
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
    }

    static void createGraph(ArrayList<ArrayList<Integer>> graph, int vertex){
        for (int i=0; i<=vertex; i++){
            graph.add(new ArrayList<>());
        }
    }

    static boolean isCycle(ArrayList<ArrayList<Integer>> graph, int current, boolean[] visited, boolean[] recursion){
        visited[current] = true;
        recursion[current] = true;
        for (int neighbour: graph.get(current)){
            if (recursion[neighbour]){
                return true;
            } else if (!visited[neighbour]) {
                return isCycle(graph, neighbour, visited, recursion);
            }
        }
        recursion[current] = false;
        return false;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int vertex=3;
        createGraph(graph, vertex);
        addEdge(graph, 1, 0);
        addEdge(graph, 0, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 0);

//        addEdge(graph, 1, 0);
//        addEdge(graph, 2, 0);
//        addEdge(graph, 3, 2);
//        addEdge(graph, 3, 0);
        System.out.println(graph);
        boolean[] visited = new boolean[vertex+1];
        boolean[] recursion = new boolean[vertex+1];
        for (int v=0; v<=vertex; v++){
            boolean result = isCycle(graph, v, visited, recursion);
            System.out.println(result);
        }
    }
}
