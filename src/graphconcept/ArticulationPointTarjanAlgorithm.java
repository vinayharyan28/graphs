package graphconcept;

import java.util.ArrayList;

public class ArticulationPointTarjanAlgorithm {
    static void createGraph(ArrayList<ArrayList<Integer>> graph, int vertices){
        for (int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }
    }

    static void addEdge(int source, int destination, ArrayList<ArrayList<Integer>> graph){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int current, int parent, boolean[] visited,
                    int[] discoveryTime, int[] lowDiscoveryTime, int time, boolean[] isArticulation){
        visited[current] = true;
        discoveryTime[current] = lowDiscoveryTime[current] = ++time;
        int child = 0;
        for (int neighbour: graph.get(current)){
            if (neighbour == parent){
                continue;
            }
            if (visited[neighbour]){
                lowDiscoveryTime[current] = Math.min(lowDiscoveryTime[current], discoveryTime[neighbour]);
            }else{
                dfs(graph, neighbour, current, visited, discoveryTime, lowDiscoveryTime, time, isArticulation);
                lowDiscoveryTime[current] = Math.min(lowDiscoveryTime[current], lowDiscoveryTime[neighbour]);
                if (discoveryTime[current] <= lowDiscoveryTime[neighbour] & parent != -1){
                    isArticulation[current] = true;
                }
                child++;
            }
            if (parent == -1 && child > 1){
                isArticulation[current] = true;
            }
        }
    }

    static void findArticulationPoint(ArrayList<ArrayList<Integer>> graph, int vertices){
        int[] discoveryTime = new int[vertices];
        int[] lowDiscoveryTime = new int[vertices];
        boolean[] visited = new boolean[vertices];
        boolean[] isArticulation = new boolean[vertices];
        int time = 0;
        for (int i=0; i<vertices; i++){
            if (!visited[i]){
                dfs(graph, i, -1, visited, discoveryTime, lowDiscoveryTime, time, isArticulation);
            }
        }

        System.out.println("Articulation point: ");
        for (int i=0; i<vertices; i++){
            if(isArticulation[i]){
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int vertices = 5;
        createGraph(graph, vertices);
        addEdge(1, 0, graph);
        addEdge(0, 2, graph);
        addEdge(2, 1, graph);
        addEdge(0, 3, graph);
        addEdge(3, 4, graph);
        findArticulationPoint(graph, vertices);
    }
}