package be.vub.ansanche;

import be.vub.ansanche.dataStructures.*;



public class WPO {
	
	public static void binaryTree() {
		Tree tree = new Tree();
		tree.insert(8);
		tree.insert(3);
		tree.insert(1);
		tree.insert(6);
		tree.insert(4);
		tree.insert(7);
		tree.insert(10);
		tree.insert(14);
		tree.insert(13);

		
		tree.print();
		System.out.println("Tree depth : " + tree.maxDepth());
		Object result = tree.biggest();
		System.out.println("Tree biggest : " + result);
		Object resultSmall = tree.smallest();
		System.out.println("Tree smallest : " + resultSmall);
		tree.swapTree();
		tree.print();
	}
	
	public static void lltest() {
		LinkedList listOne = new LinkedList();
		listOne.addFirst(6);
		listOne.addFirst(5);
		listOne.addFirst(4);
		listOne.addFirst(3);
		listOne.addFirst(7);
		listOne.addFirst(1);
		listOne.addFirst(1);
		System.out.println(listOne);
		listOne.remove(6);
		System.out.println(listOne);
		System.out.println(listOne.get(2));
		}
	
	public static void circularListPractice() {
		CircularList listOne = new CircularList();
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
	
	public static void circulaVector() {
		CircularVector circularVector = new CircularVector(5);
		System.out.println("isEmpty" + circularVector.isEmpty());
		
		System.out.println("Add last : ");
		circularVector.addLast(1);
		circularVector.addLast(2);
		circularVector.addLast(3);
		circularVector.addLast(4);
		System.out.println(" First index :" + circularVector.getFirstIndex());
		circularVector.print();
		System.out.println("");
		
		System.out.println("RemoveFirst : ");
		circularVector.removeFirst();
		System.out.println(" First index :" + circularVector.getFirstIndex());
		circularVector.print();
		System.out.println("");
		
		System.out.println("Add last : "); 
		circularVector.addLast(5);
		System.out.println(" First index :" + circularVector.getFirstIndex());
		circularVector.print();
		System.out.println("");
		
		System.out.println("Add last : ");		
		circularVector.addLast(6);
		System.out.println(" First index :" + circularVector.getFirstIndex());
		circularVector.print();
		System.out.println("");
		
		System.out.println("Remove last : ");
		circularVector.removeLast();
		System.out.println(" First index :" + circularVector.getFirstIndex());
		circularVector.print();
		System.out.println("");
		
		System.out.println("AddFirst : ");
		circularVector.addFirst(7);
		System.out.println(" First index :" + circularVector.getFirstIndex());
		circularVector.print();
		System.out.println("");
		
		System.out.println("Remove 2 last : ");
		circularVector.removeLast();
		circularVector.removeLast();
		System.out.println(" First index :" + circularVector.getFirstIndex());
		circularVector.print();
		System.out.println("");
		
		System.out.println("Get First : ");
		System.out.println(" index First[" + circularVector.getFirstIndex()+"] : " + circularVector.getFirst());
		circularVector.print();
		System.out.println("");
		
		System.out.println("AddFirst : ");
		circularVector.addFirst(9);
		System.out.println(" First index :" + circularVector.getFirstIndex());
		circularVector.print();
		System.out.println("");
		
		System.out.println("Get First : ");
		System.out.println(" index First[" + circularVector.getFirstIndex()+"] : " + circularVector.getFirst());
		circularVector.print();
		System.out.println("");
		
		System.out.println("Get Last : ");
		System.out.println(" index Last[" + circularVector.getLastIndex()+"] : " + circularVector.getLast());
		circularVector.print();
		
		int element = 3;
		System.out.println("Contains " + element + "? :" + circularVector.contains(element));
		System.out.println("");
		
		element = 1;
		System.out.println("Contains " + element + "? :" + circularVector.contains(element));
		System.out.println("");
		
		element = 6;
		int index = 1;
		circularVector.print();
		System.out.println("Set " + element + "at index :" + index);
		circularVector.set(index, element);
		circularVector.print();
		System.out.println("");
		
		index = 0;
		circularVector.print();
		System.out.println("Get element at index " + index +" : " + circularVector.get(index));
		System.out.println("");
		
		System.out.println("Size : " + circularVector.size());
		System.out.println("");
		
		
		System.out.println("Queue Circular Vector");
		Queue queue = new Queue();
		//Utilities.println(queue.isEmpty());
		
		queue.push(45);
		queue.push(23);
		queue.push(17);
		queue.print();
		
		queue.push(76);
		queue.push(92);
		queue.print();
		
		queue.pop();
		queue.print();
		
		System.out.println("");
		
		QueueCV queueCV = new QueueCV();
		//Utilities.println(queue.isEmpty());
		
		queueCV.push(45);
		queueCV.push(23);
		queueCV.push(17);
		queueCV.print();
		
		queueCV.push(76);
		queueCV.push(92);
		queueCV.print();
		
		queueCV.pop();
		queueCV.print();
		
		
		
		
	}
	
	public static void priorityQueue() {
		PriorityQueue priorityQueue = new PriorityQueue();
		priorityQueue.push("First", 4);
		priorityQueue.push("Second", 2);
		priorityQueue.push("Third", 3);
		priorityQueue.push("Fourth", 8);
		priorityQueue.push("Fifth", 1);
		priorityQueue.push("Sixth", 4);
		priorityQueue.push("Seventh", 3);
		
		priorityQueue.print();
		//Utilities.println("");
		
		//Utilities.println( "pop : " +  priorityQueue.pop().toString());
		
		//Utilities.println("");
		priorityQueue.print();
		
		
	}
	
	public static void queuePractice(){
		Queue queue = new Queue();
		//Utilities.println(queue.isEmpty());
		
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
		//Utilities.println(queue.isEmpty());
		
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
		//Utilities.println(stack.isEmpty());
		
		stack.push(34);
		stack.push(27);
		stack.push(83);
		stack.print();
		//Utilities.println(stack.top());
		stack.push(58);
		stack.push(22);
		
		stack.print();
		//Utilities.println(stack.top());
		
		stack.pop();
		
		stack.print();
		//Utilities.println(stack.top());
		
	}
	
	public static void stackPracticeLL() {
		StackLL stack = new StackLL();
		//Utilities.println(stack.isEmpty());
		
		stack.push(34);
		stack.push(27);
		stack.push(83);
		stack.print();
		//Utilities.println(stack.top());
		stack.push(58);
		stack.push(22);
		
		stack.print();
		//Utilities.println(stack.top());
		
		stack.pop();
		
		stack.print();
		//Utilities.println(stack.top());
		
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
