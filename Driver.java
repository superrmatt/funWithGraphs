/**
 * Driver class
 * Contains one method, which builds a new graph
 * Learn more about what a graph is here: https://en.wikipedia.org/wiki/Graph_(abstract_data_type)
 * THe graph here is predetermined, a keen mind could see how this could be manipulated
 * to create whatever graph we want.
 * For this use, our graph exists as a tree. particulalry, a binary search tree (bst)
 * @author: superrmatt 
 */
public class Driver {

    /**
     * Creates a new, hardcoded graph for proof of concept.
     * Can be altered to create whatever kind of graph we want.
     * @return: g of type Graph, the graph we just built.
     */
	public static Graph createNewGraph(){
		Graph g = new Graph();
		Node[] temp = new Node[8];
		
		temp[0] = new Node("A", 3);
		temp[1] = new Node("B", 3);
		temp[2] = new Node("C", 1);
        temp[3] = new Node("D", 1);
        temp[4] = new Node("E", 1);
        temp[5] = new Node("F", 1);
        
        temp[0].addChildNode(temp[1]);
        temp[0].addChildNode(temp[2]);
        temp[0].addChildNode(temp[3]);

        temp[1].addChildNode(temp[0]);
        temp[1].addChildNode(temp[4]);
        temp[1].addChildNode(temp[5]);

        temp[2].addChildNode(temp[0]);
        temp[3].addChildNode(temp[0]);
        temp[4].addChildNode(temp[1]);
        temp[5].addChildNode(temp[1]);
        
        for (int i = 0; i < 7; i++){
            g.addNode(temp[i]);
        }
        return g;
	}
    
    /**
     * main, creates new instance of the graph class.
     * Once created we can test our breadthfirst search function.
     * @arg: array of strings, no args needed here.
     */
	public static void main(String[] args){
		Graph gBFS = createNewGraph();
		BreadthFirst BFS = new BreadthFirst();
		
		BFS.bfs(gBFS.getNode()[0]);
	}
}
