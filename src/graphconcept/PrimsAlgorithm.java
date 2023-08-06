package graphconcept;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class PrimsAlgorithm {

    static class Edge {

        int u; // source vertex
        int v; // destination vertex
        int weight; // weight of the edge

        public Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    private final int V; // number of vertices
    private final List<Edge> edges; // list of edges in the graph
    private final List<Edge> mst; // minimum spanning tree

    public PrimsAlgorithm(int V, List<Edge> edges) {
        this.V = V;
        this.edges = edges;
        this.mst = new ArrayList<>();
    }

    public List<Edge> findMST() {
        // initialize the MST
        mst.clear();

        // create a set to store the vertices that are already in the MST
        Set<Integer> visited = new HashSet<>();

        // choose an arbitrary vertex as the starting vertex of the MST
        int start = 0;
        visited.add(start);

        // iterate over all the vertices that are not in the MST
        for (int v = 1; v < V; v++) {
            // find the minimum weight edge that connects a vertex in MST to a vertex not in MST
            int minWeight = Integer.MAX_VALUE;
            Edge minEdge = null;
            for (int u : visited) {
                for (Edge e : edges) {
                    if (e.u == u && !visited.contains(e.v) && e.weight < minWeight) {
                        minWeight = e.weight;
                        minEdge = e;
                    }
                }
            }

            // if the edge does not create a cycle, add it to the MST
            if (minEdge != null) {
                mst.add(minEdge);
                visited.add(minEdge.v);
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        // create a graph
        int V = 5;
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 4));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 5));
        edges.add(new Edge(2, 3, 6));
        edges.add(new Edge(3, 4, 7));

        // create a PrimMST object
        PrimsAlgorithm primMST = new PrimsAlgorithm(V, edges);

        // find the minimum spanning tree
        List<Edge> mst = primMST.findMST();

        // print the minimum spanning tree
        for (Edge e : mst) {
            System.out.println(e.u + " - " + e.v + " : " + e.weight);
        }
    }

}




