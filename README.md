# shortestPath() and isBipartite() Project
## Vijay Shanmugam

This program will read and interpret a file that represents a graph.  It will then check if that graph is bipartite and find the shortest path between two vertices. Finally, the program displays that information to the user.

### Input Files
Input text files must go into the folder Shanmugam.Vijay.IsBipartite/inputs.  They can be named anything since the user will tell the program what the name of the file is.

### Sample Tree Inputs
GraphVertices.txt:
```
7
0 1 2
1 0 3 6
2 0 3 4
3 1 2 4 5
4 2 3 5
5 3 4 6
6 1 5 
```
bipartite.txt:
```
9
0 5 6
1 5 7 8
2 5 6 
3 6 7 8
4 5
5 0 1 2 4
6 0 2 3
7 1 3 
8 1 3
```

### Compiling and Running
```
Shanmugam.Vijay.IsBipartite$ javac -d bin src/Graph/AbstractGraph.java src/Graph/Graph.java src/Graph/TestGraph.java src/Graph/UnweightedGraph.java src/Shanmugam/Vijay/IsBipartite/Main.java 

Shanmugam.Vijay.IsBipartite$ java -cp bin Shanmugam.Vijay.IsBipartite.Main
```

### Usage:
The program will prompt the user for a file name.  They should provide the name of the txt file they put in the folder Shanmugam.Vijay.IsBipartite/inputs.  It is important to include the .txt file extention.  The user will then select the starting and ending vertices that they want to find the shortest path between.

### Output
Program will output whether the selected Graph is bipartite and the shortest path between the selected vertices.

### Example Usage and Outputs:
```
Enter the name of the input file: GraphVertices.txt
Enter a starting vertex: 0
Enter an ending vertex: 4
0-2-4 is the shortest path from 0 to 4.
The graph is not bipartite.
```
```
Enter the name of the input file: bipartite.txt
Enter a starting vertex: 0
Enter an ending vertex: 4
0-5-4 is the shortest path from 0 to 4.
The graph is bipartite.
```