package graphtest;

///
/// Haven't used this yet...
///


public class connection {
	public Integer dest;
	public Integer weight;
	
	public connection(int idest,int iweight){
		dest = idest;
		weight = iweight;
	}
	
	public String toString() {
		return "dest" + dest.toString() + "weight" + weight.toString();
	}
}

