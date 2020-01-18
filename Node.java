import code.State;

/**
 * Node Node Node.
 * Class Node is used to build our graph, which in this case is a tree.
 * Question is, is it a BST? run the driver to find out!
 */
public class Node {

    /**
     * Array of Nodes. All children to this node.
     * For example, with the following node 1:
     *             1
     *            / \
     *           2   3
     * child looks like: [2,3]
     * Further, with the following node 1:
     *             4
     *              \
     *               1
     *              / \
     *             2   3
     * child looks like: [2,3,4]
     */
	public Node[] child;
    public int childCount;
    private String vertex;
    public State state;

    public Node(String vertex){
        this.vertex = vertex;
    }

    public Node(String vertex, int childlen){
        this.vertex = vertex;
        childCount = 0;
        child = new Node[childlen];
    }

    public void addChildNode(Node adj){
        adj.state = State.Unvisited;
        if(childCount < 30)
        {
            this.child[childCount] = adj;
            childCount++;
        }
    }

    public Node[] getChild(){
        return child;
    }

    public String getVertex(){
        return vertex;
    }

}

