/*******************************************************************************
 * '
 * WPO.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * Class that test the data structures with information
 * 
 ******************************************************************************/
package be.vub.ansanche;

import be.vub.ansanche.dataStructures.*;
import be.vub.ansanche.project.*;




public class WPO {
	
	public static void graph() {
		Graph graph = new Graph();
		graph.addNode('A');
		graph.addNode('B');
		graph.addNode('C');
		graph.addNode('D');
	
		graph.addEdge('A','C',5);
		graph.addEdge('A','B',6);
		
		graph.addEdge('B','D',9);
		graph.addEdge('C','D',7);
		
		graph.addEdge('B','A',3);
		graph.addEdge('B','C',4);
		
		
		graph.print();
		
		Stack stack = graph.topologicalSorting();
		stack.print();
		
		graph.shortestPath('D');
		
	}
	
	public static void graph2() {
		Graph graph = new Graph();
		graph.addNode('R');
		graph.addNode('S');
		graph.addNode('T');
		graph.addNode('X');
		graph.addNode('Y');
		graph.addNode('Z');
		
	
		graph.addEdge('R','S',5);
		graph.addEdge('R','T',3);
		graph.addEdge('S','T',2);
		graph.addEdge('S','X',6);
		graph.addEdge('T','X',7);
		graph.addEdge('T','Y',4);
		graph.addEdge('T','Z',2);
		graph.addEdge('X','Y',-1);
		graph.addEdge('X','Z',1);
		graph.addEdge('Y','Z',-2);
		
		
		
		graph.print();
		//graph.depthFirstSearch(new Stack());
		//graph.topologicalSorting();
		graph.shortestPath('S');
		//System.out.println(graph.findPath('A', 'D'));
		//System.out.println(graph.getNodes());
		//graph.depthFirstSearch();
	}

	public static void matrixGraph() {
		MatrixGraph graph = new MatrixGraph(4);
		graph.addEdge(0, 1, 6);
		graph.addEdge(0, 2, 5);
		graph.addEdge(1, 0, 3);
		graph.addEdge(1, 2, 4);
		graph.addEdge(1, 3, 9);
		graph.addEdge(2, 3, 7);
		
		graph.print();
	}
	public static void priorityQueueBT() {
		PriorityQueueBT priorityQueue = new PriorityQueueBT();
		priorityQueue.push("First", 4);
		priorityQueue.push("Second", 2);
		priorityQueue.push("Third", 3);
		priorityQueue.push("Fourth", 8);
		priorityQueue.push("Fifth", 1);
		priorityQueue.push("Sixth", 4);
		priorityQueue.push("Seventh", 3);
		priorityQueue.print();
		System.out.println("pop : " +  priorityQueue.pop().toString());

		//priorityQueue.print();
	}
	public static void binaryTree() {
		Tree tree = new Tree();
		boolean flag = true;
		if(!flag) {
			tree.insert(8);
			tree.insert(3);
			tree.insert(1);
			tree.insert(6);
			tree.insert(4);
			tree.insert(7);
			tree.insert(10);
			tree.insert(9);
			tree.insert(15);
			tree.insert(13);
			tree.insert(11);
			tree.insert(14);
			tree.insert(16);
		}else {
			tree.insert(1);
			tree.insert(2);
			tree.insert(3);
			tree.insert(4);
			tree.insert(5);
			tree.insert(6);
			tree.insert(1);
		}
		//tasks 1-5		
		//tree.printQueue();
		//tree.printRecursively();
		//tree.printStack();

		tree.print();
		//6
		System.out.println("6 Tree depth : " + tree.maxDepth());
		//7
		System.out.println("7 Tree biggest : " + tree.biggest());
		Object resultSmall = tree.smallest();
		System.out.println("7 Tree smallest : " + resultSmall);
		//8
		
		//9
		tree.swapTree();
		tree.print();
		//
	}
	
	public static void dictionaryPractice() {
		Dictionary dictionary = new Dictionary();
		dictionary.add(1, "asg");
		dictionary.print();
		dictionary.add(2, "este");
		dictionary.add(1, "e");
		dictionary.print();
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
		System.out.println("   remove last : " + listOne);// maybe while deadlock
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
		System.out.println("pop : " +  priorityQueue.pop().toString());

		//Utilities.println("");
		priorityQueue.print();


	}
	
	public static void priorityQueueUnsortedLL() {
		PriorityQueue priorityQueue = new PriorityQueue();
		priorityQueue.pushUnsorted("First", 1);
		priorityQueue.pushUnsorted("Second", 2);
		priorityQueue.pushUnsorted("Third", 3);
		priorityQueue.pushUnsorted("Fourth", 8);
		priorityQueue.pushUnsorted("Fifth", 2);
		priorityQueue.pushUnsorted("Sixth", 4);
		priorityQueue.pushUnsorted("Seventh", 4);
		priorityQueue.print();
		System.out.println("pop : " +  priorityQueue.topUnsorted());
		priorityQueue.popUnsorted();
				//().toString());
		//priorityQueue.print();
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
		stack.push(83);
		stack.push(83);
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
		System.out.println("   List First  :  " + listOne.getFirst());
		System.out.println("   List Get at :  " + listOne.get(3));
		//2 List Size
		System.out.println("2) Size        :  " + listOne.size());
		//3) set element at nth
		listOne.set(2,2);
		System.out.println("3) List One 2  : " + listOne);
		//4) get last
		System.out.println("4) get Last    :  " + listOne.getLast());
		//5) add last
		listOne.addLast(8);
		System.out.println("5) List One 3  : " + listOne);
		//6) search in a Linked List
		System.out.println("6) Search in LL:  " + listOne.contains(7));
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
	public static void vectorPractice2() {
		Vector vectorFour = new Vector(3);
		for(int i = 4; i<6 ;i++){
			vectorFour.addLast(i);
		}
		vectorFour.print();
		Vector vectorFive = new Vector(3);
		for(int i = 7; i<=10 ;i++){
			vectorFive.addLast(i);
		}
		vectorFive.print();
		vectorFour.append(vectorFive);
		vectorFour.print();
		
	}
	public static void vectorPractice3() {
	
		//9 extend capacity
		Vector vectorFour = new Vector(3);
		for(int i = 4; i<=6 ;i++){
			vectorFour.addLast(i);
		}
		//vectorFour.print();
		vectorFour.addLast(7);
		
		vectorFour.print();
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
		Vector vectorDoubled = vectorOne.doubled();
		vectorDoubled.print();
		System.out.println("size doub : " + vectorDoubled.size());

		//8 Vector interleave
		Vector vectorThree = new Vector(3);
		for(int i = 1; i<=3 ;i++){
			vectorThree.addLast(i);
		}
		Vector vectorFour = new Vector(3);
		for(int i = 4; i<=6 ;i++){
			vectorFour.addLast(i);
		}

		Vector vectorInter = vectorThree.interleave(vectorFour);
		vectorInter.print();
		vectorThree.print();
		vectorFour.print();

		//9 extend capacity
		vectorFour.addLast(7);
		//vectorFour.print();

	}

}
