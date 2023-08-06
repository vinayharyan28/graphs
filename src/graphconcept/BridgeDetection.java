package graphconcept;

import java.util.*;

class Graph {
    private int V;
    private List<Integer>[] adjList;
    private int time;

    Graph(int v) {
        V = v;
        adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjList[i] = new ArrayList<>();
        }
        time = 0;
    }

    void addEdge(int v, int w) {
        adjList[v].add(w);
        adjList[w].add(v); // Undirected graph
    }

    void findBridges() {
        boolean[] visited = new boolean[V];
        int[] discovery = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];

        Arrays.fill(visited, false);
        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(i, visited, discovery, low, parent);
            }
        }
    }

    void DFS(int u, boolean[] visited, int[] discovery, int[] low, int[] parent) {
        visited[u] = true;
        discovery[u] = low[u] = ++time;

        for (int v : adjList[u]) {
            if (!visited[v]) {
                parent[v] = u;
                DFS(v, visited, discovery, low, parent);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > discovery[u]) {
                    System.out.println("Bridge: " + u + " - " + v);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], discovery[v]);
            }
        }
    }
}

public class BridgeDetection {
    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(3, 5);
//        graph.addEdge(4, 5);

        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println("Bridges:");
        graph.findBridges();
    }
}
