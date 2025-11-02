# Programmeringsuppgift 3
## Bygg
./gradlew build
## Kör
./gradlew run

### Modifiera tester
I App.java kan ni ändra på rad 15 och 16 för att öka storleken på våra grafer och lägga till kopplingar (edges) mellan noderna på rad 66-82 för directed graph och rad 54-59 för undirected graph.


```java
        DirectedGraph directedGraph = new DirectedGraph(5);  
        UnDirectedGraph unDirectedGraph = new UnDirectedGraph(5);```
```

```java
        directedGraph.addEdge(0, 1);
        directedGraph.addEdge(0, 4);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 7);
        directedGraph.addEdge(4, 5);
        directedGraph.addEdge(5, 2);
        directedGraph.addEdge(5, 9);
        directedGraph.addEdge(6, 3);
        directedGraph.addEdge(7, 6);
        directedGraph.addEdge(7, 8);
        directedGraph.addEdge(8, 5);
        directedGraph.addEdge(8, 9);
        directedGraph.addEdge(9, 7);
        directedGraph.addEdge(1, 2, 2.5);
        directedGraph.addEdge(1, 5, 1.2);
        directedGraph.addEdge(4, 8, 3.3);
        directedGraph.addEdge(6, 9, 0.7);
```

```java
        unDirectedGraph.addEdge(0, 1);
        unDirectedGraph.addEdge(0, 4);
        unDirectedGraph.addEdge(2, 3);
        unDirectedGraph.addEdge(3, 7);
        unDirectedGraph.addEdge(4, 5);
        unDirectedGraph.addEdge(5, 2);
        unDirectedGraph.addEdge(5, 9);
        unDirectedGraph.addEdge(6, 3);
        unDirectedGraph.addEdge(7, 6);
        unDirectedGraph.addEdge(7, 8);
        unDirectedGraph.addEdge(8, 5);
        unDirectedGraph.addEdge(8, 9);
        unDirectedGraph.addEdge(9, 7);
        unDirectedGraph.addEdge(1, 2, 2.5);
        unDirectedGraph.addEdge(1, 5, 1.2);
        unDirectedGraph.addEdge(4, 8, 3.3);
        unDirectedGraph.addEdge(6, 9, 0.7);
```