package be.vub.ansanche.dataStructures;
import java.util.Comparator;

public class PriorityQueue 
{   
	/*
	 * Priority Pair groups the data and the priority of the elements to be added
	 */
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

	/*
	 * Priority Queue as sorted Linked List :Push complex Pop simple 
	 * Add elements at the right position and pop the highest priority
	 */
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
	
	/*
	 * Priority Queue as unsorted Linked List : Push simple Pop complex 
	 * Add elements as it comes and then search for the highest priority
	 */
	
	public void pushUnsorted(Object object, int priority) {
		// make a pair of o and priority
		PriorityPair pair1 = new PriorityPair(object, priority);
		// add this pair to the unsorted linked list.
		data.addFirst(pair1); 
	}
	
	public Comparable popUnsorted()
	{
		Comparable top = data.getHighPriorityPair();
		//data.removeObject(top);
		return top;
	}
	
	public Object topUnsorted()
	{
		return data.getHighPriorityPair();
	}
	
	
	public void print() {
		System.out.println(this.toString());
	}
	
	public String toString() {
		String string = "";
		for (int i = 0; i < data.size(); i++) {
			PriorityPair pair =  (PriorityPair) data.get(i);
			string += pair.toString();
			string += '\n';
		}
		return string;
	}
}