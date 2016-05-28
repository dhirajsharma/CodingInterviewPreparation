public class Dijkstra {
	public static void computePaths(Vertex source){
		source.minDistance = 0;
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		vertexQueue.add(source);
	}
}

class Edge{
	public final Vertex target;
	public final double weight;
	public Edge(Vertex argTarget, double argWeight){
		target = argTarget;
		weight = argWeight;
	}
}

class Vertex implements Comparable<Vertex>{
	public final String name;
	public Edge[] adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public Vertex previous;
	
	public Vertex (String argName){
		name = argName;
	}

	public String toString(){
		return name;
	}

	public int CompareTo(Vertex other){
		return Double.compare(minDistance, other.minDistance);
	}
}