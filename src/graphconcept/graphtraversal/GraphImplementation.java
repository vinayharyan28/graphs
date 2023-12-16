package graphconcept.graphtraversal;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphImplementation {
    static void addMatrixEdge(int[][] graphMatrix, int source, int destination){
        graphMatrix[source][destination] = 1;
        graphMatrix[destination][source] = 1;
    }

    static void addAdjacencyList(ArrayList<ArrayList<Integer>> adj, int source, int destination){
        adj.get(source).add(destination);
        adj.get(destination).add(source);
    }

    static void printMatrix(int[][] graphMatrix){
        for (int[] row: graphMatrix){
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        int vertex = 5;

        // matrix
        int[][] graphMatrix = new int[vertex+1][vertex+1];
        addMatrixEdge(graphMatrix, 3, 5);
        addMatrixEdge(graphMatrix, 5, 4);
        addMatrixEdge(graphMatrix, 5, 1);
        addMatrixEdge(graphMatrix, 4, 2);
        addMatrixEdge(graphMatrix, 4, 1);
        addMatrixEdge(graphMatrix, 1, 2);
        printMatrix(graphMatrix);

        // adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0; i<=vertex; i++){
            adj.add(new ArrayList<>());
        }

        addAdjacencyList(adj, 3, 5);
        addAdjacencyList(adj, 5, 4);
        addAdjacencyList(adj, 5, 1);
        addAdjacencyList(adj, 4, 2);
        addAdjacencyList(adj, 4, 1);
        addAdjacencyList(adj, 1, 2);
        System.out.println(adj);
    }
}
