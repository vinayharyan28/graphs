package graphconcept;

import java.util.ArrayList;
import java.util.Arrays;

public class BellmanFordAlgorithmUndirected {
    private static class Edge{
        int source, destination, weight;
        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void addEdge(ArrayList<Edge> graph, int source, int destination, int weight){
        graph.add(new Edge(source, destination, weight));
        graph.add(new Edge(destination, source, weight));
    }

    static int[] bellmanFord(int source, int vertices, ArrayList<Edge> graph){
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        for (int i=1; i<vertices; i++){
            for (Edge edge: graph){
                if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]){
                    distance[edge.destination] = distance[edge.source] + edge.weight;
                }
            }
        }

        for (Edge edge: graph){
            if (distance[edge.source] != Integer.MAX_VALUE && distance[edge.source] + edge.weight < distance[edge.destination]){
                System.out.println("negative cycle present.");
                break;
            }
        }

        return distance;
    }

    public static void main(String[] args){
        ArrayList<Edge> graph = new ArrayList<>();
        addEdge(graph, 0, 1, 5);
        addEdge(graph, 0, 2, 3);
        addEdge(graph, 1, 2, 2);
        addEdge(graph, 2, 3, 7);
        addEdge(graph, 2, 4, 4);
        addEdge(graph, 3, 4, -10);
        int vertices=5, source=0;
        int[] distance = bellmanFord(source, vertices, graph);
        for (int i=0; i<distance.length; i++){
            System.out.println(i + " to " + distance[i]);
        }
    }

}
