import java.util.*;

/**
 * Tree class of type <T>
 * Each instance has a value (often called vertex) and a List<Tree<T>> of children.
 * Therefore, each instance of the class Tree<T> is actually an instance of a singular node in the tree structure to be, or being built.
 * In graph theory, all trees are graphs, but not all graphs are trees.
 * Each tree consists of a root node, which has 0 to many children. a Binary tree is defined as a tree with no more than two children.
 * Binary trees are probably the easiest to understand and conceptualize.
 * a binary search tree (BST) would be a tree that is sorted.
 * More on Trees here: https://en.wikipedia.org/wiki/Tree_(data_structure)
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
     * Constructor
     * @param value of type T. value to be given to this node.
     */
    private Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
 
    /**
     * makes a root node
     * @param value of type T
     * @return new Tree Node with the specified vertex
     */
    public static <T> Tree<T> makeRoot(T value) {
        return new Tree<>(value);
    }

    /**
     * Acessor method for the left child of this Tree node.
     * @return the left child of type Tree<T>.
     */
    public Tree<T> getLeft(){
        return children.get(0);
    }

    /**
     * Acessor method for the right child of this Tree node.
     * @return the right child of type Tree<T>.
     */
    public Tree<T> getRight(){
        return children.get(1);
    }
 
    /**
     * add a child node to this node
     * @param value of type T. The value of the child to add.
     */
    public Tree<T> addChild(T value) {
         Tree<T> newChild = new Tree<>(value);
        children.add(newChild);
        return newChild;
    }

    /**
     * Accessor, returns the value of the node
     */
    public T getValue(){
        return this.value;
    }

    /**
     * Acessor, returns List<Tree<T>> of this nodes children.
     */
    public List<Tree<T>> getChildren(){
        return this.children;
    }

    /**
     * Search function, allows one to search for a node in the tree.
     * Implemetation of a breadth-first-search.
     * @param value of type T, the value we want to find.
     * @param root the node to start our breadth-first-search from.
     * @return the found node or empty() if node not found.
     */
    public static <T> Optional<Tree<T>> breadthFirstSearch(T value, Tree<T> root) {
        //Use a queue to traverse the nodes. Add root node to queue.
        Queue<Tree<T>> queue = new ArrayDeque<>();
        queue.add(root);

        //While queue isn't empty, pop a Node from the queue.
        while(!queue.isEmpty()) {
             Tree<T> visitingNode = queue.remove();
             System.out.println("visitingNode = " + visitingNode.getValue());

            //If we found the node, return it. Else add all its children to our queue.
            if (visitingNode.getValue().equals(value)) {
                System.out.println("Node Found. Node: " + visitingNode.getValue());
                return Optional.of(visitingNode);
            } else {
                queue.addAll(visitingNode.getChildren());
            }
        }
        //If queue is empty, node not found.
        System.out.println("Node " + value + " Not found.");
        return Optional.empty();
    }

    /**
     * A pre order traversal method which runs recursively.
     * @param node the node to start at.
     */
    public void preOrderRecursive(Tree<T> node){
        if (node != null) {
            System.out.println("Visiting node " + node.value);
            preOrderRecursive(node.getLeft());
            preOrderRecursive(node.getRight());
        }
        else {
            System.out.println("Nothing to traverse");
        }
    }
}