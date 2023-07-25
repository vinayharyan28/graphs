package graphconcept;
import java.util.*;


public class GraphTraversal {
    static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination){
        graph.get(source).add(destination);
        graph.get(destination).add(source);
    }

    static void createGraph(ArrayList<ArrayList<Integer>> graph, int vertex){
        for (int i=0; i<=vertex; i++){
            graph.add(new ArrayList<>());
        }
    }

    static void printGraph(ArrayList<ArrayList<Integer>> graph){
        for (ArrayList<Integer> rows: graph){
            System.out.println(rows);
        }
    }

    static void bfs(ArrayList<ArrayList<Integer>> graph, int source){
        boolean[] visited = new boolean[7];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(source);

        while (queue.size()!=0){
            int element = queue.poll();
            System.out.print(element + " ");
            for (int n: graph.get(element)){
                if (!visited[n]){
                    visited[n] = true;
                    queue.offer(n);
                }
            }
        }
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int vertex){
        visited[vertex] = true;
        System.out.print(vertex + " ");
        for (int n: graph.get(vertex)){
            if (!visited[n]){
                dfs(graph, visited, n);
            }
        }
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        createGraph(graph, 6);

        /*
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 5);
        addEdge(graph, 3, 4);
        addEdge(graph, 4, 6);
        addEdge(graph, 5, 6);
        addEdge(graph, 4, 5);
        */

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 1, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 2, 5);
        addEdge(graph, 3, 6);
        addEdge(graph, 5, 6);
        addEdge(graph, 4, 3);
        printGraph(graph);
        bfs(graph, 1);
        System.out.println();
        System.out.println("DFS");
        boolean[] visited = new boolean[7];
        dfs(graph, visited, 0);
    }
}
