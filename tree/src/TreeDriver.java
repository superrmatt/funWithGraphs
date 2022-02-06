/**
 * Driver Class. Used to run program and use to have fun with Trees & graphs
 */
public class TreeDriver{

  /**
     * main
     * @param args arguments
     */
    public static void main(String[] args){

        //create our sample tree via Tree<T> class. <T> in this case is <String>
        Tree<String> A = Tree.makeRoot("A");
        Tree<String> B = A.addChild("B");
        Tree<String> C = A.addChild("C");
        Tree<String> D = B.addChild("D");
        Tree<String> E = B.addChild("E");
        Tree<String> F = C.addChild("F");
        Tree<String> G = C.addChild("G");
        Tree<String> H = D.addChild("H");
        Tree<String> I = D.addChild("I");
        Tree<String> J = E.addChild("J");
        Tree<String> K = E.addChild("K");
        Tree<String> L = F.addChild("L");
        Tree<String> M = F.addChild("M");
        Tree<String> N = G.addChild("N");
        Tree<String> O = G.addChild("O");

        //call the search algos
        Tree.breadthFirstSearch("O", A);
        Tree.preOrderRecursive("O", A);
        Tree.preOrderIterative("O", A);

        System.out.println("----------------Testing Insert----------------");
        //call the insert algo
        A.insert("P", A);
        //test it worked.
        Tree.breadthFirstSearch("P", A);

        System.out.println("----------------Testing Remove----------------");
        //call the remove algo
        A.remove("P", A);
        //test it worked
        Tree.breadthFirstSearch("P", A);
      }
}