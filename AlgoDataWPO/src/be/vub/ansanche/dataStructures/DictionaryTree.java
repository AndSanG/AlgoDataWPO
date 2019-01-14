package be.vub.ansanche.dataStructures;

public class DictionaryTree {
	
private Tree data;
	
	public DictionaryTree(){
		this.data = new Tree();
	}

	public void add(Comparable key,Object value){
		DictionaryPair pair = new DictionaryPair(key,value);
		data.insert(pair);
		
	}
	
	public Object find(Comparable key){
		DictionaryPair keyPair = new DictionaryPair(key);
		DictionaryPair pair = (DictionaryPair)data.find(keyPair);
		return pair.getValue();
	}
	
	public void print(){
		data.print();
	}
	
}
