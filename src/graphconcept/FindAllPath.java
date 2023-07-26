package graphconcept;

import java.util.ArrayList;

public class FindAllPath {
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    static void createEmptyGraph(ArrayList<ArrayList<Integer>> graph, int vertex){
        for (int i=0; i<=vertex; i++){
            graph.add(new ArrayList<>());
        }
    }

    static void printAllPaths(ArrayList<ArrayList<Integer>> graph, boolean[] visited, String path, int currentNode, int target){
        if(currentNode == target){
            System.out.println(path);
            return;
        }
        for (int n: graph.get(currentNode)){
            if(!visited[n]){
                visited[currentNode] = true;
                printAllPaths(graph, visited, path+n,n,target);
                visited[currentNode]=false;
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int vertex = 6;
        createEmptyGraph(graph, vertex);
        addEdge(graph, 0, 1);
        addEdge(graph, 1, 3);
        addEdge(graph, 3, 5);
        addEdge(graph, 5, 6);
        addEdge(graph, 5, 4);
        addEdge(graph, 4, 3);
        addEdge(graph, 4, 2);
        addEdge(graph, 2, 0);

        System.out.println(graph);
        boolean[] visited = new boolean[vertex];
        int source=0, target=5;
        //v^V
        printAllPaths(graph, visited, ""+0, source, target);
    }
}
