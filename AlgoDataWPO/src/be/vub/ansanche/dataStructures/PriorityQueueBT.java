package be.vub.ansanche.dataStructures;

import be.vub.ansanche.dataStructures.PriorityQueue.PriorityPair;

public class PriorityQueueBT {
	
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
	
	private Tree data;
	
	public PriorityQueueBT()
	{
		data = new Tree();
	}

	/*
	 * Priority Queue as sorted Linked List :Push complex Pop simple 
	 * Add elements at the right position and pop the highest priority
	 */
	public void push(Object object, int priority)
	{
		// make a pair of o and priority
		PriorityPair pair1 = new PriorityPair(object, priority);
		// add this pair to the sorted linked list.
		data.insert(pair1);
	}

	public Object pop()
	{
		Object top = data.biggest();
		//data.removeFirst();
		return top;
	}

	public Object top()
	{
		return data.biggest();
	}
	
	public void print() {
		data.print();
	}
	
	public String toString() {
		return data.toString();
	}

}
