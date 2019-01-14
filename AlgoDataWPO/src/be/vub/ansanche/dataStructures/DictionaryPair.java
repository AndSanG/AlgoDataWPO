package be.vub.ansanche.dataStructures;


public class DictionaryPair implements Comparable{
	
	private Comparable key;
	private Object value;
	
	public DictionaryPair(Comparable key, Object value) {
		super();
		this.key = key;
		this.value = value;
	}
	
	public DictionaryPair(Comparable key) {
		this(key,null);
	}
		
	
	public int compareTo(Object object) {
		DictionaryPair pair = (DictionaryPair) object;
		return ((Comparable)key).compareTo(pair.key);
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
		String string = this.key + " : " + this.value ; 
		return string;
	}

}
