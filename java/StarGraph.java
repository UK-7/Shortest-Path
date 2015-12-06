package graphtest;

public class StarGraph {
	public StarGraphNode[][] graph;
	
	public StarGraph(int n){
		this.graph = new StarGraphNode[n][n];
		for(int i = 0; i <n;i++){
			for(int j = 0; j<n;j++){
				graph[i][j] = new StarGraphNode(i,j,n-1);
			}
		}
	}
	public void printGraph(){
		for(StarGraphNode[] asdf:this.graph){
			for(StarGraphNode i:asdf){
				System.out.println(i.toString());
			}
		}
	}
}
