package be.vub.ansanche.dataStructures;

public class Vector {
	// array to create vector and count to keep track of it 
	private Object data[];
	private int count;
	private int capacity;

	//Vector Constructor
	public Vector(int capacity)
	{
		data = new Object[capacity];
		count = 0;
		this.capacity = capacity;
	}

	/*
	 * Basic Operations  
	 */

	//get the size of the vector 
	public int size()
	{
		return count;
	}

	//check if the vector is empty or not 
	public boolean isEmpty()
	{
		return size() == 0;
	}

	//get the object at index
	public Object get(int index)
	{
		return data[index];
	}

	//overwriting an element in the vector 
	public void set(int index, Object object)
	{
		data[index] = object;
	}

	//Checking whether the vector contains a given element
	public boolean contains(Object object)
	{
		for(int i=0;i<count;i++)
		{
			if(data[i] == object) return true;
		}
		return false;
	}
	
	//add the element at the end of the vector.
	public void addLast(Object object)
	{
		if(capacity==count) {
			extendCapacity();
		}
		data[count] = object;
		count++;
	}
	
	//add the element at the begining of the vector.
	public void addFirst(Object item)
	{
		if(capacity==count) {
			extendCapacity();
		}
		for(int i = count ; i > 0 ; i--){
			data[i] = data[i-1];
		}
		data[0] = item;
		count ++;
	}

	//get the element at the beginning of the vector.
	public Object getFirst()
	{
		return data[0];
	}

	//get the element at the end of the vector.
	public Object getLast()
	{
		return data[count-1];
	}

	//remove the element at the end of the vector.
	public void removeLast()
	{
		for(int i = 0 ; i < count-1 ; i++){
			data[i] = data[i];
		}
		count --;	
	} 

	//remove the first element of the vector
	public void removeFirst()
	{
		for(int i = 0 ; i < count ; i++){
			data[i] = data[i+1];
		}
		count --;	
	}

	//reverse the order of the elements of the vector.
	public void reverse()
	{
		for(int i = 0 ; i < count/2 ; i++){
			Object aux = data[i];
			data[i] = data[count-1-i];
			data[count-1-i] = aux;
		}	
	}
	
	//duplicates the content of a vector element by element
	public Vector doubled(){
		Vector vectorDouble = new Vector(this.size()*2);
		for(int i = 0; i<this.size() ;i++){
			vectorDouble.addLast(this.get(i));
			vectorDouble.addLast(this.get(i));
		}
		return vectorDouble;
	}

	//interleave the content of a vector with the elements of the other vector
	public Vector interleave(Vector vector){
		Vector vectorInterleave = new Vector(this.size()*2);
		if(this.size()==vector.size()) {
			for(int i = 0; i<this.size() ;i++){
				vectorInterleave.addLast(this.get(i));
				vectorInterleave.addLast(vector.get(i));
			}
		}
		return vectorInterleave;
	}
	
	//extend the capacity of the vector to the double
	private void extendCapacity(){
		Object dataTemp[] = new Object[capacity*2];
		for(int i = 0; i<count ;i++){
			dataTemp[i] = data[i];
		}
		data = dataTemp;
		capacity *=2;
	}


	public void print(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		String string = " ";
		for(int i = 0; i<count ;i++){
			string += data[i];
			string += " ";
		}
		string += " ";
		return string;
	}
	

	/*
	 * Other Operations  

	public boolean binarySearch(Object key) {
		int start = 0;
		int end = count -1; while(start <= end) {
		int middle = (start + end + 1) / 2;
		if(key < data[middle]) end = middle -1;
		else if(key > data[middle]) start = middle + 1; else return true;
		}
		return false; }
	 */
}
