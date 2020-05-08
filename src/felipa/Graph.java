package felipa;

import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private class Pair {

    }

    // default is directional edges is true,
    // can only be modified when graph is initially created
    // when set to false,
    // create 2 edges, one from P->Q and another from Q->P with same weight
    private final boolean directionalEdges;

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
    public Graph(boolean directionalEdges) {
        this.directionalEdges = directionalEdges;
        vMap = new HashMap<>();
    }

    // @return true if vertex added, false if it already is in the graph
    public boolean add(String label) {
        if (vMap.containsKey(label))
            return false;
        vMap.put(label, new Vertex(label));
        return true;
    }

    // @return true if vertex is in the graph
    public boolean contains(String label) {
        return vMap.containsKey(label);
    }

    // @return total number of vertices
    public int verticesSize() {
        return vMap.size();
    }

    // Add an edge between two vertices, create new vertices if necessary
    // A vertex cannot connect to itself, cannot have P->P
    // For digraphs (directed graphs), only one directed edge allowed, P->Q
    // Undirected graphs must have P->Q and Q->P with same weight
    // @return true if successfully connected
    public boolean connect(String from, String to, int weight) {
        if (from.equalsIgnoreCase(to))
            return false;
        Vertex vFrom;
        Vertex vTo;
        if (!vMap.containsKey(to)) {
            vTo = new Vertex(to);
            vMap.put(to, vTo);
        }
        if (!vMap.containsKey(from)) {
            vFrom = new Vertex(from);
            vMap.put(from, vFrom);
        }
        if (!isConnected(from, to)) {
            vFrom = vMap.get(from);
            vTo = vMap.get(to);
            Edge newEdge = new Edge(vFrom, vTo, weight);
            vFrom.getNeighbors().add(newEdge);
            edgesCount++;
            return true;
        }
        return false;
    }

    // Remove edge from graph
    // @return true if edge successfully deleted
    public boolean disconnect(String from, String to) {
        boolean disconnected = false;
        Vertex vFrom = vMap.get(from);
        Vertex vTo = vMap.get(to);
        List<Edge> fromNeighbors = vFrom.getNeighbors();
        for (int i = 0; i < fromNeighbors.size(); i++) {
            if (fromNeighbors.get(i).getTo().equals(vTo)) {
                fromNeighbors.remove(i);
                disconnected = true;
                edgesCount--;
                break;
            }
        }
        if (directionalEdges && disconnected) {
            List<Edge> toNeighbors = vTo.getNeighbors();
            for (int i = 0; i < toNeighbors.size(); i++) {
                if (toNeighbors.get(i).getTo().equals(vFrom)) {
                    toNeighbors.remove(i);
                    edgesCount--;
                    break;
                }
            }
        }
        return disconnected;
    }

    // @return total number of edges
    public int edgesSize() {
        return edgesCount;
    }

    // @return number of edges from given vertex, -1 if vertex not found
    public int neighborsSize(String label) {
        if (!vMap.containsKey(label))
            return -1;
        return vMap.get(label).getNeighbors().size();
    }

    // @return string representing edges and weights, "" if vertex not found
    // A-3->B, A-5->C should return B(3),C(5)
//    public String getEdgesAsString(String label) {
//        if (!vMap.containsKey(label))
//            return "";
//        stringstream Ss;
//        Vertex *V = VMap.at(Label);
//        vector<Edge *> List = V->Neighbors;
//        if (List.empty())
//            return "";
//        sort(List.begin(), List.end(), compareEdges);
//        for (int I = 0; I < List.size() - 1; ++I) {
//            Ss << *(List[I]->To) << "(" << List[I]->Weight << ")" << ",";
//        }
//        Ss << *(List[List.size() - 1]->To) << "(" << List[List.size() -
//                1]->Weight << ")";
//        return Ss.str();
//    }

    // Read edges from file
    // first line of file is an integer, indicating number of edges
    // each line represents an edge in the form of "string string int"
    // vertex labels cannot contain spaces
    // @return true if file successfully read
    public boolean readFile(String filename) throws IOException {
        File file = new File(filename);
        BufferedReader in = new BufferedReader(new FileReader(file));
        int count;
        String from = "";
        String to = "";
        int weight = 0;
        count = Integer.parseInt(in.readLine());
        for (int i = 0; i < count; ++i) {
            String[] line = in.readLine().split(" ");
            if (line.length < 3) {

            } else {
                from = line[0];
                to = line[1];
                weight = Integer.parseInt(line[2]);
                if (!directionalEdges)
                    connect(to, from, weight);
                connect(from, to, weight);
            }
        }
        return true;
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

//    public List<Vertex> topologicalSort() {
//
//    }

    // minimum spanning tree
    // ONLY works for NONDIRECTED graphs
    // ASSUMES the edge [P->Q] has the same weight as [Q->P]
//    // @return length of the minimum spanning tree or -1 if start vertex not
//    public int mst( String &StartLabel, void Visit( string &From,  string &To, int Weight)) {
//
//    }

    //helper method to check if two vertices are connected
    private boolean isConnected(String from, String to) {
        Vertex vFrom = vMap.get(from);
        Vertex vTo = vMap.get(to);
        for (Edge neighbor : vFrom.getNeighbors()) {
            if (neighbor.getTo().equals(vTo))
                return true;
        }
        return false;
    }


    //edge comparator for ascending sorting
    private static boolean compareEdges(Edge e1, Edge e2) {
        int compareLabels = e1.getTo().toString().compareTo(e2.getTo().toString());
        if (compareLabels == 0)
            return (e2.getWeight() - e1.getWeight()) < 0;
        return compareLabels < 0;
    }

    //edge comparator for descending sorting
    private static boolean descendingOrder(Edge e1, Edge e2) {
        int compareLabels = e1.getTo().toString().compareToIgnoreCase(e2.getTo().toString());
        if (compareLabels == 0)
            return (e2.getWeight() - e1.getWeight()) > 0;
        return compareLabels > 0;
    }

}
