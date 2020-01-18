# Odd Cycle Detector

##Intro##
Java program which builds a graph, and detects if there exists an odd cycle.
A graph does not contain a cycle of odd length if and only if it is bipartite.
If a graph has an odd length cycle, then it cannot be bipartite. In bipartite graphs, there exist two sets of vertices, such that no vertex in a set is connected with any other vertex of the same set.

### Components
- **Driver.java** builds a graph of user choosing. Driver.java can be edited to build a custom graph, then detects if the graph has any odd cycles.
- **Node.java** consists of the class Node, which is what makes up each node of our graph. A node has its children (if any), its vertex, its childcount, and its State (see state.java). You can add a child, get a child, or get a vertex.
- **Graph.java** consists of the class graph. A graph has its vertex count, and its vertices. You can add a Node or get a Node.
- **State.java** is just an enum used by Node, BreadthFirst uses it to track which Nodes have been visited to detect for odd cycles. Each Node has its state, as a public global variable in the class.
- **BreadthFirst.java** is where we run our bread first search (bfs). The bfs takes a param of type Node in its only function (bfs), and scans all root nodes. It is best to use the root node of the graph to find odd cycles, although, you could detect odd cycles within a graph, if you so desire. by that, I mean, one could easily use a non-root node.

### More on Node.java & Graph.java
- A Node is the smallest, indivisable unit of a graph.
- A node has its vertex (value) and its children, if any.
- So, say we have Node A, with two children, B and C. Our graph would look something like this: <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;\ <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;C <br/>
- Therefore, Node A, has two children, in my representation of a Node, that would be represented as an array of Nodes: [B,C]. What if children looks like this: [B,C,D]? </br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;D <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\ <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;A <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;/&nbsp;\ <br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;B&nbsp;&nbsp;&nbsp;C <br/>
- Now, let's say Node B also has two children [E,F]. <br/>
                    D 
                     \
                      A
                     / \
                    B   C
                   / \
                  E   F
- Lastly, we can also establish that B also has a child in C. So, the children of B are [C,E,F]: <br/>
                    D 
                     \
                      A
                     / \
                    B---C
                   / \
                  E   F
- All of the above are represented as graphs. And much like the children, they can be represented as an array of Nodes, which is what I did in this implementation of a graph. The first dimension array represents the Node and the 2nd dimension array is each Nodes array of children. [A[B,C,D],B[C,E,F],C[],D[]]




### Coming soon:
- Depth First Search to find odd cycles.
- Remove node from graph
- Remove children from Node (might get funky, probably best accomplished in graph class, or at least with help from graph class).
- Other operations on graphs, graphs are cool, at which point I will change the name of this repo to better align with that. "graphsAreFun" perhaps

### Supplemental Reading:
FYI: Wikipedia is a great source of information, but I cannot stress enough the importance of using other sources for information due to wikipedias ease of editing.

1. Basic -> Advanced Discrete Mathematics: https://brilliant.org/wiki/discrete-mathematics/
2. Designing and Analyzing Algorithms: https://www.tutorialspoint.com/design_and_analysis_of_algorithms/index.htm
3. Graph Theory: https://en.wikipedia.org/wiki/Graph_theory
4. Vertex: https://en.wikipedia.org/wiki/Vertex_(graph_theory)
5. Cycle: http://mathworld.wolfram.com/GraphCycle.html
6. Tree: https://en.wikipedia.org/wiki/Tree_(data_structure)
7. Binary Tree: https://en.wikipedia.org/wiki/Binary_tree
8. General vs Binary Tree: https://www.geeksforgeeks.org/difference-between-general-tree-and-binary-tree/
9. Binary Search Tree (BST): https://en.wikipedia.org/wiki/Binary_search_tree
10. BST Operations: http://www.bo-yang.net/2014/05/26/binary-tree-traversal
11. Breadth First Search: https://en.wikipedia.org/wiki/Breadth-first_search
12. Depth First Search: https://en.wikipedia.org/wiki/Depth-first_search
13. Bidirectional Graph: https://en.wikipedia.org/wiki/Bidirected_graph
14. Undirected Graph: https://mathinsight.org/definition/undirected_graph
15. Directed Graph: https://en.wikipedia.org/wiki/Directed_graph

### Sources:
Taught me everything I know about Data structures & algorithms, their design & their analysis.
- Dr. Kevin McCullen, Associate Professor of computer science at SUNY College at Plattsburgh.
- Martin Mailloux, Assistant Professor of computer science at SUNY College at Plattsburgh.
- Dr. Delbert Hart, Associate Professor of computer science at SUNY College at Plattsburgh.
- Dr. Hung Ngo, Associate Professor of computer science at University at Buffalo.
- Dr Carl Alphonce, Associate Professor of computer science at University at Buffalo.
- The vastness of the interwebs