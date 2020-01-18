/**
 * @author: superrmatt
 */

import java.util.*;

/**
 * BreadthFirst search class
 */
public class BreadthFirst {

	/**
	 * bfs...Breadth First Search. Learn more here: https://en.wikipedia.org/wiki/Breadth-first_search
	 * Here, we are looking for odd cycles. Learn more here: https://www.geeksforgeeks.org/check-graphs-cycle-odd-length/
	 * @param type Node: the root of our graph
	 */
	public void bfs(Node root){
		Queue<Node> que = new LinkedList<Node>();
		
		if(root == null){
			return;
		}
		
		root.state = State.Visited;
		que.add(root);
		
		int i = 0;
		while(!que.isEmpty()){
			Node r = que.remove();
			i = i + 1;
			System.out.print(i);
			
			for(Node n: r.getChild()){
				if(n.state == State.Unvisited){
					que.add(n);
					n.state = State.Visited;
				}
			}
		}
	}
}
