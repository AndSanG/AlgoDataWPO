/*******************************************************************************
 * '
 * QueueLL.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class represents a linked list based queue
 * 
 ******************************************************************************/
package be.vub.ansanche.dataStructures;

public class QueueLL {
private LinkedList data;
	
	public QueueLL() {
		data = new LinkedList();
	}
	public void push(Comparable object) {
		data.addFirst(object);
	}
	public Comparable pop() {
		Comparable object = data.getLast();
		data.removeLast();
		return object;
	}
	public Object top() {
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
