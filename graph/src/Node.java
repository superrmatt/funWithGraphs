
import java.util.*;

/**
 * Class Node<T>
 * A node is an indivisible unit of a graph. Nodes make up graphs.
 * A node has a value (of type T)
 * A node has neighbors in an undirected graph (this).
 * Undirected graphs are also called bidirectional graphs, since the edges can be travered bidirectionally.
 * This implementation has no root node. Therefore, this is, by default, an undirected graph.
 * A directed graph (digraph) would have children, much like a tree, but a digraph can have cycles, unlike a tree.
 * More on graph theory here: https://en.wikipedia.org/wiki/Graph_theory
 * To ensure clarity, all trees are graphs, but not all graphs are trees.
 */
public class Node<T> {
    
    /**
     * Value of type T. Often referred to as vertex in graph theory.
     */
    private T value;

    /**
     * Set<Node<T>> of this Node's neighbors.
     * Edges dictate no direction, therefore if Node A has neighbors B & C, that means Nodes B & C will also list A as a neighbor. There is no parent->child relationship in undirected graphs.
     */
    private Set<Node<T>> neighbors;
 
    /**
     * Constructor
     * @param value of type T
     */
    public Node(T value) {
        this.value = value;
        this.neighbors = new HashSet<>();
    }
 
    /**
     * creates a connection. in Graph theory a connection is referred to as an edge.
     * It would be the line drawn from one Node (vertex) to another. Like so:
     * Let Graph G = (V, E) where V is set of vertices (Nodes) and E is set of edges.
     * Connect builds E, the edges. lets's say graph G has vertices (A, B, C) and Edges (1, 2, 3).
     * We can illustrate this as so:
     *               A
     *              / \
     *             B - C
     */
    public void connect(Node<T> node) {
        if (this == node) throw new IllegalArgumentException("Can't connect node to itself");
        this.neighbors.add(node);
        node.neighbors.add(this);
    }

    /**
     * Acessor for value.
     * @return T value of this node.
     */
    public T getValue(){
        return this.value;
    }

    /**
     * Accessor for neighbors.
     * @return Set<Node<T>> neighbors of this node.
     */
    public Set<Node<T>> getNeighbors(){
        return this.neighbors;
    }

    /**
     * Similiar to the BFS algorithm for trees, this method must account for the possibility of cycles. 
     * Else method will run endlessly if there exists a cycle.
     * @param value the vertex value of type T to search for.
     * @param start the start node to begin the search.
     * @return the found node, or empty if node does not exist.
     */
    public static <T> Optional<Node<T>> breadthFirstSearch(T value, Node<T> start) {
        //Set of visited nodes.
        Set<Node<T>> alreadyVisited = new HashSet<>();

        //Queue of traversable nodes.
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);
     
        Node<T> visitingNode;
     
        while (!queue.isEmpty()) {
            visitingNode = queue.remove();
            System.out.println("visitingNode = " + visitingNode.getValue());
         
            //If we found node in question, return it. Else, add this Node to alreadyVisited, add all neighbors to queue, and remove this node from queue.
            if (visitingNode.getValue().equals(value)) {
                return Optional.of(visitingNode);
            } else {
                alreadyVisited.add(visitingNode);
                queue.addAll(visitingNode.getNeighbors());
                queue.removeAll(alreadyVisited);
            }
        }
         
        return Optional.empty();
    }
}