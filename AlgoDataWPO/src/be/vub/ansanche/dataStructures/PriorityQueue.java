package be.vub.ansanche.dataStructures;
import java.util.Comparator;

import be.vub.ansanche.Utilities;

public class PriorityQueue 
{       
	public class PriorityPair implements Comparable
	{
		public Object element;
		public Object priority;
		
		public PriorityPair(Object element, Object priority) {
			this.element = element;
			this.priority = priority;
		}
		
		public int compareTo(Object object)
		{
			PriorityPair pair2 = (PriorityPair)object;
			return ((Comparable)priority).compareTo(pair2.priority);
		}
		
		public String toString() {
			String string = element.toString() + " : " + priority.toString();
			return string;
		}
	}

	private LinkedList data;

	public PriorityQueue()
	{
		data = new LinkedList();
	}

	public void push(Object object, int priority)
	{
		// make a pair of o and priority
		PriorityPair pair1 = new PriorityPair(object, priority);
		// add this pair to the sorted linked list.
		data.addSorted(pair1); 
		
	}

	public Object pop()
	{
		Object top = data.getFirst();
		data.removeFirst();
		return top;
	}

	public Object top()
	{
		return data.getFirst();
	}
	
	//unsorted
	
	public void pushUnsorted(Object object, int priority) {
		// make a pair of o and priority
		PriorityPair pair1 = new PriorityPair(object, priority);
		// add this pair to the unsorted linked list.
		data.addFirst(pair1); 
	}
	
	/*public Object popUnsorted()
	{
		Object top = ListElement
		data.removeFirst();
		return top;
	}

	public Object topUnsorted()
	{
		return data.getHighPriorityPair();
	}
	*/
	
	public void print() {
		for (int i = 0; i < data.size(); i++) {
			PriorityPair pair =  (PriorityPair) data.get(i);
			String message = pair.element.toString() + pair.priority.toString();
			Utilities.println(pair);
		}
	}
}