package be.vub.ansanche.dataStructures;

public class Graph
{
    public class Node implements Comparable
    {
        private Comparable info;
        private Vector edges;
        
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
        
    }
    
    private class Edge implements Comparable
    {
        private Node toNode;
        
        public Edge(Node to)
        {
            toNode = to;
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
                        Comparable nodeLabel2)
    {
        Node n1 = findNode(nodeLabel1);
        Node n2 = findNode(nodeLabel2);
        n1.addEdge(new Edge(n2));
    }
}