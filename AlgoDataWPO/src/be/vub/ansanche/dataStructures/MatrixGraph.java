/*******************************************************************************
 * '
 * MatrixGraph.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class represents a matrix based graph.
 * 
 ******************************************************************************/
package be.vub.ansanche.dataStructures;

public class MatrixGraph {
	
	private Matrix data;
	
	public MatrixGraph(int nodes) {
		data = new Matrix(nodes); 
	}
	
	public void addEdge(int from, int to, double w) {
		data.set(from, to, w); 
	}
	
	public double getEdge(int from, int to) {
		return (Double)data.get(from-1, to-1); 
	}
	
	public void print(){
		System.out.println(data.toString());
	}

	public String toString(){
		return data.toString();
	}
}
