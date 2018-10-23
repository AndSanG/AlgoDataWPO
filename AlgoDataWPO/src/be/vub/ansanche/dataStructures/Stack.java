package be.vub.ansanche.dataStructures;

public class Stack {
	private Vector data;
	
	public Stack(){
		data = new Vector(50);
	}
	
	public void push(Object object) {
		data.addLast(object);
	}
	
	public Object pop() {
		Object top = data.getLast();
		data.removeLast();
		return top;
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
	

}


