package hm222yj.graphs.graphs.abstractgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public abstract class AbstractGraph {
    int node;
    Map<Integer, Map<Integer, Double>> adjacent;

    public AbstractGraph(int node) {
        this.node = node;
        this.adjacent = new HashMap<>();
        for (int v = 0; v < node; v++) {
            adjacent.put(v, new HashMap<>());
        }
    }

    public int nodeCount() {
        return node;
    }

    public boolean hasEdge(int v, int w) {
        return adjacent.get(v).containsKey(w);
    }

    public double weight(int v, int w) {
        Map<Integer, Double> row = adjacent.get(v);
        return row.get(w);
    }

    public Iterable<Integer> nodes() {
        List<Integer> nodeList = new ArrayList<>(node);
        for (int i = 0; i < node; i++) {
            nodeList.add(i);
        }
        return nodeList;
    }

    public Iterable<Integer> neighbors(int v) {
        return new ArrayList<>(adjacent.get(v).keySet());
    }

    public Iterable<int[]> edges() {
        List<int[]> list = new ArrayList<>();
        boolean directed = isDirected();
        for (int u = 0; u < node; u++) {
            for (int v : adjacent.get(u).keySet()) {
                if (directed) {
                    list.add(new int[] { u, v });
                } else {
                    if (u <= v)
                        list.add(new int[] { u, v });
                }
            }
        }
        return list;
    }

    public void addEdge(int u, int v) {
        addEdge(u, v, 1.0);
    }

    public abstract void addEdge(int u, int v, double w);

    public abstract void removeEdge(int u, int v);

    public abstract int degree(int v);

    public abstract int edgeCount();

    public abstract boolean isDirected();

}
