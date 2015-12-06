//Jai Sai Ram//
package search;
import java.util.PriorityQueue;

import data.*;
import data.Graph.node;


public class A_star {
	
	Graph G;
	node target;
	
	//Expected by the execution method
	public void setGraph(Graph G) {
		this.G = G;
	}
	
	public void setTarget(int x, int y) {
		target = G.Map[x][y];
	}
	
	/*
	 * A* search algorithm that takes as input
	 * x and y variable of the start node in
	 * the Graph structure 'Graph'
	 */
	public int astar(int X, int Y) {
		node start = G.Map[X][Y];
		int currentCost = 0;
		PriorityQueue<node> Q = new PriorityQueue<node>();
		Q.add(start);
		start.curCost = 0;
		node current = start;
		while(Q.size() != 0) {
			System.out.println(Q.size());
			current = Q.poll();
			if (current.equals(target))
				return target.cost;
			
			for(int i = 0; i < 4; i++) {
				node neighbour = neighbour(current, i);
				if (neighbour != null && current.edge[i] != 2147483647){
				//System.out.println(neighbour);
				System.out.println(currentCost+current.edge[i]);
				System.out.println(neighbour.curCost);
				if(currentCost + current.edge[i] < neighbour.curCost) {
					neighbour.curCost = currentCost + current.edge[i];
					neighbour.cost = neighbour.curCost + heuristic(neighbour.x, neighbour.y);
					
					}
				Q.add(neighbour);
				}
				
			}
			}
		return -1;
	}
	
	/*
	 * i = 0 -> Top
	 * i = 1 -> Left
	 * i = 2 -> Right
	 * i = 3 -> Down
	 */
	private node neighbour(node current, int i) {
		if(i == 0) {
			if(target.y-1 < 0)
				return null;
			return G.Map[target.x][target.y - 1];
		}
		
		else if (i == 1) {
			if(target.x - 1< 0)
				return null;
			return G.Map[target.x - 1][target.y];
		}
		
		else if (i == 2) {
			if(target.x + 1 >= G.Map.length)
				return null;
			return G.Map[target.x + 1][target.y];
		}
		else {
			if(target.y + 1 >= G.Map.length)
				return null;
			return G.Map[target.x][target.y + 1];
		}
	}

	private int heuristic(int x, int y) {
		//Manhattan distance between current and target
		return (target.x - x) + (target.y - y);
	}
}
