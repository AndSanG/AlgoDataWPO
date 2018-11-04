package be.vub.ansanche.dataStructures;

public class Vector {
	private Object data[];
	private int count;
	
	public Vector(int capacity)
	{
		data = new Object[capacity];
		count = 0;
	}

	public int size()
	{
		return count;
	}
 
	public boolean isEmpty()
	{
		return size() == 0;
	}

	public Object get(int index)
	{
		return data[index];
	}

	public void set(int index, Object object)
	{
		data[index] = object;
	}

	public boolean contains(Object object)
	{
		for(int i=0;i<count;i++)
		{
			if(data[i] == object) return true;
		}
		return false;
	}
	
	public void addFirst(Object item)
	{
		// add your code
		for(int i = count ; i > 0 ; i--){
			data[i] = data[i-1];
		}
		data[0] = item;
		count ++;
	}

	public void addLast(Object object)
	{
		data[count] = object;
		count++;
	}
	
	/*
	public boolean binarySearch(Object key)
	{
	int start = 0;
	int end = count - 1;
	while(start <= end)
	{
		int middle = (start + end + 1) / 2;
		if(key < data[middle]) end = middle -1;
		else if(key > data[middle]) start = middle + 1;
		else return true;
	}
	return false;
	}
	*/

	public Object getFirst()
	{
		// add your code
		return data[0];
	}

	public Object getLast()
	{
		// add your code
		return data[count-1];
	}

	public void removeLast()
	{
		// add your code
		for(int i = 0 ; i < count-1 ; i++){
			data[i] = data[i];
		}
		count --;	
	} 

	public void removeFirst()
	{
		// add your code
		for(int i = 0 ; i < count ; i++){
			data[i] = data[i+1];
		}
		count --;	
	}
	
	public void reverse()
	{
		// add your code
		for(int i = 0 ; i < count/2 ; i++){
			Object aux = data[i];
			data[i] = data[count-1-i];
			data[count-1-i] = aux;
		}	
	}
	public Object duplicate(Vector vector){
		Vector vectorDuplicated = new Vector(vector.size()*2);
		for(int i = 0; i<count ;i++){
			vectorDuplicated.addLast(vector.get(i));
			vectorDuplicated.addLast(vector.get(i+1));
		}
		return vectorDuplicated;
	}

	
	public void print(){
		for(int i = 0; i<count ;i++){
			System.out.print(data[i] + " ");
		}
		System.out.println(" ");
	}
}
