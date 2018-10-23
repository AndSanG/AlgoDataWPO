package be.vub.ansanche.dataStructures;

public class StackLL {
	
private LinkedList data;
	
	public StackLL(){
		data = new LinkedList();
	}
	
	public void push(Object object) {
		data.addFirst(object);
	}
	
	public Object pop() {
		Object top = data.getFirst();
		data.removeFirst();
		return top;
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
		System.out.println(data);
	}

}
