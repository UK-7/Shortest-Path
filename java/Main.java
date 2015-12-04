package graphtest;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		/*
		 *  //25,000 nodes
		 *  //625,000 edges
		*/
		
		// // 250,000 nodes
		//double p_edge = 0.0001; // generate 6 million edges
		
		//int nodes = 250000;
		//double p_edge = 0.001;
		
		//int nodes = 30000;
		//double p_edge = 0.0001;
		//int nodes = 5;
		//double p_edge = .40;
		
		
		int nodes = 5;
		double p_edge = .4;
		
		AdjacencyList graph = new AdjacencyList(nodes, p_edge);
		
		int[][] iterativeBellman = new int[nodes][nodes];
		for(int i =0;i<nodes;i++){
			iterativeBellman[i] = Bellman.bellman(graph, i,0);
		}
		
		for(int[] row:iterativeBellman){
			for(int i:row){
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
		
		johnsons.johnsonNaive(graph);
		
		//int nodes = 10;
		//double p_edge =.2;

		/*
		for(int i = 0; i < 5000;i++){
			
			
			
			long startTime = System.nanoTime();
			int[] toPrint = Dijkstra.dijkstraFib(graph, 0,0);
			long endTime = System.nanoTime();
			long duration = (endTime - startTime) / 1000000;
			System.out.println("fib impl:");
			System.out.println(duration);
			
			
			//print results
			startTime = System.nanoTime();
			int[] secondPrint = Dijkstra.dijkstraHeap(graph, 0);
			endTime = System.nanoTime();
			duration = (endTime - startTime) / 1000000;
			System.out.println("heap impl:");
			System.out.println(duration);
	
			if (!Arrays.equals(toPrint, secondPrint)){
				System.out.println(i);
				break;
			}
		}
		*/
		
	
		
		
		
		/*
		//Testing floyd warshal
		
		int[][] hugeMatrix = graph.buildMatrix();
		

		int[][] result = floydWarshal.floydWarshalNaive(hugeMatrix.clone());	
		for(int[] row:result){
			for(int i:row){
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}

		System.out.println("\n\n\n");
		
		for(int i = 0;i<graph.size;i++){
			int[] toPrint = Bellman.bellman(graph, i);
			for(int j:toPrint){
				System.out.print(j);
				System.out.print(" ");
			}
			System.out.println("");
		}

		*/
		
		/*
		 // testing dijkstra and fib impl
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
		*/
	}

}
