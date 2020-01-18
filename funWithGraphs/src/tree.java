import java.util.*;


/**
 * Tree class
 */
public class Tree<T> {
    /**
     * value of type T
     */
    private T value;

    /**
     * List of Tree<T> of all the children
     */
    private List<Tree<T>> children;
 
    /**
     * Contructor
     * @param value of type T
     */
    private Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
 
    /**
     * 
     * @param <T>
     * @param value of type T
     * @return new Tree
     */
    public static <T> Tree<T> of(T value) {
        return new Tree<>(value);
    }
 
    public Tree<T> addChild(T value) {
        Tree<T> newChild = new Tree<>(value);
        children.add(newChild);
        return newChild;
    }

    /**
     * Search function, allows one to search for a node in the tree.
     * implemetation of a breadth first search.
     * @param <T>
     * @param value
     * @param root
     * @return
     */
    public static <T> Optional<Tree<T>> search(T value, Tree<T> root) {
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            Tree<T> currentNode = queue.remove();
        }
    }
}