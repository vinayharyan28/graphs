package graphconcept.topologicalsort;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
    }

    static void createGraph(ArrayList<ArrayList<Integer>> graph, int vertex){
        for (int i=0; i<=vertex; i++){
            graph.add(new ArrayList<>());
        }
    }

    static void topologicalSortAlgorithm(ArrayList<ArrayList<Integer>> graph, int current, boolean[] visited, Stack<Integer> stack){
        visited[current] = true;
        for(int neighbour: graph.get(current)){
            if (!visited[neighbour]){
                topologicalSortAlgorithm(graph, neighbour, visited, stack);
            }
        }
        stack.push(current);
    }

    static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int vertex){
        boolean[] visited = new boolean[vertex+1];
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<=5; i++){
            if (!visited[i]){
                topologicalSortAlgorithm(graph, i, visited, stack);
            }
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int vertex = 5;
        createGraph(graph, vertex);
        addEdge(graph, 5, 0);
        addEdge(graph, 4, 0);
        addEdge(graph, 5, 2);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 1);
        addEdge(graph, 4, 1);
        System.out.println(graph);
        topologicalSort(graph, vertex);
    }
}
