package hm222yj.graphs.graphs.abstractgraph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collections;
import java.util.Deque;

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
        addEdge(v, w, 1.0);
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

    /// Depth first metoder
    public boolean depthFirstCheckIfPathExists(int from, int to) {
        if (from == to) {
            return true;
        }
        boolean[] marked = new boolean[node];
        return depthFirstExists(from, to, marked);
    }

    public boolean depthFirstExists(int current, int target, boolean[] marked) {
        if (current == target) {
            return true;
        }
        marked[current] = true;
        for (int neighbor : neighbors(current)) {
            if (!marked[neighbor]) {
                if (depthFirstExists(neighbor, target, marked)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Iterable<Integer> depthFirstGetPath(int from, int to) {
        List<Integer> path = new ArrayList<>();
        if (from == to) {
            path.add(from);
            return path;
        }
        boolean[] marked = new boolean[node];
        int[] parent = new int[node];
        for (int i = 0; i < node; i++) {
            parent[i] = -1;
        }
        if (depthFirstBuildPath(from, to, marked, parent)) {
            return depthFirstAndBreadthFirstBuildPathFromParents(from, to, parent);
        }
        return path;
    }

    public boolean depthFirstBuildPath(int current, int target, boolean[] marked, int[] parent) {
        if (current == target) {
            return true;
        }
        marked[current] = true;
        for (int neighbor : neighbors(current)) {
            if (!marked[neighbor]) {
                parent[neighbor] = current;
                if (depthFirstBuildPath(neighbor, target, marked, parent))
                    return true;
            }
        }
        return false;
    }

    // Breadth First metoder
    public boolean breadthFirstCheckIfPathExists(int from, int to) {
        if (from == to) {
            return true;
        }
        boolean[] marked = new boolean[node];
        Deque<Integer> queue = new ArrayDeque<>();
        marked[from] = true;
        queue.add(from);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (current == to) {
                return true;
            }
            for (int neighbor : neighbors(current)) {
                if (!marked[neighbor]) {
                    marked[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }


    public Iterable<Integer> breadthFirstGetPath(int from, int to) {
        List<Integer> path = new ArrayList<>();
        if (from == to) {
            path.add(from);
            return path;
        }

        boolean[] marked = new boolean[node];
        int[] parent = new int[node];
        for (int i = 0; i < node; i++) {
            parent[i] = -1;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        marked[from] = true;
        queue.add(from);

        while (!queue.isEmpty()) {
            int current = queue.remove();
            if (current == to) {
                
                return depthFirstAndBreadthFirstBuildPathFromParents(from, to, parent);
            }
            for (int neighbor : neighbors(current)) {
                if (!marked[neighbor]) {
                    marked[neighbor] = true;
                    parent[neighbor] = current;
                    queue.add(neighbor);
                }
            }
        }
        return path; 
    }

    // Byggmetod för både DEpth first och Breadth first
    public Iterable<Integer> depthFirstAndBreadthFirstBuildPathFromParents(int from, int to, int[] parent) {
        List<Integer> reversedPath = new ArrayList<>();
        for (int x = to; x != -1; x = parent[x]) {
            reversedPath.add(x);
            if (x == from) {
                break;
            }
        }
        Collections.reverse(reversedPath);
        return reversedPath;
    }
}
