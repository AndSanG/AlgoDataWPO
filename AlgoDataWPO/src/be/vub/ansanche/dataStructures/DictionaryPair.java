package be.vub.ansanche.dataStructures;

public class DictionaryPair{
	
	private Comparable key;
	private Object value;
	
	public DictionaryPair(Comparable key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}

	public Comparable getKey() {
		return key;
	}

	public void setKey(Comparable key) {
		this.key = key;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	public void print(){
		System.out.println(this.toString());
	}
	
	public String toString(){
		String string = this.key + " : " + this.value + '\n'; 
		return string;
	}
	
}
