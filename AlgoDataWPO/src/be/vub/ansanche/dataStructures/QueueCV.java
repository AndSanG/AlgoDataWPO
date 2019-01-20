/*******************************************************************************
 * '
 * QueueCV.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class represents a circular vector based queue
 * 
 ******************************************************************************/
package be.vub.ansanche.dataStructures;

public class QueueCV {

	private CircularVector data;
	
	public QueueCV() {
		data = new CircularVector(50);
	}
	public void push(Object object) {
		data.addLast(object);
	}
	public Object pop() {
		Object object = data.getFirst();
		data.removeFirst();
		return object;
	}
	public Object top() {
		return data.getLast();
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
