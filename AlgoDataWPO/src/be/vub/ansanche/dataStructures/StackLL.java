/*******************************************************************************
 * '
 * StackLL.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class represents a linked list based stack
 * 
 ******************************************************************************/
package be.vub.ansanche.dataStructures;

public class StackLL {
	
private LinkedList data;
	
	public StackLL(){
		data = new LinkedList();
	}
	
	public void push(Comparable object) {
		data.addFirst(object);
	}
	
	public Comparable pop() {
		Comparable top = data.getFirst();
		data.removeFirst();
		return top;
	}
	
	public Comparable top() {
		return data.getFirst();
	}
	
	public int size() {
		return data.size();
	}
	
	public boolean isEmpty() {
		return data.isEmpty();
	}
	
	public void print() {
		data.print();
	}
	
	public String toString() {
		return data.toString();
	}

}
