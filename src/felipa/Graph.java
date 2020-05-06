package felipa;

import java.util.List;
import java.util.Map;

public class Graph {
    private class Pair {

    }

    // default is directional edges is true,
    // can only be modified when graph is initially created
    // when set to false,
    // create 2 edges, one from P->Q and another from Q->P with same weight
    private boolean directionalEdges;

    private int edgesCount = 0;

    //map that holds all vertices in the graph
    private Map<String, Vertex> vMap;

    //custom pair to store vertices labels and their weights
    //using VPair = pair<string, int>;

    // custom compare class to compare pair objects for dijkstra and prim's
    // algorithms
//    struct CustomCompare {
//        bool operator()(VPair P1, VPair P2) {
//            return P1.second > P2.second;
//        }
//    };


    // constructor, empty graph
    public Graph(boolean DirectionalEdges) {

    }

    // @return true if vertex added, false if it already is in the graph
    public boolean add(String label) {

    }

    // @return true if vertex is in the graph
    public boolean contains(String label) {

    }

    // @return total number of vertices
    public int verticesSize() {

    }

    // Add an edge between two vertices, create new vertices if necessary
    // A vertex cannot connect to itself, cannot have P->P
    // For digraphs (directed graphs), only one directed edge allowed, P->Q
    // Undirected graphs must have P->Q and Q->P with same weight
    // @return true if successfully connected
    public boolean connect(String from, String to, int Weight) {

    }

    // Remove edge from graph
    // @return true if edge successfully deleted
    boolean disconnect(String from, String to) {

    }

    // @return total number of edges
    public int edgesSize() {

    }

    // @return number of edges from given vertex, -1 if vertex not found
    public int neighborsSize(String label) {

    }

    // @return string representing edges and weights, "" if vertex not found
    // A-3->B, A-5->C should return B(3),C(5)
    public String getEdgesAsString(String label) {
        return "";
    }

    // Read edges from file
    // first line of file is an integer, indicating number of edges
    // each line represents an edge in the form of "string string int"
    // vertex labels cannot contain spaces
    // @return true if file successfully read
    public boolean readFile(String filename) {

    }

//    // depth-first traversal starting from given startLabel
//    public void dfs(string &StartLabel, void Visit(string&Label))
//
//    {
//
//    }

//    // breadth-first traversal starting from startLabel
//    // call the function visit on each vertex label */
//    public void bfs(string &StartLabel, void Visit(string&Label))
//
//    {
//
//    }

    // dijkstra's algorithm to find shortest distance to all other vertices
    // and the path to all other vertices
    // Path cost is recorded in the map passed in, e.g. weight["F"] = 10
    // How to get to the vertex is recorded previous["F"] = "C"
    // @return a pair made up of two map objects, Weights and Previous
//    public Pair<Map<String, Integer>, Map<String, String>>
//    dijkstra(String startLabel) {
//
//    }

    public List<Vertex> topologicalSort() {

    }

    // minimum spanning tree
    // ONLY works for NONDIRECTED graphs
    // ASSUMES the edge [P->Q] has the same weight as [Q->P]
//    // @return length of the minimum spanning tree or -1 if start vertex not
//    public int mst( String &StartLabel, void Visit( string &From,  string &To, int Weight)) {
//
//    }

    //helper method to check if two vertices are connected
    private boolean isConnected(String from, String to) {

    }


    //edge comparator for ascending sorting
    private static boolean compareEdges(Edge e1, Edge e2) {

    }

    //edge comparator for descending sorting
    private static boolean descendingOrder(Edge e1, Edge e2) {

    }

}
