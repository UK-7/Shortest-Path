package graphtest;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		/*
		 *  //25,000 nodes
		 *  //625,000 edges
		*/
		
		ArrayList<ArrayList<Long>> floyd = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> johnson = new ArrayList<ArrayList<Long>>();
		long startTime;
		long endTime;
		long duration;
		
		//int nodes = 2000;
		
		
		for(int i = 0;i<25;i++){
			AdjacencyList graph = new AdjacencyList(5000,.1);
			System.out.println("test");
		}
		
		//4,000 to 400,000 thousand edges by
		
		// try absolutely fixing edges
		//double p_edge = .1;
		
		double p_edge = .001;
		for(int nodes = 5; nodes < 4000;nodes = nodes + 1000){
			System.out.println(p_edge);
			ArrayList<Long> floydIterations = new ArrayList<Long>();
			ArrayList<Long> johnsonIterations = new ArrayList<Long>();
			for(int rep = 0; rep < 5; rep++){
				AdjacencyList graph = new AdjacencyList(nodes, p_edge);
				int[][] graphMat = graph.buildMatrix();
				System.out.println(rep);
				startTime = System.nanoTime();
				int[][] test1 = FloydWarshal.floydWarshalNaive(graphMat);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				floydIterations.add(duration);
				//System.out.println("floyd done");
				
				startTime = System.nanoTime();
				int[][] test3 = Johnsons.johnsonNaive(graph,graphMat);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				johnsonIterations.add(duration);
			}
			johnson.add(johnsonIterations);
			floyd.add(floydIterations);	
		}
		
		
		//write results to file
		try {
			PrintWriter writer = new PrintWriter("/Users/jgiesler/Desktop/exp6bjohnson_results.csv","UTF-8");
			for(ArrayList<Long> arr:johnson){
				writer.println(arr.toString().replace("[", "").replace("]", "")
			            .replace(", ", ","));
			}
			writer.close();
			
			writer = new PrintWriter("/Users/jgiesler/Desktop/exp6bfloyd_results.csv","UTF-8");
			for(ArrayList<Long> arr:floyd){
				writer.println(arr.toString().replace("[", "").replace("]", "")
			            .replace(", ", ","));
			}
			writer.close();

			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * Old Test Cases
		 * -Building a random graph
		 * -Turning random graph into matrix
		 * -Testing Johnson and Floyd
		 * -Testing Dijkstra/bellman -all implementations get same results
		 * -Tested Negative Cycles
		 * 
		 * -Tested all algorithms on pen/paper
		 */

		
		//int nodes = 250000;
		//double p_edge = 0.0001;
		
		//int nodes = 30000;
		//double p_edge = 0.01;
		
		//int nodes = 5;
		//double p_edge = .3;
		//AdjacencyList graph = new AdjacencyList(nodes,p_edge)
		//for(int i:graph.graph.keySet()){
		//	System.out.println(graph.graph.get(i));
		//int[][] graphMat = graph.buildMatrix();
		//for(int[] row:graphMat){
		//	for(int i:row){
		//		System.out.print(i);
		//		System.out.print(" ");
		//	}
		//	System.out.println("");
		//}
		
		/*
		 * Negative Cycles and values
		 * set weightMin to -5 or something
		 */
		//AdjacencyList newGraph = AdjacencyList(nodes,p_edge,weightMin,weightMax)
		
		/*
		 * Testing Johnsons
		 * 
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
		
		int[][] result = johnsons.johnsonNaive(graph);
		
		for(int[] row: result){
			for(int i:row){
				System.out.print(i);
				System.out.print(" ");
			}
			System.out.println("");
		}
		*/
		//int nodes = 10;
		//double p_edge =.2;

		/*

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
		
		
		
		/*
		 * Example of using timing functions
		ArrayList<ArrayList<Long>> floyd = new ArrayList<ArrayList<Long>>();
		ArrayList<ArrayList<Long>> johnson = new ArrayList<ArrayList<Long>>();
		long startTime;
		long endTime;
		long duration;
		
		int nodes = 2000;
		
		
		for(int i = 0;i<25;i++){
			AdjacencyList graph = new AdjacencyList(2000,.01);
			System.out.println("test");
		}
		
		//4,000 to 400,000 thousand edges by
		for(double p_edge = .0005 ; p_edge < .01;p_edge = p_edge + .0005){
			System.out.println(p_edge);
			ArrayList<Long> floydIterations = new ArrayList<Long>();
			ArrayList<Long> johnsonIterations = new ArrayList<Long>();
			for(int rep = 0; rep < 5; rep++){
				AdjacencyList graph = new AdjacencyList(nodes, p_edge);
				int[][] graphMat = graph.buildMatrix();
				System.out.println(rep);
				startTime = System.nanoTime();
				int[][] test1 = floydWarshal.floydWarshalNaive(graphMat);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				floydIterations.add(duration);
				//System.out.println("floyd done");
				
				startTime = System.nanoTime();
				int[][] test3 = johnsons.johnsonNaive(graph,graphMat);
				endTime = System.nanoTime();
				duration = (endTime - startTime) / 1000000;
				johnsonIterations.add(duration);
			}
			johnson.add(johnsonIterations);
			floyd.add(floydIterations);	
		}
		 */
	}

}
