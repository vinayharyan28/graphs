package graphconcept.minimumspanningtree;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithms {
    static class Edge implements Comparable<Edge>{
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight){
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge){
            return this.weight - edge.weight;
        }

    }

    static int n = 4; // Vertices
    static int[] parent = new int[n];
    static int[] rank = new int[n];

    static void init(){
        for (int i=0; i<n; i++){
            parent[i] = i;
        }
    }

    static int find(int x){
        if (x == parent[x]){
            return x;
        }

        return parent[x] = find(parent[x]); //Path compression
    }

    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if (rank[parentA] == rank[parentB]){
            parent[parentB] = parentA;
            rank[parentA]++;
        }else if (rank[parentA] < rank[parentB]){
            parent[parentA] = parentB;
        }else {
            parent[parentB] = parentA;
        }
    }

    static void kruskal(ArrayList<Edge> edges, int vertex){
        init();
        Collections.sort(edges);
        int mstCost = 0;
        int count = 0;

        for(int i=0; count<vertex-1; i++){
            Edge e = edges.get(i);
            int parentA = find(e.source);
            int parentB = find(e.destination);
            if (parentA != parentB){
                union(e.source, e.destination);
                mstCost += e.weight;
                count++;
            }
        }

        System.out.println("cost " + mstCost);
    }

    static void createGraph(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    public static void main(String[] args) {
        int vertex = 4;
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);
        kruskal(edges, vertex);
    }
}
