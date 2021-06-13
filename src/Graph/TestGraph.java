package Graph;

import java.util.*;
import java.io.*;

public class TestGraph {

	static final String fileName = "GraphVertices.txt";
	
	public static void main(String[] args) throws FileNotFoundException{
		System.out.print("Enter the name of the input file");
		Scanner in = new Scanner(System.in);
		String fileName = in.nextLine();
		
		
		File file = new File(fileName);
		Scanner reader = new Scanner(file);
		
		//load number of vertices
		int vertices = Integer.parseInt(reader.nextLine());
		
		//load edges
		int[][] edges = new int[vertices][vertices];
		for (int v = 0; v < vertices; v++) {
			String line = reader.nextLine();
			//separate into whitespace, splitting by whitespace
			String[] data = line.split("\\s+");
			
			//first value on each line is supposed to be the origin of the edge
			int origin = Integer.parseInt(data[0]);
			
			//run through all but the first value (since it was supposed to be the origin value)
			for (int i = 1; i < data.length; i++) {
				int value = Integer.parseInt(data[i]);
				edges[origin][value] = 1;
			}
		}
		
		reader.close();
		
		//generate graph
		 UnweightedGraph<Integer> graph = new UnweightedGraph<Integer>(edges, vertices);			
			/*
			 * Connected graph detection algorithm:
			 * 	Run DFS from any vertex.
			 * 	The graph is connected iff all vertices have been visited.
			 */
			AbstractGraph.Tree dfsTree = graph.dfs(0);
			System.out.println(dfsTree.getNumberOfVerticesFound());
			
	}
}