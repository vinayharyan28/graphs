package graphconcept;

import java.util.ArrayList;
import java.util.PriorityQueue;

import java.util.*;

class dijkstraAlgorithmDirectedGraph {
    private int V; // Number of vertices
    private List<Edge>[] adjacencyList;

    public dijkstraAlgorithmDirectedGraph(int V) {
        this.V = V;
        adjacencyList = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    // Class to represent an edge with its weight
    private class Edge {
        int dest;
        int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Add a weighted edge from vertex 'from' to vertex 'to'
    public void addEdge(int from, int to, int weight) {
        if (from >= 0 && from < V && to >= 0 && to < V) {
            adjacencyList[from].add(new Edge(to, weight));
        } else {
            throw new IllegalArgumentException("Invalid vertex index!");
        }
    }

    // Dijkstra's algorithm implementation
    public int[] dijkstra(int source) {
        int[] distances = new int[V];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Edge(source, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int vertex = current.dest;

            for (Edge neighbor : adjacencyList[vertex]) {
                int newDistance = distances[vertex] + neighbor.weight;
                if (newDistance < distances[neighbor.dest]) {
                    distances[neighbor.dest] = newDistance;
                    pq.add(new Edge(neighbor.dest, newDistance));
                }
            }
        }

        return distances;
    }
}

class Main {
    public static void main(String[] args) {
        int V = 5; // Number of vertices in the graph
        dijkstraAlgorithmDirectedGraph graph = new dijkstraAlgorithmDirectedGraph(V);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 0, 5);
        graph.addEdge(3, 2, 2);
        graph.addEdge(3, 4, 4);
        graph.addEdge(4, 2, 1);

        int sourceVertex = 0;
        int[] shortestDistances = graph.dijkstra(sourceVertex);

        System.out.println("Shortest distances from vertex " + sourceVertex + " to all other vertices:");
        for (int i = 0; i < shortestDistances.length; i++) {
            System.out.println("Distance to vertex " + i + ": " + shortestDistances[i]);
        }
    }
}
