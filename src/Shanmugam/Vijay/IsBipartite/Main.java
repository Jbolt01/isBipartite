package Shanmugam.Vijay.IsBipartite;

import Graph.UnweightedGraph;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;


public class Main {
    public static void main(String[] args) throws FileNotFoundException{
		System.out.print("Enter the name of the input file: ");
		Scanner in = new Scanner(System.in);
		String fileName = in.nextLine();
		
		File file = new File("inputs/" + fileName);
		Scanner reader = new Scanner(file);
		
		int vertices = Integer.parseInt(reader.nextLine());
		
		int[][] edges = new int[vertices][vertices];
		for (int v = 0; v < vertices; v++) {
			String line = reader.nextLine();
			String[] data = line.split("\\s+");
			
			int origin = Integer.parseInt(data[0]);
			
			for (int i = 1; i < data.length; i++) {
				int value = Integer.parseInt(data[i]);
				edges[origin][value] = 1;
			}
		}
		
		reader.close();
		
		UnweightedGraph<Integer> graph = new UnweightedGraph<Integer>(edges, vertices);
        System.out.print("Enter a starting vertex: ");
        int s = Integer.parseInt(in.nextLine());
        System.out.print("Enter an ending vertex: ");
        int e = Integer.parseInt(in.nextLine());
        boolean first = true;
        List<Integer> outputs = graph.bfs(s).getPath(e);
        Collections.reverse(outputs);
        for (int v: outputs) {
            if (first){
                System.out.print(v);
                first = false;
            } else {
                System.out.print("-" + v);
            }
        }
        System.out.println(" is the shortest path from " + s + " to " + e +".");

        Queue<Integer> bfs = new LinkedList<Integer>();
        Queue<Integer> bfsNum = new LinkedList<Integer>();
        Queue<Integer> bfsPrev = new LinkedList<Integer>();
        int[] parents = new int[vertices];
        int[] dist = new int[vertices];
        for (int i = 0; i < vertices; i++){
            parents[i] = -1;
            dist[i] = -1;
        }
        boolean flag = true;
        for (int j =0; j < vertices; j++){
            if (parents[j] != -1) continue;
            bfs.add(j);
            bfsNum.add(0);
            bfsPrev.add(j);
            if (!flag){
                break;
            }
            while (bfs.size() != 0){
                int cur = bfs.remove();
                int num = bfsNum.remove();
                int prev = bfsPrev.remove();
                if (parents[cur]==-1) {
                    parents[cur] = prev;
                    dist[cur] = num;
                    for (int i: graph.getNeighbors(cur)){
                        bfs.add(i);
                        bfsPrev.add(cur);
                        bfsNum.add(num+1);
                    }
                } else{
                    if(dist[cur] % 2 != num % 2){
                        System.out.println("The graph is not bipartite.");
                        flag = false;
                        break;
                    }
                }
            }
        }
        if (flag){
            System.out.println("The graph is bipartite.");
        }
	}
}