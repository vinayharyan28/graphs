package graphconcept.prims;

import java.util.ArrayList;
import java.util.HashSet;

public class PrimsAlgorithmTest {
    private static class Edge{
        int source, destination, weight;
        public Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    static void addEdge(int source, int destination, int weight, ArrayList<Edge> graph){
        graph.add(new Edge(source, destination, weight));
        graph.add(new Edge(destination, source, weight));
    }

    static ArrayList<Edge> primsAlgorithm(ArrayList<Edge> graph, int vertex){
        HashSet<Integer> visited = new HashSet<>();
        ArrayList<Edge> minimumSpanningTree = new ArrayList<>();
        visited.add(0);
        for (int i=1; i<vertex; i++){
            int minimumWeight = Integer.MAX_VALUE;
            Edge minimumEdge = null;
            for (int source: visited){
                for (Edge edge: graph){
                    if (source == edge.source && !visited.contains(edge.destination) && edge.weight < minimumWeight){
                        minimumWeight = edge.weight;
                        minimumEdge = edge;
                    }
                }
            }

            if (minimumEdge != null){
                minimumSpanningTree.add(minimumEdge);
                visited.add(minimumEdge.destination);
            }
        }
        return minimumSpanningTree;
    }

    public static void main(String[] args){
        ArrayList<Edge> graph = new ArrayList<>();
        addEdge(0, 1, 2, graph);
        addEdge(0, 2, 4, graph);
        addEdge(1, 3, 5, graph);
        addEdge(1, 2, 3, graph);
        addEdge(2, 3, 6, graph);
        addEdge(3, 4, 7, graph);
        int vertex = 5;
        ArrayList<Edge> result = primsAlgorithm(graph, vertex);
        for (Edge edge: result){
            System.out.println("source: " + edge.source + " destination: " + edge.destination + " weight: " + edge.weight);
        }
    }
}
