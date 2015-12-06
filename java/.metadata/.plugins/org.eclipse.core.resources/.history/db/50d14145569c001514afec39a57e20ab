package implement;

import search.A_star;
import data.Graph;
import data.Graph.node;

public class Execute {
	///can I save it yes
	/*
	 * generate a map of x*y with possibility of an 
	 * edge = connectivity (actual edges upon total possible)
	 * 0 < connectivity <= 1.0
	 */
	private Graph generateMap(int x, int y, double connectivity) {
		Graph G = new Graph(x,y);
		int edgeCount = (int) ((2*x*y -x -y)*connectivity);
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++)
				G.Map[i][j] = G.new node();
		}
		for (int i = 0; i < edgeCount; i++) {
			int a = (int) (Math.random() * x);
			System.out.println(a);
			int b = (int) (Math.random() * y);
			System.out.println(b);
			int wt = (int) (Math.random() * 50 + 1);
			System.out.println(wt);
			int dir = (int) (Math.random() * 4);
			System.out.println(dir);
			while(!G.addEdge(a,b,dir,wt)){
				a = (int) (Math.random() * x);
				b = (int) (Math.random() * y);
				wt = (int) (Math.random() * 50 + 1);
				dir = (int) (Math.random() * 4);
			}
		}
		
		return G;
	}
	
	public static void main(String args[]) {
		Execute E = new Execute();
		Graph G = E.generateMap(100, 100, 0.8);

		A_star A = new A_star();
		A.setGraph(G);
		A.setTarget(87, 62);
		System.out.println(A.astar(0, 0));
		printGraph(G);
	}

	private static void printGraph(Graph G) {
		int rows = G.Map.length;
        int columns = G.Map[0].length;
        String str = "|\t";

        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                str += G.Map[i][j].cost + "\t";
            }

            System.out.println(str + "|");
            str = "|\t";
        }
	}
}
