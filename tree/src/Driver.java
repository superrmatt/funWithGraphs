/**
 * Driver Class. used to run program and use to have fun with Trees & graphs
 */
public class Driver{
    
    /**
     * main
     * @param args arguments
     */
    public static void main(String[] args){

        /**create our sample tree via Tree<T> class, <T> is <Integer>
         * looks like:
         *         10
         *        /  \
         *       2    4
         *      /
         *     3
         */
        Tree<Integer> root = Tree.makeRoot(10);
        Tree<Integer> rootFirstChild = root.addChild(2);
        Tree<Integer> depthMostChild = rootFirstChild.addChild(3);
        Tree<Integer> rootSecondChild = root.addChild(4);
        
        Tree.breadthFirstSearch(4, root);
    }
}