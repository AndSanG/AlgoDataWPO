package be.vub.ansanche.dataStructures;

public class QueueLL {
private LinkedList data;
	
	public QueueLL() {
		data = new LinkedList();
	}
	public void push(Object object) {
		data.addFirst(object);
	}
	public Object pop() {
		Object object = data.getLast();
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
		System.out.println(data);
	}

}
