package be.vub.ansanche.dataStructures;

public class Graph
{
	public class Node implements Comparable
	{
		private Comparable info;
		private Vector edges;
		private boolean visited;

		public Node(Comparable label)
		{
			info = label;
			edges = new Vector(10);
		}

		public void addEdge(Edge e)
		{
			edges.addLast(e);
		}

		public int compareTo(Object o)
		{
			// two nodes are equal if they have the same label
			Node n = (Node)o;
			return n.info.compareTo(info);
		}

		public Comparable getLabel()
		{
			return info;
		}

		public Vector getEdges() {
			return edges;
		}
		
		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public String toString(){
			return info.toString();
		}

	}

	private class Edge implements Comparable
	{
		private Node toNode;
		private double weight;

		public Edge(Node to, double weight)
		{
			toNode = to;
			this.weight = weight;
		}

		public int compareTo(Object o)
		{
			// two edges are equal if they point
			// to the same node.
			// this assumes that the edges are
			// starting from the same node !!!
			Edge n = (Edge)o;
			return n.toNode.compareTo(toNode);
		}

		public String toString(){
			return '[' + toNode.toString()+ " " + this.weight + ']';
		}
	}

	private Vector nodes;

	public Graph()
	{
		nodes = new Vector(10);
	}

	public void addNode(Comparable label)
	{
		nodes.addLast(new Node(label));
	}

	private Node findNode(Comparable nodeLabel)
	{
		Node res = null;
		for (int i=0; i<nodes.size(); i++)
		{
			Node n = (Node)nodes.get(i);
			if(n.getLabel() == nodeLabel)
			{
				res = n;
				break;
			}
		}
		return res;
	}

	public void addEdge(Comparable nodeLabel1,
			Comparable nodeLabel2,double weight)
	{
		Node n1 = findNode(nodeLabel1);
		Node n2 = findNode(nodeLabel2);
		n1.addEdge(new Edge(n2,weight));
	}

	public Vector findPath(Comparable nodeLabel1 , Comparable nodeLabel2)
	{
		Node startState = findNode(nodeLabel1); 
		Node endState = findNode(nodeLabel2); 
		Stack toDoList = new Stack (); 
		Vector path = new Vector(10);
		
		//set visited in all nodes to false.
		setUpGraphNodesStatus(false);
		
		toDoList.push(startState); 
		
		while(!toDoList.isEmpty()){
			Node current = (Node)toDoList.pop();
			current.visited = true;
			path.addLast(current);
			//System.out.println("current= " + current);
			
			if (current == endState) 
				return path; 
			else{
				for (int i=0; i<current.edges.size(); i++) {
					Edge e = (Edge)current.edges.get(i);
					if(!e.toNode.isVisited()) {
						//System.out.println("push= " + i + " : " + e.toNode);
						toDoList.push(e.toNode); 
					}
				}
			} 
		}

		return path; 
	}
	
	private void setUpGraphNodesStatus(boolean status){
		for (int i = 0; i < nodes.size(); i++) {
			Node current = (Node) nodes.get(i);
			current.setVisited(status);
		}
	}
	
	private void depthFirstSearch(Node current){
		current.visited = true;
		for(int i=0;i<current.edges.size();i++) {
			Edge e = (Edge) current.edges.get(i);
			Node next = (Node)e.toNode;
			if(!next.visited) depthFirstSearch(next);
		}
		System.out.println(current.info);
	}
	public void depthFirstSearch(){
		setUpGraphNodesStatus(false);
		for (int i = 0; i < nodes.size(); i++) {
			Node current = (Node)nodes.get(i);
			if(!current.visited) depthFirstSearch(current);
		}
	}
	
	public Vector getNodes() {
		return nodes;
	}

	public void print(){
		System.out.println(this.toString());
	}

	public String toString(){
		String result = "";
		for (int i=0; i<nodes.size(); i++)
		{
			Node n = (Node)nodes.get(i);

			result += n.getLabel().toString() +" : "+ n.getEdges().toString()+'\n';

		}
		return result;
	}
}