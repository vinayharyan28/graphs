package graphconcept.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraAlgorithmDirectedGraph {
    static class Edge{
        int destination;
        int weight;
        public Edge(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<ArrayList<Edge>> graph, int vertex){
        for (int i=0; i<vertex; i++){
            graph.add(new ArrayList<>());
        }
    }

    static void addEdge(ArrayList<ArrayList<Edge>> graph, int source, int destination, int weight){
        graph.get(source).add(new Edge(destination, weight));
    }

    static int[] dijkstra(int source, int vertices, ArrayList<ArrayList<Edge>> graph){
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        priorityQueue.offer(new Edge(source, 0));
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            int current = edge.destination;
            for (Edge neighbour: graph.get(current)){
                int newDistance = distance[current] + neighbour.weight;
                if (newDistance < distance[neighbour.destination]){
                    distance[neighbour.destination] = newDistance;
                    priorityQueue.offer(new Edge(neighbour.destination, newDistance));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int vertex = 5, source = 0;
        createGraph(graph, vertex);
        addEdge(graph, 0, 1, 2);
        addEdge(graph, 0, 3, 1);
        addEdge(graph, 3, 2, 2);
        addEdge(graph, 3, 4, 4);
        addEdge(graph, 1, 2, 3);
        addEdge(graph, 2, 0, 5);
        addEdge(graph, 4, 2, 1);
        System.out.println(graph);
        int[] result = dijkstra(source, vertex, graph);

        for (int i=0; i<vertex; i++){
            System.out.println("vertex " + i + " to " + result[i]);
        }
    }
}
