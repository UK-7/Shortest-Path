package graphtest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dijkstra {
	
	//this is the least efficient way to implement dijkstra and should only 
	//really server as a method of visualizing what is going on with adjacency
	//list interactions
	public static int[] dijkstra(AdjacencyList graph, int source){

		
		int n_nodes = graph.size;
		int MAX_INT = 10000;
		
		int[] dist = new int[n_nodes];
		int[] prev = new int[n_nodes];
		int[] q = new int[n_nodes];
		
		//default initializations
		Arrays.fill(prev, -1);
		Arrays.fill(dist, MAX_INT);
		Arrays.fill(q, 1);
		dist[source] = 0;
		
		// this is where fib heap will be great. need decrease priority function
		int x = sumArray(q);
		while(x != 0){
			if(x%10000 == 0){
				System.out.println(x);
			}
			//loop until every node has been called as minimum index
			int u = minIdx(dist,q);
			//get lowest index
			q[u] = 0;
			HashMap<Integer,Integer> neighbors = graph.getNeighbors(u);
			
			for(int v:neighbors.keySet()){
				//look through neighbors. don't bother if it has been in q
				if(q[v] == 1){
					//find alternative path
					int alt = dist[u] + neighbors.get(v);
					if(alt < dist[v]){
						//alternative path is a better option
						dist[v] = alt;
						prev[v] = u;
					}
				}
			}
			x = sumArray(q);
		}
		return dist;	
	}
	
	public static int[] dijkstraFib(AdjacencyList graph,int source){
		// init a Fib Heap
		FibonacciHeap<Integer> fibHeap = new FibonacciHeap<Integer>();
		
		// standard initialization
		int n_nodes = graph.size;
		int MAX_INT = 10000;
		int[] dist = new int[n_nodes];
		int[] prev = new int[n_nodes];
		int[] q = new int[n_nodes];
		//default initializations
		Arrays.fill(prev, -1);
		Arrays.fill(dist, MAX_INT);
		Arrays.fill(q, 1);
		dist[source] = 0;
		
		
		// This hashtable allows us to find a neighbor node in constant time. 
		Map<Integer,FibonacciHeap.Entry<Integer>> entries = new HashMap<Integer,FibonacciHeap.Entry<Integer>>();
		
		for(int i = 0; i < n_nodes;i++){
			//for each node enqueue it with a large weight. keep pointers to node so we can
			//quickly find them in the heap for decrease priority
			entries.put(i, fibHeap.enqueue(i, (double)dist[i]));
		}
		
		while(fibHeap.size() > 0){
			//get minimum value and distance
			int nextNode = fibHeap.dequeueMin().getValue();
			int distU = dist[nextNode];
			
			//get neighbors to the node
			HashMap<Integer,Integer>neighbors = graph.getNeighbors(nextNode);	
			for(int neighbor:neighbors.keySet()){
				
				//standard dijkstra
				int alt = distU + neighbors.get(neighbor);
				if(alt < dist[neighbor]){
					dist[neighbor] = alt;
					prev[neighbor] = nextNode;
					
					//use our hashmap to find the correct part of the heap and decrement the neighbor
					//this is soooooooo much better than how we had to do it in python
					fibHeap.decreaseKey(entries.get(neighbor), alt);
				}
			}
		}
		return dist;
	}
	
	
	//helper functions - SOO INEFFICIENT
	//these functions are the reason why this version of dijkstra isn't used
	public static int sumArray(int[] arr){
		int sum = 0;
		for(int i = 0;i<arr.length;i++){
			sum+= arr[i];
		}
		return sum;
	}
	public static int minIdx(int[] dist,int[] q){
		int lowVal = 10000;
		int lowIdx = 0;
		for(int i =0;i<dist.length;i++){
			if(dist[i]<lowVal && q[i] == 1){
				lowVal = dist[i];
				lowIdx = i;
			}
		}
		return lowIdx;
	}
}
