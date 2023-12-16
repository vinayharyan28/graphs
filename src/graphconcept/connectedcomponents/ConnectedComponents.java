package graphconcept.connectedcomponents;

import java.util.ArrayList;

public class ConnectedComponents {
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    static void createGraph(ArrayList<ArrayList<Integer>> graph, int vertex){
        for (int i=0; i<=vertex; i++){
            graph.add(new ArrayList<>());
        }
    }

    static void dfsUntil(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int vertex){
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int node: graph.get(vertex)){
            if (!visited[node]){
                dfsUntil(graph, visited, node);
            }
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int vertex){
        for (int i=1; i<=vertex; i++){
            if (!visited[i]){
                dfsUntil(graph, visited, i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int vertex = 6;
        createGraph(graph, vertex);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 4);

        addEdge(graph, 5, 6);
        boolean[] visited = new boolean[vertex+1];
        dfs(graph, visited, vertex);

    }
}

