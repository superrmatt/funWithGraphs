
/**
 * Driver, testing grounds. Fun with graphs below!
 */
public class GraphDriver{
    /**
     * main
     * @param args array of strings, arguments, if needed.
     */
    public static void main(String[] args){
        
        /**
         * Create a sample graph via Node<T>, in this case Node<String>.
         * Looks like:
         *                  D  
         *                   \  
         *                    A - B
         *                     \ /
         *                      C
         */
        
        //First nodeA.value = 10. nodeB.value = 2.
        Node<String> nodeA = new Node<>("C");
        Node<String> nodeB = new Node<>("B");
        //Connect nodeA & nodeB.
        nodeA.connect(nodeB);
 
        //nodeC.value = 3.
        Node<String> nodeC = new Node<>("C");
        //Connect nodeB to nodeC. connect nodeC to nodeA.
        nodeB.connect(nodeC);
        nodeC.connect(nodeA);
 
        Node<String> nodeD = new Node<>("D");
        nodeA.connect(nodeD);

        Node.breadthFirstSearch("B", nodeD);
    }
}