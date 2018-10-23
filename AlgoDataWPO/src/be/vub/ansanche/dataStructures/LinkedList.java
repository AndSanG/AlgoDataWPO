package be.vub.ansanche.dataStructures;

public class LinkedList {
	
	private class ListElement {
		private Object el1;
		private ListElement el2;

		public ListElement(Object el, ListElement nextElement) {
			el1 = el;
			el2 = nextElement;
		}

		public ListElement(Object el) {
			this(el, null);
		}

		public Object first() {
			return el1;
		}

		public ListElement rest() {
			return el2;
		}

		public void setFirst(Object value) {
			el1 = value;
		}

		public void setRest(ListElement value) {
			el2 = value;
		}
	}
	
	private ListElement head;
	
	//-----
	
	public LinkedList() {
		head = null;
	}
	
	public int size() {
		ListElement d = head;
		int size = 0;
		if(!this.isEmpty()) {
			size = 1;
			while (d.rest() != null) {
				d = d.rest();
				size++;
			}
		}
		
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}

	public Object get(int n) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		return d.first();
	}
	
	public void set(int n,Object object) {
		ListElement d = head;
		while (n > 0) {
			d = d.rest();
			n--;
		}
		d.setFirst(object);
	}

	public boolean contains(Object object) {
		boolean found = false;
		ListElement d = head;
		if(head != null && !this.isEmpty()) {
			while(d.rest() != null && d.first() != object) {
				d = d.rest();
			}
			if(d.first() == object) {
				found = true;
			}
		}
		return found;
	}
	
	public void addFirst(Object object) {
		head = new ListElement(object, head);
	}
	
	public void addLast(Object object){
		ListElement d = head;
		if(head != null) {
			while(d.rest() != null) {
				d = d.rest();
			}
			ListElement last = new ListElement(object);
			d.setRest(last);
		}
	}

	public Object getFirst() {
		return head.first();
	}
	
	public Object getLast() {
		return this.get(size()-1);
	}
	public void removeFirst() {
		if(!this.isEmpty()) {
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
			last.setRest(null);
		}
		
	}
	
	//reverse
	//frople
	public void fropple() {
		ListElement d = head;
		int i = (size() % 2 == 0) ? size() : size() - 1;
		while(i>1) {
			if(i-- % 2 == 0) {
				Object temp = d.first();
				d.setFirst(d.rest().first());
				d.rest().setFirst(temp);
			}
			d = d.rest();
		}
		
	}
	
	public void append(LinkedList list) {
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

