package be.vub.ansanche.project;

import be.vub.ansanche.dataStructures.Tree;

public class Order{
	private Tree order;
	private double value;
	
	public Order(Tree order,double value) {
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