package graphconcept.bipartitegraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    static class Edge {
        int source;
        int destination;

         Edge(int source, int destination){
            this.source = source;
            this.destination = destination;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph){
        for(int i=0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        //graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        //graph[4].add(new Edge(4, 3));
    }

    static boolean isBipartite(ArrayList<Edge>[] graph){
        int[] colour = new int[graph.length];
        Arrays.fill(colour, -1);

        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<graph.length; i++){
            if (colour[i] == -1){ // BFS
                queue.add(i);
                colour[i] = 0; //Red
                while (!queue.isEmpty()){
                    int current = queue.remove();
                    for (int j=0; j<graph[current].size(); j++){
                        Edge edge = graph[current].get(j);
                        if (colour[edge.destination] == -1){
                            int nextColour = colour[current] == 0 ? 1 : 0;
                            colour[edge.destination] = nextColour;
                            queue.add(edge.destination);
                        }else if(colour[edge.destination] == colour[current]){
                            return false; // Not bipartite
                        }
                    }
                }

            }
        }

        return true;
    }


    public static void main(String[] args) {
        int vertex = 5;
        ArrayList<Edge>[] graph = new ArrayList[vertex];
        createGraph(graph);
        System.out.println(isBipartite(graph));

    }

}
