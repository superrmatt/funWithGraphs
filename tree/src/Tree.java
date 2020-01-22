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
     * does left child exist?
     * @return true if left exists, false if not
     */
    public boolean isLeft(){
        if(children.size() > 0)
            return true;
        else
            return false;
    }

    /**
     * does right child exist?
     * @return true if left exists, false if not
     */
    public boolean isRight(){
        if(children.size() > 1)
            return true;
        else
            return false;
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

    // -------------------------- Depth First Search Implementations --------------------------
    /**
     * Below is a few implementations of a depth first search on a tree.
     * Since we can traverse a tree in three ways:
     *  - pre order traversal
     *  - inorder traversal
     *  - postorder traversal
     * (More on each traversal style here: https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/)
     * & Since we can implement each recursively and iteratively:
     *  There exist a total of 6 methods below.
     * They will all take two arguments: root, and value.
     * Root will be the starting node. And value will be the value of the node to search for.
     */


    /**
     * A recursive pre order traversal method.
     * Used for depth first search algorithm.
     * @param value the value to search for.
     * @param root the node to start at.
     */
    public static <T> Optional<Tree<T>> preOrderRecursive(T value, Tree<T> root){
        //if node vlaue is correct, return it.
        if(root.getValue() == value){
            return Optional.of(root);
        } 
        //if root is not null, recursive call to this method with left node then right node.
        if (root != null) {
            System.out.println("Visiting node " + root.getValue());
            if(root.isLeft() == true){
                preOrderRecursive(value, root.getLeft());
            }
            if(root.isRight() == true){
                preOrderRecursive(value, root.getRight());
            }
        }
        //return empty, node not found        
        System.out.println("Nothing to traverse, node not found.");
        return Optional.empty();
    }

    /**
     * An iterative pre order traversal method.
     * Used for depth first search algorithm.
     * @param node the node to start at.
     */
    public void preOrderIterative(Tree<T> Node){
        Stack<Tree<T>> stack = new Stack<Tree<T>>();
        Tree<T> visiting = Node;
        stack.push(Node);

        while(!stack.isEmpty()) {
            visiting = stack.pop();
            System.out.println("current node is " + visiting.value);
             
            if(visiting.getRight() != null) {
                stack.push(visiting.getRight());
            }    
            if(visiting.getLeft() != null) {
                stack.push(visiting.getLeft());
            }
        }

    }
}