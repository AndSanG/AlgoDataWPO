package be.vub.ansanche;

import be.vub.ansanche.dataStructures.*;



public class WPO {
	
	public static void queuePractice(){
		Queue queue = new Queue();
		Utilities.println(queue.isEmpty());
		
		queue.push(45);
		queue.push(23);
		queue.push(17);
		queue.print();
		
		queue.push(76);
		queue.push(92);
		queue.print();
		
		queue.pop();
		queue.print();
	}
	
	public static void queuePracticeLL(){
		QueueLL queue = new QueueLL();
		Utilities.println(queue.isEmpty());
		
		queue.push(45);
		queue.push(23);
		queue.push(17);
		queue.print();
		
		queue.push(76);
		queue.push(92);
		queue.print();
		
		queue.pop();
		queue.print();
	}
	
	public static void stackPractice() {
		Stack stack = new Stack();
		Utilities.println(stack.isEmpty());
		
		stack.push(34);
		stack.push(27);
		stack.push(83);
		stack.print();
		Utilities.println(stack.top());
		stack.push(58);
		stack.push(22);
		
		stack.print();
		Utilities.println(stack.top());
		
		stack.pop();
		
		stack.print();
		Utilities.println(stack.top());
		
	}
	
	public static void stackPracticeLL() {
		StackLL stack = new StackLL();
		Utilities.println(stack.isEmpty());
		
		stack.push(34);
		stack.push(27);
		stack.push(83);
		stack.print();
		Utilities.println(stack.top());
		stack.push(58);
		stack.push(22);
		
		stack.print();
		Utilities.println(stack.top());
		
		stack.pop();
		
		stack.print();
		Utilities.println(stack.top());
		
	}
	
	public static void linkedListPractice() {
		LinkedList listOne = new LinkedList();
		listOne.addFirst(6);
		listOne.addFirst(5);
		listOne.addFirst(4);
		listOne.addFirst(3);
		listOne.addFirst(7);
		listOne.addFirst(1);
		listOne.addFirst(1);
		
		//1 Create List
		System.out.println("1) List One    : " + listOne);
		System.out.println("   List First  : " + listOne.getFirst());
		System.out.println("   List Get at : " + listOne.get(3));
		//2 List Size
		System.out.println("2) Size        : " + listOne.size());
		//3) set element at nth
		listOne.set(2,2);
		System.out.println("3) List One 2  : " + listOne);
		//4) get last
		System.out.println("4) get Last    : " + listOne.getLast());
		//5) add last
		listOne.addLast(8);
		System.out.println("5) List One 3  : " + listOne);
		//6) search in a Linked List
		System.out.println("6) Search in LL: " + listOne.contains(7));
		//7 implement remove first and remove last
		listOne.removeFirst();
		System.out.println("7) remove first: " + listOne);
		listOne.removeLast();
		System.out.println("   remove last : " + listOne);
		LinkedList list1 = new LinkedList();
		list1.addFirst(3);
		list1.addFirst(2);
		list1.addFirst(1);
		LinkedList list2 = new LinkedList();
		list2.addFirst(6);
		list2.addFirst(5);
		list2.addFirst(4);
		//8 Fropple
		listOne.fropple();
		System.out.println("       fropple : " + listOne);
		//9 append
		list1.append(list2);
		System.out.println("       append  : " + list1);
		
		
	}
	
	public static void vectorPractice() {
		Vector vectorOne = new Vector(120);
		for(int i = 0; i<100 ;i++){
			vectorOne.addLast(i);
		}
		//1.1 verify size vector
		System.out.println("size : " + vectorOne.size());
		//1.2 verify if contains 6 
		System.out.println("contains 6 :" + vectorOne.contains(6));
		//1.3 verify if contains 101
		System.out.println("contains 101 :" + vectorOne.contains(100));
		
		//2.1 get first
		System.out.println("First Elemnt" + vectorOne.getFirst());
		//2.2 get last
		System.out.println("Last Element" + vectorOne.getLast());
		
		//3 print vector
		vectorOne.print();
		
		//4 add first
		vectorOne.addFirst(22);
		vectorOne.print();
		System.out.println("size : " + vectorOne.size());
		
		//5.1 Remove first  
		vectorOne.removeFirst();
		vectorOne.print();
		System.out.println("size : " + vectorOne.size());
		//5.2 Remove last
		vectorOne.removeLast();
		vectorOne.print();
		System.out.println("size : " + vectorOne.size());
		
		//6 Reverse
		vectorOne.reverse();
		vectorOne.print();
		System.out.println("size : " + vectorOne.size());
		
		//7 Vector double 
	}

}
