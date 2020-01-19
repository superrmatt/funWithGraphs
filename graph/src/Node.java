
/**
 * Class Node<T>
 * A node is an indivisible unit of a graph. Nodes make up graphs.
 * A node has a value (of type T)
 * A node has neighbors in an undirected graph (this).
 * A directed graph (digraph) would have children, much like a tree, but a digraph can have cycles, unlike a tree.
 */
public class Node<T> {
    
    /**
     * Value of type T. Often referred to as vertex in graph theory.
     */
    private T value;
    private Set<Node<T>> neighbors;
 
    public Node(T value) {
        this.value = value;
        this.neighbors = new HashSet<>();
    }
 
    public void connect(Node<T> node) {
        if (this == node) throw new IllegalArgumentException("Can't connect node to itself");
        this.neighbors.add(node);
        node.neighbors.add(this);
    }
}