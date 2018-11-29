package be.vub.ansanche.dataStructures;

public class Queue {
	private Vector data;
	
	public Queue() {
		data = new Vector(50);
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
	
}
