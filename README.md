# Fun With Graphs
## Under Construction

## Table of Contents
1. [Introduction](https://github.com/superrmatt/oddCycleDetector#introduction)
2. [Theory](https://github.com/superrmatt/oddCycleDetector#theory)
    - [Unigraph](https://github.com/superrmatt/oddCycleDetector#unigraph)
    - [Digraph](https://github.com/superrmatt/oddCycleDetector#digraph)
    - [Tree](https://github.com/superrmatt/oddCycleDetector#tree)
    - [Cycles](https://github.com/superrmatt/oddCycleDetector#cycles)
3. [Source Folders](https://github.com/superrmatt/oddCycleDetector#source-folders)
    - [Graph](https://github.com/superrmatt/oddCycleDetector#graph)
        - [GraphDriver.java](https://github.com/superrmatt/funWithGraphs#graphdriverjava)
        - [Node.java](https://github.com/superrmatt/funWithGraphs#nodedriverjava)
    - [Tree](https://github.com/superrmatt/oddCycleDetector#tree-1)
        - [TreeDriver.java](https://github.com/superrmatt/funWithGraphs#treedriverjava)
        - [Tree.java](https://github.com/superrmatt/funWithGraphs#treejava)
4. [Algorithms](https://github.com/superrmatt/oddCycleDetector#algorithms)
    - [Graph](https://github.com/superrmatt/funWithGraphs#graph-1)
        - [Breadth First Search](https://github.com/superrmatt/funWithGraphs#breadth-first-search)
    - [Tree](https://github.com/superrmatt/funWithGraphs#tree-2)
        - [Breadth First Search](https://github.com/superrmatt/funWithGraphs#breadth-first-search-1)
5. [Further Work](https://github.com/superrmatt/oddCycleDetector#further-work)
6. [Supplemental Reading](https://github.com/superrmatt/oddCycleDetector#supplemental-reading)
7. [Sources](https://github.com/superrmatt/oddCycleDetector#sources)

## 

### Introduction
&nbsp;&nbsp;&nbsp;&nbsp;This a collection of Java classes, which deal in an implementation of graphs, and their algorithms. This proejct is meant to be the journey of my study of graphs, their theory, their applications, and everything in between. This is something that will be continually expanded upon, and therefore, is always a work in progress. Graph theory is the study of graphs. Graphs are mathematical models used to represent the relations between two paired things. A graph is made up of vertices, and edges. A vertex is defined as the value in a node in the graph (see below for examples of the artistic representation of a graph). An edge is the connection between two nodes. Mathematically, a graph is represented as G = (V, E), where G is the graph, V is the set of vertices (or nodes), and E is the set of edges (or connections). There are two major types of graphs, undirected graphs (unigraphs) and directed graphs (digraphs). A unigraph has edges that have no direction. Meaning, an edge links two vertices equally or symetrically. A digraph has edges that link two nodes asymetrically. Meaning, one node "flows" into the other, this is often referred to as a parent->child relationship. A major form of digraph is the Tree (again, representations below). A tree is a form of graph that has a root and is nonlinear. It simulates a heirarchal tree structure, only upside down. Where the trunk or roots (root node) is at the top, and cascading downward are the branches. This of course is just a visual reprsentation, to make them simpler to conceptualize, there exists no directional orientation for a tree, other than the parent->child relationship between nodes.

### Theory
 #### Unigraph
 &nbsp;&nbsp;&nbsp;&nbsp;  Often simply referred to as a graph, a unigraph is a graph whose edges have no direction. A graph is an ordered pair where G = (V,E). V is a set of vertices, and E is a set of edges connecting those vertices. An edge is associated with two distinct vertices.
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
 &nbsp;&nbsp;&nbsp;&nbsp; Much like a unigraph, except a digraph has edges with direction. Meaning they can only be traversed in one direction. Or, more simply, that one node points to another node, a one way street. Another way of saying this would be that a digraph has edges with orientation. Yet another way, is the one often referred to in practice with programming, a parent->child relationship. The parent->child relationship is the one I will use from this point on. These are much harder to build with a keyboard, we lack the characters. Instead, I will denote an arrow in the set of edges. The examples are the same as above, so should be straightforward.
 - Let's say we have the set V{A, B, C, D},
 - And the set E{(A->B), (B->C), (A->C) (A->D)}. In this case, direction matters. (A->B != A<-B).
 - Therefore, G = (V{A, B, C, D}, E{(A,B), (B,C), (A,C) (A,D)}). <br/>
 - Now, add the set V{E, F, G}.
 - And the set E{(D->E), (B->F), (E->F), (A->F)}.
 - Therefore, our graph is now: G = (V{A, B, C, D, E, F, G}, E{(A->B), (B->C), (A->C) (A->D), (D->E), (B->F), (E->F), (A->F)})<br/>
Again, can't really represent these with letter type. Same examples as above, but with arrows denoting direction from the parent node, to the child node.

 #### Cycles
 &nbsp;&nbsp;&nbsp;&nbsp; A cycle is straightforward. It is simply when a graph has a closed loop. This makes algorithms on them a little more challenging and time consuming than a cycleless graph (such as a tree). This is because, in order to not get trapped in the cycle in an endless loop, extra steps need to be taken. Those can be seen in the code for algorithms on graphs. A graph is said to have a cycle if some set of verticies are connected in a closed chain. For the following examples, direction, or lackthereof does not matter, but we will assume all of the following examples are unigraphs. 
 - In the first above, with the graph G = (V{A, B, C, D}, E{(A,B), (B,C), (A,C) (A,D)}s):
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
&nbsp;&nbsp;&nbsp;&nbsp; Trees are a type of graph in which any two vertices are connected by exactly one edge. Trees, as a subset of graphs can get quite complicated in their formats. There exist many types of trees, there exist forests, there exist polytrees, and others. For now, I have only implemented code on a basic tree, and will only cover the basic form of a tree. <br/>
A tree is an undirected graph G that satisfies any of the following equivalent conditions:
- G is connected and acyclic (contains no cycles).
- G is acyclic, and a simple cycle is formed if any edge is added to G.
- G is connected, but would become disconnected if any single edge is removed from G.
- G is connected and the 3-vertex complete graph K3 is not a minor of G. (explanation of K3: https://en.wikipedia.org/wiki/Complete_graph)
- Any two vertices in G can be connected by a unique simple path.<br/><br/>
Since trees are graphs, and graphs consist of nodes, trees also consist of nodes. Trees also have children, and are therefore digraphs by design. A node in a tree has child node(s), and a parent node. A common form of a tree is a bianry tree, and more advanced, a binary search tree (BST), more on those as I implement them. For now, all trees will be binary for simplicity's sake, meaning each node cannot have more than two children, they will not necesarilly be BSTs though, if they are, it is pure accident!.
- Let's say we have the set V{A, B, C}, and the set E{(A->B), (A->C)}
- This constitutes graph G(V{A, B, C}, E{(A->B), (A->C)}).
- G would look like this:
>                         A 
>                        / \ 
>                       B   C
- Now, add the nodes D, E, F to set V. V{A, B, C, D, E, F}.
- And the edges (B->D), (B->E), (C->F).
- So, G = (V{A, B, C, D, E, F}, E{(A->B), (A->C), (B->D), (B->E), (C->F)})
- G would look like this:
>                         A 
>                        / \ 
>                       B   C
>                      / \   \
>                     D   E   F

### Source Folders

 #### Graph
  ##### GraphDriver.java
   - Simply a driver class. Contains a main function. A graph's structure is only limited to the imagination, the lack of directed edges, and existing memory.

  ##### Node.java
   - Node.java is the class for each node. A graph consists of at least two nodes. A Node holds a reference to its neighbors and its values. It contains accessor methods, constructors, and the algorithms.

 #### Tree
  ##### TreeDriver.java
   - Driver class for the tree structure. Builds a tree to according to the specified code and runs the requested algorithms.

  ##### Tree.java
   - Tree.java is the class for each tree node. Each instance of the class Tree is a node, it holds a reference to its children and its value. There are accessors, contructors, and algorithms.

### Algorithms

#### Graph
- ##### Breadth First Search 
    - Time complexity of a BFS on a graph will visit each node a most once. However, with this implementation, the methods addAll() and removeAll() are used, which have linear time complexity themselves. Consider n the number of nodes, and c the number of edges. Therefore, in the worst case, if the node does not exist, addAll() and removeAll() are called up to the number of edges, this would result in O(c) time complexity. As long as c > n, time complexity will be O(c), else O(n). Another representation would be O(n + c), which denotes the larger of the two.
        - With a set of traversable nodes Q and visited nodes T:
        - add root node to Q
            - While Q is not empty,
                - Remove a node from Q and store reference in temporary Node instance.
                -  If temporary Node matches the node in question, node found.
                - Else:
                    - Add visiting (temporary) Node to T.
                    - Add all neighbors of visiting node to Q.
                    - Remove all nodes from Q that are in T.
            - Node never found, Q is empty: all nodes traversed.

  #### Tree
- ##### Breadth First Search
    - Since BFS on a tree adds a node to the queue at most once, and each node is visited at most once, if n is the number of nodes in the structure, time complexity will be O(n). The fundamental difference between a graph and a tree, is that in a tree, the number of edges in a tree will never be greater than that of a graph, in fact, the number of edges in a tree will always be n - 1.
        - With a set of traversable nodes Q:
        - While Q is not empty,
            - Remove a node from the queue and store in temporary Tree instance.
            - If the temporary matches the node we are searching for, return that node.
            - Else: add all children of that node to the queue.
        - Node never found, Q is empty: all nodes traversed.

### Further Work:
- Depth First Search
- BSTs
- More work with trees
- Remove node from graph
- Remove node from Tree
- Digraphs
- With graphs, the possiblities are near endless.

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
17. Complete Graphs: https://en.wikipedia.org/wiki/Complete_graph
18. Glossary of Graph Theory (Definitions & Terms): https://en.wikipedia.org/wiki/Glossary_of_graph_theory_terms

### Sources:
Taught me everything I know about Data structures & algorithms, their design & their analysis.
- Dr. Kevin McCullen, Associate Professor of computer science at SUNY College at Plattsburgh.
- Martin Mailloux, Assistant Professor of computer science at SUNY College at Plattsburgh.
- Dr. Delbert Hart, Associate Professor of computer science at SUNY College at Plattsburgh.
- Dr. Hung Ngo, Associate Professor of computer science at University at Buffalo.
- Dr. Carl Alphonce, Associate Professor of computer science at University at Buffalo.
- The vastness, boundless, and endless vaults of the interwebs, including but not limited to the above links.