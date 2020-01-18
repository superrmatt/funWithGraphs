import State.java;

/**
 * @author: superrmatt
 */

import java.util.*;

/**
 * BreadthFirst search class
 */
public class BreadthFirst {

	//int parent[] = new int[];

	/**
	 * bfs...Breadth First Search. Learn more here: https://en.wikipedia.org/wiki/Breadth-first_search
	 * Here, we are looking for odd cycles. Learn more here: https://www.geeksforgeeks.org/check-graphs-cycle-odd-length/
	 * @param type Node: the root of our graph
	 * @return true if graph is even cycle, false if odd cycle.
	 */
	public boolean bfs(Node root){
		Queue<Node> que = new LinkedList<Node>();
		
		if(root == null){
			System.out.println("graphs of size 0 have no cycles");
			return false;
		}
		
		//first node starts visited
		root.state = State.Visited;
		que.add(root);

		//iterate queue
		while(!que.isEmpty()){
			System.out.println("while---------------------");
			Node r = que.remove();
			System.out.println("r = " + r.getVertex());

			for(Node n: r.getChild()){

				System.out.println("for---------------------");
				System.out.print("childNode = " + n.getVertex());

				if(n.state == State.Unvisited){
					System.out.println(" is unvisited");
					que.add(n);
					n.state = State.Visited;
				}else if(n.state == State.Visited /*&& n.getVertex() != "A"/* && n is parent of r*/){
					//if a node has been visisted, and is the parent of n it is odd cycle
					System.out.println(" visited");
					System.out.println("Graph is odd cycle");
					return false;
				}
			}
		}

		//queue empty == all nodes removed == all nodes visited once and only once == even cycle.
		System.out.println("true, even cycle");
		return true;
	}
}
