package hm222yj.graphs.graphs.undirected;

import hm222yj.graphs.graphs.abstractgraph.AbstractGraph;

public class UnDirectedGraph extends AbstractGraph {
    public UnDirectedGraph(int node) {
        super(node);
    }

    @Override
    public void addEdge(int v, int w, double weight) {
        if (v == w) {
            return; // Vi struntar i looparna för tillfället.
        }
        adjacent.get(v).put(w, weight);
        adjacent.get(w).put(v, weight);
    }

    @Override
    public void removeEdge(int v, int w) {
        adjacent.get(v).remove(w);
        adjacent.get(w).remove(v);
    }

    @Override
    public int degree(int v) {
        return adjacent.get(v).size();
    }

    @Override
    public int edgeCount() {
        int sum = 0;
        for (int v = 0; v < node; v++) {
            sum += adjacent.get(v).size();
        }
        return sum / 2; // Här måste vi ta och dela med två för att vi har ju räknat/lagt till alla
                        // kanter två gånger.
    }

    @Override
    public boolean isDirected() {
        return false;
    }
}
