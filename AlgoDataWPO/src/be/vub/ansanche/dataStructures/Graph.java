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
			if(n.getLabel().equals( nodeLabel))
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
		if(n1!=null && n2!=null) n1.addEdge(new Edge(n2,weight));
	}
	
	public void shortestPath(Comparable source ){
		//1. topologically sort the vertices of G
		Stack stack = topologicalSorting(); 
		
		//2. Initialize single source  
		Dictionary dist = new Dictionary();
		Vector nodes = getNodes();
		for (int i = 0; i < nodes.size(); i++) {
			Node node = (Node)nodes.get(i);
			dist.add(node.getLabel(),100.00);
		}
		dist.add(source, 0.00);
		
		//3. for each vertex u , taken in topologically sorted order
		while (stack.isEmpty()==false) {
			Node uNode = (Node)stack.pop();

			//4. for each vertex v in its Adjacency list  G.Adj(u)
			Vector edges = uNode.getEdges();
			for (int i = 0; i < edges.size(); i++) {
				Edge vEdge = (Edge)edges.get(i);
				Comparable u = uNode.getLabel();
				Comparable v = vEdge.toNode.getLabel();
				double w = vEdge.weight;
	
				//5. Relax (u,v,w)
				if((double)dist.find(v)>(double)dist.find(u) + vEdge.weight) {
					dist.add(v, (double)dist.find(u) + vEdge.weight);
				}
			}
		}
		
		dist.print();//handle the response 

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
	
	public Stack topologicalSorting(){
		Stack stack = new Stack();
		depthFirstSearch(stack);
		return stack;
	}
	
	public void depthFirstSearch(Stack stack){
		setUpGraphNodesStatus(false);
		for (int i = 0; i < nodes.size(); i++) {
			Node current = (Node)nodes.get(i);
			if(!current.visited) depthFirstSearch(current,stack);
		}
	}
	
	private void depthFirstSearch(Node current,Stack stack){
		current.visited = true;
		for(int i=0;i<current.edges.size();i++) {
			Edge e = (Edge) current.edges.get(i);
			Node next = (Node)e.toNode;
			if(!next.visited) depthFirstSearch(next,stack);
		}
		//System.out.println(current.info); //DFS action
		stack.push(current);
		
	}
	
	private void setUpGraphNodesStatus(boolean status){
		for (int i = 0; i < nodes.size(); i++) {
			Node current = (Node) nodes.get(i);
			current.setVisited(status);
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