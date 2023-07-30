package graphconcept;

import java.util.*;

public class DijkstraUndirectedGraph {
    private static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static void dijkstra(List<List<Edge>> graph, int source, int[] distances) {
        int n = graph.size();
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[source] = 0;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        minHeap.offer(new Edge(source, 0));

        while (!minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll();
            int currentVertex = currentEdge.destination;

            if (currentEdge.weight > distances[currentVertex])
                continue;

            for (Edge neighbor : graph.get(currentVertex)) {
                int newDistance = distances[currentVertex] + neighbor.weight;
                if (newDistance < distances[neighbor.destination]) {
                    distances[neighbor.destination] = newDistance;
                    minHeap.offer(new Edge(neighbor.destination, newDistance));
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 5; // Number of vertices
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        // Add edges to the graph (undirected)
        graph.get(0).add(new Edge(1, 5));
        graph.get(0).add(new Edge(2, 3));
        graph.get(1).add(new Edge(2, 2));
        graph.get(1).add(new Edge(3, 6));
        graph.get(2).add(new Edge(3, 7));
        graph.get(2).add(new Edge(4, 4));
        graph.get(3).add(new Edge(4, 1));

        int source = 0;
        int[] distances = new int[n];

        dijkstra(graph, source, distances);

        // Output the shortest distances from the source vertex to all other vertices
        System.out.println("Shortest distances from vertex " + source + " to all other vertices:");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }
}
