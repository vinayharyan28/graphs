package graphconcept.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KhansAlgorithm {
    static class Edge {
        int source;
        int destination;

        Edge (int source, int destination){
            this.source = source;
            this.destination = destination;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
        for (int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

    }

    static void calculateInDegree(ArrayList<Edge>[] graph, int[] inDegree){
        for (int i=0; i<graph.length; i++){
            int v = i;
            for (int j=0; j<graph[v].size(); j++){
                Edge e = graph[v].get(j);
                inDegree[e.destination]++;
            }
        }
    }

    static void khansAlgorithm(ArrayList<Edge>[] graph){
        int[] inDegree = new int[graph.length];
        calculateInDegree(graph, inDegree);
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<inDegree.length; i++){
            if (inDegree[i] == 0){
                queue.add(i);
            }
        }

        //BFS
        while (!queue.isEmpty()){
            int current = queue.remove();
            System.out.print(current + " ");

            for (int i=0; i<graph[current].size(); i++){
                Edge e = graph[current].get(i);
                inDegree[e.destination]--;
                if(inDegree[e.destination] == 0){
                    queue.add(e.destination);
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int vertex = 6;
        ArrayList<Edge>[] graph = new ArrayList[vertex];
        createGraph(graph);
        khansAlgorithm(graph);

    }
}
