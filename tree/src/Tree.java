import java.util.*;

/**
 * Tree class of type <T>
 * Each instance has a value (often called vertex) and a List<Tree<T>> of children.
 * Therefore, each instance of the class Tree<T> is actually an instance of a singular node in the tree structure to be, or being built.
 * In graph theory, all trees are graphs, but not all graphs are trees.
 * Each tree consists of a root node, which has 0 to many children. a Binary tree is defined as a tree with no more than two children.
 * Binary trees are probably the easiest to understand and conceptualize.
 * a binary search tree (BST) would be a tree that is sorted and has no more than two children.
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
     * Constructor, is only called by makeRoot(T value), or addChild(T value).
     * This is because we do not want to make a node standalone, then it wouldn't be a tree.
     * @param value of type T. value to be given to this node.
     */
    private Tree(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }
 
    /**
     * Makes a root node, calls constructor.
     * @param value of type T
     * @return new Tree Node with the specified vertex
     */
    public static <T> Tree<T> makeRoot(T value) {
        return new Tree<>(value);
    }
 
    /**
     * Add a child node to this node, calls constructor
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
     * Implemetation of a breadth-first-search. Searches for the T value by starting at the root node given.
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
                System.out.println("breadth first Node Found: " + visitingNode.getValue());
                return Optional.of(visitingNode);
            } else
                queue.addAll(visitingNode.getChildren());
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
     * There exist a total of 6 methods below (eventually =D).
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
        //if node value is correct, return it.
        if(root.getValue() == value){
            System.out.println("Recursive pre order Node found: " + root.getValue());
            return Optional.of(root);
        } 
        //if root is not null, recursive call to this method with left node then right node.
        if (root != null) {
            System.out.println("Visiting node " + root.getValue());
            if(root.isLeft() == true)
                preOrderRecursive(value, root.getLeft());
            
            if(root.isRight() == true)
                preOrderRecursive(value, root.getRight());
            
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
    public static <T> Optional<Tree<T>> preOrderIterative(T value, Tree<T> root){
        //stack for storage of searchable nodes
        Stack<Tree<T>> stack = new Stack<Tree<T>>();
        Tree<T> visiting = root;
        stack.push(root);

        while(!stack.isEmpty()) {
            visiting = stack.pop();
            System.out.println("current node is " + visiting.value);
            if(visiting.getValue() == value){
                System.out.println("Iterative pre order Node found: " + visiting.getValue());
                return Optional.of(visiting);
            }
               
            if(visiting.isLeft() == true)
                stack.push(visiting.getLeft());
            
            if(visiting.isRight() == true)
                stack.push(visiting.getRight());
              
        }

        System.out.println("Nothing left to traverse, node not found");
        return Optional.empty();

    }

    // -------------------------- Delete Implementations --------------------------
    /**
     * A removal algorithm with a known starting point.
     * calls breadthFirstSearch(value, root) to find the value to remove. But how do I remove? I think call constructor with new values to recreate tree. This will be time consuming with large n value.
     * @param value of type T, the value to remove.
     * @param root the starting point on the Tree to search.
     */

    public static <T> Optional<Tree<T>> remove(T value, Tree<T> root){
        
        if(root == null){
            System.out.println("Tree " + root.getValue() + "is empty");
            return Optional.empty();
        }
        
        Optional<Tree<T>> node = breadthFirstSearch(value, root); //find the node to remove.
        if (node == null){
            System.out.println("Node " + value + "not found");
            return Optional.empty();
        }

        
        return Optional.empty();
    }    

    // -------------------------- Insert Implementations --------------------------
    /**
     * An insert algorithm
     * Inserts at the first empty place in the tree, NOT designed for Search Trees (Ex: BST)
     * @param value of type T, the value to insert.
     * @param root the point on the Tree to insert at.
     */

    public static <T> Optional<Tree<T>> insert(T value, Tree<T> root){
        
        root.getClass();
        if(root == null){
            root = makeRoot(value);
            return Optional.of(root);
        }

        Queue<Tree<T>> queue = new LinkedList<Tree<T>>(); //create queue of nodes
        queue.add(root); //add root node to the queue.

        while(!queue.isEmpty()){
            root = queue.peek();
            queue.remove();

            if(root.isLeft() == false){
                root.addChild(value);
            }
        }

        return;
    }

}