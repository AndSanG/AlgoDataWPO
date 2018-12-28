package be.vub.ansanche.dataStructures;

public class Matrix {
	
	// some appropriate private members.
	private int nodes;
	private Vector data;
	
	public Matrix(int nodes) {
		
		// allocate an N-by-N matrix where N = nodes
		// all elements are initially 0
		data = new Vector(nodes);
		this.nodes = nodes;
		
		for (int i = 0; i < nodes; i++) {
			Vector row = new Vector(nodes);
			for (int j = 0; j < nodes; j++) {
				row.addLast((double) 0);
			}
			data.addLast(row);
		} 
	}
	
	public void set(int row, int col, Comparable weight) {
		// store the weight at the given row and column.
		Vector rowVector = (Vector) data.get(row);
		rowVector.set(col, weight);
	}
	
	public Comparable get(int row, int col) {
		Vector rowVector = (Vector) data.get(row);
		return (Comparable) rowVector.get(col);
	} 
	
	public void print(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		String string = "";
		for (int i = 0; i < nodes; i++) {
			Vector rowVector = (Vector) data.get(i);
			string += rowVector.toString() + '\n';
		}
		return string;
	}
}
