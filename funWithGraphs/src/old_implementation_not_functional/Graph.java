/**
 * Graph class, the actual data structure.
 * In memory, it is stored as an array of Nodes.
 * Node is a type which can be found in Node.java.
 */
public class Graph {

		/**
		 * vertex count as type int
		 */
		public int _vertexCount;
		
		/**
		 * array of type Node, vertices
		 */
	    private Node _vertices[];
		
		/**
		 * Constructor! favorite class, always.
		 * Contructs new instance of type Graph.
		 * For now hardcoded as 8 for POC.
		 */
	    public Graph(){
	    	_vertices = new Node[8];
	    	_vertexCount = 0;
	    }
		
		/**
		 * You guessed it, adds a node to our graph
		 * @param type Node, the Node to add.
		 */
	    public void addNode(Node n){
	    	_vertices[_vertexCount] = n;
	    	_vertexCount ++;
	    }
		
		/**
		 * accessor: get the nodes!
		 * @return array of type Node, _vertices.
		 */
	    public Node[] getNode(){
	    	return _vertices;
	    }
}


