package graphtest;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		/*
		 * int nodes = 25000; //25,000 nodes
		 * double p_edge = 0.001; //625,000 edges
		*/
		
		int nodes = 250000; // 250,000 nodes
		double p_edge = 0.0001; // generate 6 million edges
		
		AdjacencyList graph = new AdjacencyList(nodes, p_edge);
		
		//run dijkstra with source of 1200 on our graph
		long startTime = System.nanoTime();
		int[] toPrint = Dijkstra.dijkstraFib(graph, 1200);
		long endTime = System.nanoTime();
		long duration = (endTime - startTime) / 1000000;
		System.out.println("Fib Impl:");
		System.out.println(duration);
		//print results
		startTime = System.nanoTime();
		int[] secondPrint = Bellman.bellman(graph, 1200);
		endTime = System.nanoTime();
		duration = (endTime - startTime) / 1000000;
		System.out.println("Standard Impl");
		System.out.println(duration);
		
		System.out.println(Arrays.equals(toPrint, secondPrint));		
	}

}
