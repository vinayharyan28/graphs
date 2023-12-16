package graphconcept.graphtraversal;

import java.util.ArrayList;

public class FindAllPath {
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    static void createEmptyGraph(ArrayList<ArrayList<Integer>> graph, int vertex){
        for (int i=0; i<=vertex; i++){
            graph.add(new ArrayList<>());
        }
    }

    static void allPathSourceToDestination(
            ArrayList<ArrayList<Integer>> graph, int source, int destination, boolean[] visited, String path
    ){
        if (source == destination){
            System.out.println(path);
            return;
        }

        for (int n: graph.get(source)){
            if (!visited[n]){
                visited[source] = true;
                allPathSourceToDestination(graph, n, destination, visited, path+n);
                visited[source] = false;
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int vertex = 6;
        createEmptyGraph(graph, vertex);
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 3);
        addEdge(graph, 3, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 5, 4);
        addEdge(graph, 4, 3);
        addEdge(graph, 4, 2);
        addEdge(graph, 2, 0);

        System.out.println(graph);
        boolean[] visited = new boolean[vertex];
        int source=0, destination=5;
        //v^V
        allPathSourceToDestination(graph, source, destination, visited, ""+source);
    }
}
