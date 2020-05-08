package felipa;

import java.util.List;

public class Vertex {

    private String label;
    private List<Edge> neighbors;

    /**
     * Creates an unvisited vertex, gives it a label, and clears its
     * adjacency list.
     * NOTE: A vertex must have a unique label that cannot be changed.
     */
    public Vertex(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label;
    }

    public List<Edge> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Edge> neighbors) {
        this.neighbors = neighbors;
    }

    public boolean equals(Vertex other) {
        return label.equalsIgnoreCase(other.label);
    }
}
