package graphconcept;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BellmanFordAlgorithmTest {
    private static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static void bellmanFord(List<Edge> edges, int vertices, int source, int[] distance) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        for (int i = 1; i < vertices; i++) {
            for (Edge edge : edges) {
                int u = edge.source;
                int v = edge.destination;
                int w = edge.weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                    distance[v] = distance[u] + w;
                }
            }
        }

        // Check for negative cycles
        for (Edge edge : edges) {
            int u = edge.source;
            int v = edge.destination;
            int w = edge.weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                System.out.println("Graph contains a negative cycle.");
                return;
            }
        }
    }

    public static void main(String[] args) {
        int vertices = 5;
        int source = 0;
        int[] distance = new int[vertices];
        List<Edge> edges = new ArrayList<>();
//        edges.add(new Edge(0, 1, 5));
//        edges.add(new Edge(0, 2, 3));
//        edges.add(new Edge(1, 2, 2));
//        edges.add(new Edge(1, 3, 6));
//        edges.add(new Edge(2, 3, 7));
//        edges.add(new Edge(2, 4, 4));
//        edges.add(new Edge(3, 4, -10));


        edges.add(new Edge(0, 1, 3));
        edges.add(new Edge(0, 2, 5));
        edges.add(new Edge(2, 1, 2));
        edges.add(new Edge(2, 3, -3));
        edges.add(new Edge(3, 4, -1));
        edges.add(new Edge(4, 2, -4));

        bellmanFord(edges, vertices, source, distance);

        System.out.println("Shortest distances from vertex " + source + " to all other vertices:");
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": " + distance[i]);
        }
    }
}





