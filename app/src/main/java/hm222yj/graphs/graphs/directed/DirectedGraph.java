package hm222yj.graphs.graphs.directed;

import hm222yj.graphs.graphs.abstractgraph.AbstractGraph;

public class DirectedGraph extends AbstractGraph {

    public DirectedGraph(int node) {
        super(node);
    }

    // Vår andra addEdge som tar weight, ursprungliga utan weight ligger i vår
    // abstrakta base-klass.
    @Override
    public void addEdge(int v, int w, double weight) {
        if (v == w) {
            return; // Vi struntar i looparna för tillfället.
        }
        adjacent.get(v).put(w, weight);
    }

    @Override
    public void removeEdge(int v, int w) {
        adjacent.get(v).remove(w);
    }

    @Override
    public int degree(int v) {
        return adjacent.get(v).size(); // endast med pekare utåt, alltså vi räknar inte åt båda hållen som i
                                       // undirectedgraph.
    }

    @Override
    public int edgeCount() {
        int sum = 0;
        for (int v = 0; v < node; v++) {
            sum += adjacent.get(v).size(); 
        }
        return sum;
    }

    @Override
    public boolean isDirected() {
        return true;
    }

}
