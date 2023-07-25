package graphconcept;

import java.util.ArrayList;

public class CycleDetection {
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    static void createEmptyGraph(ArrayList<ArrayList<Integer>> graph, int vertex){
        for (int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }
    }

    static boolean cycleDetection(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int vertex, int parent){
        visited[vertex]=true;
        for (int n: graph.get(vertex)){
            if (!visited[n]){
                return cycleDetection(graph, visited, n, vertex);
            }else {
                if (vertex != parent){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int vertex = 5;
        createEmptyGraph(graph, vertex);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 3);
        addEdge(graph, 3, 2);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 2);
        System.out.println(graph);
    }

}
