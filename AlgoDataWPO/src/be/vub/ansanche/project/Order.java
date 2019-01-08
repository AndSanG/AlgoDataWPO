package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.LinkedList;

public class Order{
	private LinkedList order;
	private double value;
	
	public Order(LinkedList order,double value) {
		super();
		this.value = value;
		this.order = order;
	}
	public String toString() {
		String order = this.order.toString();
		order += '\n' + "                                                 "
				+ ""+"Total: " + this.value + '\n' + '\n';
				//this.getId() + " " + this.getName() + '\n';
		return order;
	}
}