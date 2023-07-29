package graphconcept;

import java.util.ArrayList;

public class CycleDetectionUndirectedGraph {
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    static void createGraph(ArrayList<ArrayList<Integer>> graph, int vertex){
        for (int i=0; i<=vertex; i++){
            graph.add(new ArrayList<>());
        }
    }

    static boolean isCycle(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int current, int parent){
        visited[current] = true;
        for (int neighbour: graph.get(current)){
            if (visited[neighbour] && neighbour != parent) {
                return true;
            } else if (!visited[neighbour]) {
                return isCycle(graph, visited, neighbour, current);
            }
        }return false;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int vertex=4;
        createGraph(graph, vertex);

//        addEdge(graph, 0, 1);
//        addEdge(graph, 0, 4);
//        addEdge(graph, 1, 2);
//        addEdge(graph, 1, 4);
//        addEdge(graph, 4, 5);
//        addEdge(graph, 2, 3);

//        addEdge(graph, 0, 1);
//        addEdge(graph, 0, 2);
//        addEdge(graph, 1, 3);
//        addEdge(graph, 2, 4);
//        addEdge(graph, 2, 5);


        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 4, 1);

        System.out.println(graph);
        boolean[] visited = new boolean[vertex+1];
        System.out.println(isCycle(graph, visited, 0, -1));

    }
}
