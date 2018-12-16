package be.vub.ansanche.dataStructures;

public class Dictionary 
{
	private Vector data;
	
	public Dictionary(){
		this.data = new Vector(100);
	}

	public void add(Comparable key,Object value){
		int index = findPosition(key);
		DictionaryPair pair = new DictionaryPair(key,value);
		if(index<0) {
			data.addLast(pair);
		}else{
			data.set(index, pair);
		}
		
	}
	
	public int findPosition(Comparable key){
		int index = -1;
		
		for (int i = 0; i < data.size(); i++) {
			DictionaryPair pair =(DictionaryPair) data.get(i);
			if(key==pair.getKey()){
				index = i;
			}
		}
		
		return index;
	}
	public Object find(Comparable key){
		Object object = new Object();
		object = null;
		int index = findPosition(key);
		if(index>0) {
			object = data.get(index);
		}
		return object;
	}
	
	public void print(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		String string = " ";
		for(int i = 0; i<this.data.size() ;i++){
			string += data.get(i);
			string += " ";
		}
		string += " ";
		return string;
	}
}
