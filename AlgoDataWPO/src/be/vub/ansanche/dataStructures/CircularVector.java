package be.vub.ansanche.dataStructures;

public class CircularVector 
{
	private Object data[];
	private int first;
	private int count;
	
	public CircularVector(int capacity)
	{
		count = 0;
		first = 0;
		data = new Object[capacity];
	}

	public int size()
	{
		return count;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}
	
	
	public Object get(int index)
	{
		index = (count + index)%data.length;
		return data[index];
	}

	public void set(int index, Object object)
	{
		index = (count + index)%data.length;
		data[index] = object;
	}

	public boolean contains(Object object)
	{
		boolean contains = false;
		for(int i=0;i<count;i++)
		{
			int index = (first + i) % data.length;
			if(data[index] == object) contains = true; 
		}
		
		return contains;
	}
	

	// Adding element at the front
	public void addFirst(Object element)
	{
		if (this.isEmpty()) {
			
			data[0] = element;
			
		}else {
		
			first = (first + data.length - 1)%data.length;
			data[first] = element;
			
		}
		count++;
	}

	// Adding element at the end
	public void addLast(Object element)
	{
		if (this.isEmpty()) {
			
			data[0] = element;
			
		}else {
		
			int index = (first + count)%data.length;
			data[index] = element;
			
		}
		
		count++;
	}
	//
	public Object getFirst()
	{
		return data[first];
	}
	//
	public Object getLast()
	{
		
		return data[(first+count-1)%data.length];
	}
	// Removing element at the beginning 
	public void removeFirst()
	{
		if(!isEmpty())
		{
			first = (first+1)%data.length;
			count--;
		}
	}
	// Removing element at the end
	public void removeLast()
	{
		count--;
	}
	
	
	////
	
	public int getFirstIndex() {
		return first;
	}
	public int getLastIndex() {
		return (first+count)%data.length;
	}
	public void print()
	{
		System.out.print("[");
		for(int i=0;i<count;i++)
		{
			int index = (first + i) % data.length;
			System.out.print(data[index] + " ");
		}
		System.out.println("]");
	}
	
}
