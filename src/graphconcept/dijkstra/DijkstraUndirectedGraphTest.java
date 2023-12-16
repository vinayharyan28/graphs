package graphconcept.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraUndirectedGraphTest {
    private static class Edge{
        int destination;
        int weight;

        public Edge(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void createGraph(ArrayList<ArrayList<Edge>> graph, int vertices){
        for (int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }
    }

    static void addEdge(ArrayList<ArrayList<Edge>> graph, int source, int destination, int weight){
        graph.get(source).add(new Edge(destination, weight));
        graph.get(destination).add(new Edge(source, weight));
    }

    static int[] dijkstra(ArrayList<ArrayList<Edge>> graph, int source, int vertices){
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((a,b)->a.weight-b.weight);
        priorityQueue.offer(new Edge(source, 0));
        while (!priorityQueue.isEmpty()){
            Edge edge = priorityQueue.poll();
            int currentVertex = edge.destination;
            for (Edge neighbour: graph.get(edge.destination)){
                int newDistance = distance[currentVertex] + neighbour.weight;
                if (newDistance < distance[neighbour.destination]){
                    distance[neighbour.destination] = newDistance;
                    priorityQueue.offer(new Edge(neighbour.destination, newDistance));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        int vertices = 5, source=0;
        createGraph(graph, vertices);
        addEdge(graph, 0, 1, 5);
        addEdge(graph, 0, 2, 3);
        addEdge(graph, 1, 2, 2);
        addEdge(graph, 1, 3, 6);
        addEdge(graph, 2, 4, 4);
        addEdge(graph, 2, 3, 7);
        int[] distance = dijkstra(graph, source, vertices);
        for (int i=0; i<vertices; i++){
            System.out.println("vertex " + i + " " + distance[i]);
        }
    }
}
