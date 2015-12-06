package graphtest;

import java.util.concurrent.ThreadLocalRandom;

public class StarGraphNode {
	Integer MAX_Integer = 10000;
	public Integer upWeight = MAX_Integer;
	public Integer downWeight = MAX_Integer;
	public Integer leftWeight = MAX_Integer;
	public Integer rightWeight = MAX_Integer;
	private Integer totalSize = 20;
	private Integer maxWeight = 50;
	private Integer minWeight = 1;
	public Integer x;
	public Integer y;
	// x ->
	// ^
 	// |
	// y
	public StarGraphNode(int x,int y,int totalSize){
		
		this.totalSize = totalSize;
		this.x = x;
		this.y = y;
		if(x == 0 && y == 0){
			//we're at root
			//right weight and down weight
			this.rightWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.downWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
		}else if(y == this.totalSize && x == this.totalSize){
			//left weight up weight
			this.leftWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.upWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
		}else if(x == 0){
			//left weight, right weight, down weight
			this.leftWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.rightWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.downWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
		}else if(x == this.totalSize){
			// left weight down weight up weight
			this.upWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.leftWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.downWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
		}else if(y == this.totalSize){
			//left weight right weight up weight
			this.upWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.rightWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.leftWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
		}else if(y == 0){
		  //left weight right weight, down weight
			this.leftWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.rightWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.downWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
		}else{
			this.leftWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.rightWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.downWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			this.upWeight = ThreadLocalRandom.current().nextInt(minWeight,maxWeight);
			
		}
		
	}
	public String toString(){
		String returnMe = "";
		returnMe = returnMe + "("+ this.x.toString() + " " + this.y.toString() + ")";
		returnMe = returnMe + this.upWeight.toString()+" " + this.downWeight.toString() + " " +
		this.leftWeight.toString() + " "+ this.rightWeight.toString();
		return returnMe;
	}
}

