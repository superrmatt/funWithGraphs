# Fun With Graphs
## README Out of Date, Updates Coming Soon

## Table of Contents
1. [Introduction](https://github.com/superrmatt/oddCycleDetector#introduction)
2. [Theory](https://github.com/superrmatt/oddCycleDetector#theory)
    - [Unigraph](https://github.com/superrmatt/oddCycleDetector#unigraph)
    - [Digraph](https://github.com/superrmatt/oddCycleDetector#digraph)
    - [Tree](https://github.com/superrmatt/oddCycleDetector#tree)
    - [Cycles](https://github.com/superrmatt/oddCycleDetector#cycles)
3. [Source Folders](https://github.com/superrmatt/oddCycleDetector#source-folders)
    - [Tree](https://github.com/superrmatt/oddCycleDetector#tree-1)
    - [Graph](https://github.com/superrmatt/oddCycleDetector#graph)
4. [Components](https://github.com/superrmatt/oddCycleDetector#components)
5. [More on Node.java & Graph.java](https://github.com/superrmatt/oddCycleDetector#more-on-nodejava--graphjava)
6. [Coming Soon](https://github.com/superrmatt/oddCycleDetector#coming-soon)
7. [Cycle Graphs](https://github.com/superrmatt/oddCycleDetector#cycle-graphs)
8. [Supplemental Reading](https://github.com/superrmatt/oddCycleDetector#supplemental-reading)
9. [Sources](https://github.com/superrmatt/oddCycleDetector#sources)

## 

### Introduction
&nbsp;&nbsp;&nbsp;&nbsp;This a collection of Java classes, which deal in an implementation of graphs, and their algorithms. This is something that will be continually expanded upon, and therefore, is always a work in progress, until this statement is no longer here :). Graph theory is the study of graphs. Graphs are mathematical models used to represent the relations between two paired things. A graph is made up of vertices, and edges. A vertex is defined as the value in a node in the graph (see below for examples of the artistic representation of a graph). An edge is the connection between two nodes. Mathematically, a graph is represented as G = (V, E), where G is the graph, V is the set of vertices (or nodes), and E is the set of edges (or connections). There are two major types of graphs, a directed graph (digraph) and an undirected graph (unigraph). A unigraph has edges that have no direction. Meaning, an edge links two vertices equally or symetrically. A digraph has edges that link two nodes asymetrically. Meaning, one node "flows" into the other, this is often referred to as a parent->child relationship. A major form of digraph is the Tree (again, representations below). A tree is a form of graph that has a root and is nonlinear. It simulates a heirarchal tree structure, only upside down. Where the trunk or roots (root node) is at the top, and cascading downward are the branches. This of course is just a visual reprsentation, to make them simpler to conceptualize, there exists no directional orientation for a tree, other than the parent->child relationship between nodes.

### Theory
 #### Unigraph
 &nbsp;&nbsp;&nbsp;&nbsp;  Often simply referred to as graph, a unigraph is a graph whose edges have no direction. A graph is an ordered pair where G = (V,E). V is a set of vertices, and E is a set of edges connecting those vertices. An edge is associated with two distinct vertices.
 - Let's say we have the set V{A, B, C, D},
 - And the set E{(A,B), (B,C), (A,C) (A,D)}. 
 - Therefore, G = (V{A, B, C, D}, E{(A,B), (B,C), (A,C), (A,D)}).
 - Which could be represented as:
>                 D  
>                  \  
>                   A - B
>                    \ /
>                     C
- Let's now add the set V{E, F, G}.
- And the set E{(D,E), (B,F), (E,F), (A,F)}.
- Therefore, our graph is now: G = (V{A, B, C, D, E, F, G}, E{(A,B), (B,C), (A,C), (A,D), (D,E), (B,F), (E,F), (A,F)})
- Which can be represented as:
>                   E 
>                  / \
>                 D   F
>                  \ / \
>                   A - B
>                    \ /
>                     C

 #### Digraph
 &nbsp;&nbsp;&nbsp;&nbsp; Much like a unigraph, a digraph has edges with direction. Meaning they can only be traversed in one direction. Or, more simply, that one node points to another node, a one way street. Another way of saying this would be that a digraph has edges with orientation. Yet another way, is the one often referred to in practice with programming, a parent->child relationship. The parent->child relationship is the one I will use from this point on. These are much harder to build with a keyboard, we lack the characters. Instead, I will denote an arrow in the set of edges. The examples are the same as above, so should be straightforward.
 - Let's say we have the set V{A, B, C, D},
 - And the set E{(A->B), (B->C), (A->C) (A->D)}. In this case, direction matters. (A->B != A<-B).
 - Therefore, G = (V{A, B, C, D}, E{(A,B), (B,C), (A,C) (A,D)}). <br/>
 - Now, add the set V{E, F, G}.
 - And the set E{(D->E), (B->F), (E->F), (A->F)}.
 - Therefore, our graph is now: G = (V{A, B, C, D, E, F, G}, E{(A->B), (B->C), (A->C) (A->D), (D->E), (B->F), (E->F), (A->F)})<br/>
Again, can't really represent these with letter type. Same examples as above, but with arrows denoting direction from the parent node, to the child node.

 #### Cycles
 &nbsp;&nbsp;&nbsp;&nbsp; A cycle is straightforward. It is simply when a graph has a closed loop. This makes algorithms on them a little more challenging and time consuming than a cycleless graph (such as a tree). This is because, in order to not get trapped in the cycle in an endless loop, extra steps need to be taken. Those can be seen in the code for algorithms on graphs. A graph is said to have a cycle if some set of verticies are connected in a closed chain. For the following examples, direction, or lackthereof does not matter, but we will assume all graphs are unigraphs. 
 - In example one above, there exists one cycle.
 - With the graph G = ((V{A, B, C, D}, E{(A,B), (B,C), (A,C) (A,D)})):
>                 D  
>                  \  
>                   A - B
>                    \ /
>                     C
- There exists one cycle, which can be represented as the graph G = (V{A, B, C}, E{(A,B), (B,C), (A,C)})
>                   A - B
>                    \ /
>                     C
- In example two, there exist many cycles, to illustrate a few unique cycles:
    1. G = (V{A, D, E, F}, E{(A,D), (D,E), (E,F), (A,F)}).
    2. G = (V{A, B, C, F}, E{(A,B), (B,C), (A,C), (B,F)}).
    3. G = (V{A, B, C, D, E, F}, E{(B,C), (A,C), (A,D), (D,E), (B,F), (E,F)}).
- These can all be represented as follows:
>            i.     E       ii.     F       iii.     E
>                  / \             / \              / \
>                 D   F           A   B            D   F
>                  \ /             \ /              \   \
>                   A               C                A   B
>                                                     \ / 
>                                                      C


 #### Tree  


### Source Folders

 #### Tree

 #### Graph

### Components
- **Driver.java** builds a graph of user choosing. Driver.java can be edited to build a custom graph, then uses BreadthFirst.java to detect if the graph has any odd cycles.
- **Node.java** consists of the class Node, which is what makes up each node of our graph. A node has its children (if any), its vertex, its childcount, and its State (see State.java). You can add a child, get a child, or get a vertex.
- **Graph.java** consists of the class graph. A graph has its vertex count, and its vertices. You can add a Node or get a Node.
- **State.java** is just an enum used by Node, BreadthFirst uses it to track which Nodes have been visited to detect for odd cycles. Each Node has its state, as a public global variable in the class Node.
- **BreadthFirst.java** is where we run our breadth first search (bfs). The bfs takes a parameter of type Node in its only function (bfs), and scans all child nodes. It is best to use the root node of the graph to find odd cycles, although, you could detect odd cycles within a subgraph of the graph, if you so desire. By that, I mean, one could easily use a non-root node. If the graph is cyclic, any Node will suffice.

### More on Node.java & Graph.java
- A Node is the smallest, indivisable unit of a graph.
- A node has its vertex (value) and its children, if any.
- So, say we have Node A, with two children, B and C. This constitutes graph W. Our graph W would look something like this: <br/>
>                         A 
>                        / \ 
>                       B   C
- Therefore, Node A, has two children, in my implemention of a Node, that would be represented as an array of Nodes: [B,C]. What if children of Node A looks like this: [B,C,D]? THis would constitute graph X </br>
>                       D 
>                        \ 
>                         A 
>                        / \ 
>                       B   C
- Now, let's say Node B also has two children [E,F], making graph Y. <br/>
>                       D 
>                        \ 
>                         A 
>                        / \ 
>                       B   C
>                      / \
>                     E   F
- Lastly, we can also establish that B also has a child in C. So, the children of B are [C,E,F], making graph Z: <br/>
>                       D 
>                        \ 
>                         A 
>                        / \ 
>                       B − C
>                      / \
>                     E   F
- All of the above are represented as graphs. And much like the children, they can be represented as an array of Nodes, which is what I did in this implementation of a graph. The first dimension array represents the Node and the 2nd dimension array is each Nodes array of children. [A[B,C,D],B[C,E,F],C[],D[]]
- The final point to make here is, which graph has an odd cycle. None, because none of those examples are even cycle graphs to begin with. Those will be explained and explored in the next section.

### Cycle Graphs
**Coming Soon**




### Coming soon:
- Depth First Search to find odd cycles.
- Remove node from graph
- Remove children from Node (might get funky, probably best accomplished in graph class, or at least with help from graph class).
- Other operations on graphs, graphs are cool, at which point I will change the name of this repo to better align with that. "graphsAreFun" perhaps.

### Supplemental Reading:
FYI: Wikipedia is a great source of information, but I cannot stress enough the importance of using other sources for information due to wikipedias ease of editing.

1. Basic -> Advanced Discrete Mathematics: https://brilliant.org/wiki/discrete-mathematics/
2. Designing and Analyzing Algorithms: https://www.tutorialspoint.com/design_and_analysis_of_algorithms/index.htm
3. Konigsberg Bridge Problem: https://en.wikipedia.org/wiki/Seven_Bridges_of_K%C3%B6nigsberg
4. Graph Theory: https://en.wikipedia.org/wiki/Graph_theory
5. Vertex: https://en.wikipedia.org/wiki/Vertex_(graph_theory)
6. Cycle: http://mathworld.wolfram.com/GraphCycle.html
7. Tree: https://en.wikipedia.org/wiki/Tree_(data_structure)
8. Binary Tree: https://en.wikipedia.org/wiki/Binary_tree
9. General vs Binary Tree: https://www.geeksforgeeks.org/difference-between-general-tree-and-binary-tree/
10. Binary Search Tree (BST): https://en.wikipedia.org/wiki/Binary_search_tree
11. BST Operations: http://www.bo-yang.net/2014/05/26/binary-tree-traversal
12. Breadth First Search: https://en.wikipedia.org/wiki/Breadth-first_search
13. Depth First Search: https://en.wikipedia.org/wiki/Depth-first_search
14. Bidirectional Graph: https://en.wikipedia.org/wiki/Bidirected_graph
15. Undirected Graph: https://mathinsight.org/definition/undirected_graph
16. Directed Graph: https://en.wikipedia.org/wiki/Directed_graph
17. Glossary of Graph Theory (Definitions & Terms): https://en.wikipedia.org/wiki/Glossary_of_graph_theory_terms

### Sources:
Taught me everything I know about Data structures & algorithms, their design & their analysis.
- Dr. Kevin McCullen, Associate Professor of computer science at SUNY College at Plattsburgh.
- Martin Mailloux, Assistant Professor of computer science at SUNY College at Plattsburgh.
- Dr. Delbert Hart, Associate Professor of computer science at SUNY College at Plattsburgh.
- Dr. Hung Ngo, Associate Professor of computer science at University at Buffalo.
- Dr. Carl Alphonce, Associate Professor of computer science at University at Buffalo.
- The vastness, boundless, and endlessness vaults of the interwebs.