package implement;

import search.A_star;
import data.Graph;

public class Execute {
	///can I save it yes
	/*
	 * generate a map of x*y with possibility of an 
	 * edge = connectivity (actual edges upon total possible)
	 * 0 < connectivity <= 1.0
	 */
	private Graph generateMap(int x, int y, double connectivity) {
		Graph G = new Graph(x,y);
		int edgeCount = (int) (((2*x*y) - (x + y))*connectivity);
		
		for(int i = 0; i < x; i++) {
			for(int j = 0; j < y; j++)
				G.Map[i][j] = G.new node();
		}
		
		for (int i = 0; i < 2*edgeCount; i++) {
			int a = (int) (Math.random() * x);
			int b = (int) (Math.random() * y);
			int wt = (int) (Math.random() * 50 + 1);
			int dir = (int) (Math.random() * 4);
			boolean add = G.addEdge(a,b,dir,wt);
			
			while(!add) {
				a = (int) (Math.random() * x);
				b = (int) (Math.random() * y);
				wt = (int) (Math.random() * 50 + 1);
				dir = (int) (Math.random() * 4);
				add = G.addEdge(a,b,dir,wt); 
			}
			
			System.out.println(a + ", " + b + ": " + dir +  " ->" + wt);
		}
		
		System.out.println(edgeCount);
		//System.out.println(G.Map[0][0].edge[0] + " " + G.Map[0][0].edge[1] + " " + G.Map[0][0].edge[2] + " " +G.Map[0][0].edge[3]);
		
		return G;
	}
	
	public static void main(String args[]) {
		Execute E = new Execute();
		Graph G = E.generateMap(50, 50, 1.0);

		A_star A = new A_star();
		A.setGraph(G);
		A.setTarget(43, 19);
		System.out.println(A.astar(0, 0));
		//printGraph(G);
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
