package graphconcept;

import java.util.ArrayList;
import java.util.Stack;

public class KosarajuAlgorithm {
    static void addEdge(int source, int destination, ArrayList<ArrayList<Integer>> graph){
        graph.get(source).add(destination);
    }

    static void createGraph(ArrayList<ArrayList<Integer>> graph, int vertices){
        for (int i=0; i<vertices; i++){
            graph.add(new ArrayList<>());
        }
    }

    static void topologySort(ArrayList<ArrayList<Integer>> graph, int currentVertex, Stack<Integer> stack, boolean[] visited){
        visited[currentVertex] = true;
        for (int neighbour: graph.get(currentVertex)){
            if (!visited[neighbour]){
                topologySort(graph, neighbour, stack, visited);
            }
        }
        stack.push(currentVertex);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int current, boolean[] visited){
        visited[current] = true;
        System.out.print(current + " ");
        for (int neighbour: graph.get(current)){
            if (!visited[neighbour]){
                dfs(graph, neighbour, visited);
            }
        }
    }

    static void kosarajuAlgorithm(ArrayList<ArrayList<Integer>> graph, int vertices){
        //Step1:
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[vertices];
        for (int i=0; i<vertices; i++){
            if (!visited[i]){
                topologySort(graph, i, stack, visited);
            }
        }

        //Step2:
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        createGraph(transpose, vertices);
        for (int i=0; i<vertices; i++){
            visited[i] = false;
            for (int neighbour: graph.get(i)){
                addEdge(neighbour, i, transpose);
            }
        }

        //Step3
        while (!stack.isEmpty()){
            int current = stack.pop();
            if (!visited[current]){
                System.out.print("Strongly connected component: ");
                dfs(transpose, current, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        int vertices = 5;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        createGraph(graph, vertices);
        addEdge(1, 0, graph);
        addEdge(0, 2, graph);
        addEdge(2, 1, graph);
        addEdge(0, 3, graph);
        addEdge(3, 4, graph);


        kosarajuAlgorithm(graph, vertices);
    }
}
