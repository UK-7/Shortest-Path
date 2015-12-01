package graphtest;


public class Main {
	public static void main(String[] args) {
		//int nodes = 250000; // 250,000 nodes
		//double p_edge = 0.0001; // generate 6 million edges
		
		int nodes = 25000; //25,000 nodes
		double p_edge = 0.001; //625,000 edges
		
		AdjacencyList graph = new AdjacencyList(nodes, p_edge);
		
		//run dijkstra with source of 1200 on our graph
		int[] toPrint = Dijkstra.dijkstra(graph, 1200);
		//print results
		int[] secondPrint = Bellman.bellman(graph, 1200);
		for(int i = 0;i<toPrint.length;i++){
			System.out.println(toPrint[i]);
			System.out.println(secondPrint[i]);
		}
		
	}

}
