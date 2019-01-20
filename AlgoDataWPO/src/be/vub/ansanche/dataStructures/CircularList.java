/*******************************************************************************
 * '
 * CircularList.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class represent a circular list
 * 
 ******************************************************************************/
package be.vub.ansanche.dataStructures;
import java.util.Comparator;

public class CircularList {
	
	private class ListElement {
		private Comparable el1;
		private ListElement el2;

		public ListElement(Comparable el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Comparable el) {
			this(el, null);
		}

		public Comparable first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		public void setFirst(Comparable value) {
			el1 = value;
		}

		public void setRest(ListElement value) {
			el2 = value;
		}
	}
	
	private ListElement head;
	private ListElement tail;
	
	//-----
	
	public CircularList() {
		head = null;
		tail = head;
	}
	
	public int size() {
		ListElement d = head;
		int size = 0;
		if(!this.isEmpty()) {
			size = 1;
			while (d != tail) {
				d = d.rest();
				size++;
			}
		}
		
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}

	public Comparable get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}
	
	public void set(int n,Comparable object) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		d.setFirst(object);
	}

	public boolean contains(Comparable object) {
		boolean found = false;
		ListElement d = head;
		if(head != null && !this.isEmpty()) {
			while(d != tail && d.first() != object) {
				d = d.rest();
			}
			if(d.first() == object) {
				found = true;
			}
		}
		return found;
	}
	//test pending  
	public void addFirst(Comparable object) {
		if (isEmpty()) {
			head = new ListElement(object, head);
			tail = head;
			//tail.setRest(head); maybe needed if head is not allowed to be declared in head 
		}else {
			head = new ListElement(object, head);
		}
	}
	
	public void addLast(Comparable object){
		
		if(!isEmpty()){
			
			System.out.println("addLast" + tail.first());
			ListElement last = new ListElement(object,head);
			System.out.println(last);
			//tail.setRest(last);
			//tail = last;
			//System.out.println("addLast" + last.first());
		}
		
		
	}

	public Comparable getFirst() {
		return head.first();
	}
	
	public Comparable getLast() {
		return tail.first();
	}
	public void removeFirst() {
		if(!isEmpty()) {
			ListElement d = head;
			d = d.rest();
			head = d;
		}
	}
	public void removeLast() {
		ListElement last = head;
		if(!this.isEmpty()){
			int i = this.size() - 2 ;
			while(i > 0) {
				last = last.rest();
				i--;
			}
			last.setRest(head);
		}	
	}
	
	public void addSorted(Comparable object) {
		//an empty list, add element in front 
		if(head == null) head = new ListElement(object,null);
		else if (head.first().compareTo(object)>0) {
			//we have to add the element in front 
			head = new ListElement(object,head);
		}else {
			// we have to find the first element which is bigger 
			ListElement d = head;
			while((d.rest() != null)&&(d.rest().first().compareTo(object)<0)) {
				d = d.rest();
			}
			ListElement next = d.rest();
			d.setRest(new ListElement(object,next));
		}	
	}
	
	public Object getHighPriorityPair(){
		
		ListElement d = head;
		Object item = d.first();
		if(head != null) {
			while(d.rest() != null) {
				if(d.first().compareTo(item)>0) {
					item = d.first();
				}
			}
		}
		return item;
	}
	/*public void removeObject(Comparable object) {
		ListElement d = head;
		if(head != null) {
			while(d.rest() != null) {
				if(d.first().compareTo(item)==0) {
					
				}
			}
		}
	}
	*/
	
	
	//frople
	public void fropple() {
		ListElement d = head;
		int i = (size() % 2 == 0) ? size() : size() - 1;
		while(i>1) {
			if(i-- % 2 == 0) {
				Comparable temp = d.first();
				d.setFirst(d.rest().first());
				d.rest().setFirst(temp);
			}
			d = d.rest();
		}
		
	}
	
	public void append(CircularList list) {
		ListElement element = list.head;
		if(!list.isEmpty() && !this.isEmpty()){
			while(element.rest() != null){
				this.addLast(element.first());
				element = element.rest();
			}
			this.addLast(element.first());
		}
	}
	
	public String toString() {
		String s = "(";
		ListElement d = head;
		while (d != null) {
			s += d.first().toString();
			s += " ";
			d = d.rest();
		}
		s += ")";
		return s;
	}
	

	

}

