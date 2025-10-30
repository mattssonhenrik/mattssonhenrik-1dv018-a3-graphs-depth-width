package hm222yj.graphs.graphs.abstractgraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public abstract class AbstractGraph {
    public int node;
    public Map<Integer, Map<Integer, Double>> adjacent;

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

    public void addEdge(int v, int w) {
        addEdge(v, w, 0.0);
    }

    public boolean hasEdge(int v, int w) {
        return adjacent.get(v).containsKey(w);
    }

    public double weight(int v, int w) {
        Double weightValue = adjacent.get(v).get(w);
        return weightValue != null ? weightValue : 0.0; 
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
        for (int v = 0; v < node; v++) {
            for (int w : adjacent.get(v).keySet()) {
                if (directed) {
                    list.add(new int[] { v, w });
                } else {
                    if (v <= w)
                        list.add(new int[] { v, w });
                }
            }
        }
        return list;
    }

    public abstract void addEdge(int v, int w, double weight);

    public abstract void removeEdge(int v, int w);

    public abstract int degree(int v);

    public abstract int edgeCount();

    public abstract boolean isDirected();

}
