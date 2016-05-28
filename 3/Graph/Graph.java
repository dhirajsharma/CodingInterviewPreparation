import java.util.*;
class Graph{

	HashMap<String, ArrayList<Vertex>> connections = new HashMap<String, ArrayList<Vertex>>();
	ArrayList<String> vertexNodes = new ArrayList<String>();
	int adjacencyMatrix[][];
	int distance[];
	Set<Integer> settled = new HashSet<Integer>();
	Set<Integer> unsettled = new HashSet<Integer>();

	Set connectionSet = connections.entrySet();
	Iterator connectionIterator = connectionSet.iterator();
		
	public void addGraph(String fromVertex, String toVertex, int cost){
		Vertex vertex = new Vertex(fromVertex, toVertex, cost);
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		if ((connections.isEmpty())) {
			vertices.add(vertex);
			connections.put(fromVertex, vertices);
			addNode(fromVertex, toVertex);
		}else if (connections.get(fromVertex) != null) {
			vertices = connections.get(fromVertex);
			vertices.add(vertex);
			connections.put(fromVertex, vertices);
			addNode(fromVertex, toVertex);
		}else{
			vertices.add(vertex);
			connections.put(fromVertex, vertices);
			addNode(fromVertex, toVertex);
		}
	}

	private void addNode(String fromVertex, String toVertex){
		if (!vertexNodes.contains(fromVertex)){
			vertexNodes.add(fromVertex);
		}
		if (!vertexNodes.contains(toVertex)) {
			vertexNodes.add(toVertex);	
		}
		adjacencyMatrix = new int[vertexNodes.size()+1][vertexNodes.size()+1];
		updateAdjacency();
	}

	private void updateAdjacency(){
		for (int i = 0; i<vertexNodes.size(); i++) {
			for (int j = 0; j<vertexNodes.size(); j++) {
				if (i==j) {
					adjacencyMatrix[i][j] = Integer.MAX_VALUE;
					//continue;
				}else{
					String fromVertex = vertexNodes.get(i);
					ArrayList<Vertex> verticesValuesList = (ArrayList<Vertex>)connections.get(fromVertex);
					String toVertex = (String)vertexNodes.get(j);
					int cost = 0;
					if (verticesValuesList != null) {
						for (Vertex str : verticesValuesList){
							if(str.toVertex.equals(toVertex)){
								cost = str.cost;
								break; 
							}
						}	
					}
					adjacencyMatrix[i][j] = cost;
				}
			}
		}
	}

	public void showAdjacencyMatrix(){
		for(int i=0; i<vertexNodes.size(); i++){
			for (int j=0; j<vertexNodes.size(); j++) {
				System.out.print(adjacencyMatrix[i][j]+"\t");
			}
			System.out.println();
		}
	}

	public void showVertexNodes(){
		for(String nodes : vertexNodes){
			System.out.println(nodes);
		}
	}

	public void showGraph(){
		while(connectionIterator.hasNext()){
			Map.Entry mapConnetions = (Map.Entry)connectionIterator.next();			
			String fromVertex = (String)mapConnetions.getKey();
			ArrayList<Vertex> verticesObjects = new ArrayList<Vertex>();			
			verticesObjects = (ArrayList<Vertex>)mapConnetions.getValue();
			System.out.println(fromVertex+ "\n " + verticesObjects.toString());
			System.out.println("--------------------------------------------------------------------------------------------------");
		}
	}

	private void dijkstraAlgo(int source){
		distance = new int[vertexNodes.size()];
		int evaluationNode;
		/*for(int i = 0; i < vertexNodes.size()-1; i++){
			for (int j=0; j< vertexNodes.size()-1;j++) {
				adjacencyMatrix[i][j] = adjacencyMatrix[i][j];
			}
		}*/
		for (int i = 0; i < vertexNodes.size()-1; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		unsettled.add(source);
		distance[source] = 0;
		while(!unsettled.isEmpty()){
			evaluationNode = getMinDistance();
			unsettled.remove(evaluationNode);
			settled.add(evaluationNode);
			checkNeighbours(evaluationNode);
		}
	}

	private int getMinDistance(){
		int min, node = 0;
		Iterator<Integer> iterator = unsettled.iterator();
		node = iterator.next();
		min = distance[node];
		for (int i = 0; i<distance.length; i++) {
			if(unsettled.contains(i)){
				if (distance[i] <= min) {
					min = distance[i];
					node = i;
				}
			}
		}
		return node;
	}

	private void checkNeighbours(int evaluationNode){
		int edgeDistance = -1;
		int newDistance = -1;

		for (int destinationNode = 0; destinationNode < vertexNodes.size(); destinationNode++) {
			if (!settled.contains(destinationNode)) {
				if (adjacencyMatrix[evaluationNode][destinationNode] != Integer.MAX_VALUE) {
					edgeDistance = adjacencyMatrix[evaluationNode][destinationNode];
					newDistance = distance[evaluationNode] + edgeDistance;
					if (newDistance < distance[destinationNode]) {
						distance[destinationNode] = newDistance;
					}
					unsettled.add(destinationNode);
				}
			}
		}
	}

	public void getPath(String fromVertex, String toVertex){
		if (vertexNodes.size() > 0 && vertexNodes.contains(fromVertex) && vertexNodes.contains(toVertex)) {
			int source = vertexNodes.indexOf(fromVertex);
			int destination = vertexNodes.indexOf(toVertex);
			System.out.println(source+"---"+destination);
			dijkstraAlgo(source);
			for (int i=0; i < distance.length; i++) {
				System.out.println(distance[i]);
				if (i == destination) {
					System.out.println(fromVertex+" --> "+toVertex+" : "+ distance[i]);
				}
			}
		}else if (vertexNodes.contains(fromVertex)) {
			System.out.println("Source is not present");
		}else if (vertexNodes.contains(toVertex)) {
			System.out.println("Destination is not present");
		}else if(connections.size() == 0){
			System.out.println("Connecion Set is Empty"+connections.size());
		}
		/*else{
			System.out.println("Source is not present");
		}*/
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.addGraph("Mumbai", "New Delhi", 1);
		graph.addGraph("New Delhi","Dallas",4);
/*		graph.addGraph("New Delhi", "San Jose", 9);
		graph.addGraph("New Delhi", "New Jersey", 5);
		graph.addGraph("New York", "New Delhi", 2);
		graph.addGraph("Chicago", "New Jersey", 1);
		graph.addGraph("San Fransisco", "Frankfurt", 7);
		graph.addGraph("New Jersey", "Frankfurt", 3);
		graph.addGraph("New Jersey", "San Fransisco", 5);
		graph.addGraph("Houston", "New York", 3);
		graph.addGraph("Houston", "San Jose", 2);
		graph.addGraph("San Fransisco", "Munich", 4);
		graph.addGraph("San Jose", "Amsterdam", 5);
		graph.addGraph("Frankfurt", "Amsterdam", 1);
		graph.addGraph("Frankfurt", "Cape Town", 3);
		graph.addGraph("Amsterdam", "Cape Town", 5);
		graph.addGraph("Munich", "Cape Town", 3);
		graph.addGraph("Munich", "Dubai", 2);
		graph.addGraph("Dubai", "Cape Town", 3);
		graph.addGraph("Cape Town", "Mauritius", 2);*/

		//graph.showGraph();
		graph.showAdjacencyMatrix();
		System.out.println();
		graph.showVertexNodes();
		graph.getPath("New Delhi","Dallas");
		//graph.getPath("New Zealand","Cape Town");

	}
}

class Vertex{
	String fromVertex;
	String toVertex;
	int cost;

	Vertex(String fromVertex, String toVertex, int cost){
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.cost = cost;
	}

	public String toString(){
		return fromVertex+" --> "+toVertex+" : "+cost+"\n ";
	}
}