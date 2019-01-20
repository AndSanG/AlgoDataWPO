/*******************************************************************************
 * '
 * Tree.java
 * Algorithms and Data Structures
 * 
 * Andrés Sánchez
 * 2019
 * 
 * This class represents a binary tree
 * 
 ******************************************************************************/
package be.vub.ansanche.dataStructures;

public class Tree {
	/*
	private class NaturalComparator implements Comparator
	{
		public int compare(Object a, Object b)
		{
			return ((Comparable)a).compareTo(b);
		}
	}
	 */



	// the class for implementing a node in the tree.
	// contains a value, a pointer to the left child and a pointer to the right child

	public class TreeNode implements Comparable
	{
		protected Comparable value;
		protected TreeNode leftNode;
		protected TreeNode rightNode;
		protected TreeNode parentNode;

		public TreeNode(Comparable v, TreeNode left, TreeNode right, TreeNode parent)
		{
			value = v;
			leftNode = left;
			rightNode = right;
			parentNode = parent;
		}
		

		public TreeNode(Comparable v)
		{
			this(v,null,null,null);
		}


		public TreeNode getLeftTree()
		{
			return leftNode;
		}

		public TreeNode getRightTree()
		{
			return rightNode;
		}

		public TreeNode getParent()
		{
			return parentNode;
		}

		public Comparable getValue()
		{
			return value;
		}

		@Override
		public int compareTo(Object object) {
			return value.compareTo(((TreeNode)object).value);
		}
	}

	//

	public class TreeNodeXY implements Comparable
	{
		protected Comparable x;
		protected Comparable y;
		protected TreeNodeXY left1Node;
		protected TreeNodeXY left2Node;
		protected TreeNodeXY right1Node;
		protected TreeNodeXY right2Node;



		public TreeNodeXY(Comparable x, Comparable y, TreeNodeXY left1Node, TreeNodeXY left2Node, TreeNodeXY right1Node,
				TreeNodeXY right2Node) {
			this.x = x;
			this.y = y;
			this.left1Node = left1Node;
			this.left2Node = left2Node;
			this.right1Node = right1Node;
			this.right2Node = right2Node;
		}
		public TreeNodeXY(Comparable x, Comparable y) {
			this.x = x;
			this.y = y;
			this.left1Node = null;
			this.left2Node = null;
			this.right1Node = null;
			this.right2Node = null;
		}

		public TreeNodeXY() {
			this.x = null;
			this.y = null;
			this.left1Node = null;
			this.left2Node = null;
			this.right1Node = null;
			this.right2Node = null;
		}

		public Comparable getX() {
			return x;
		}

		public Comparable getY() {
			return y;
		}

		public TreeNodeXY getLeft1Node() {
			return left1Node;
		}

		public TreeNodeXY getLeft2Node() {
			return left2Node;
		}

		public TreeNodeXY getRight1Node() {
			return right1Node;
		}

		public TreeNodeXY getRight2Node() {
			return right2Node;
		}

		public int compareTo(Object object) {
			return x.compareTo(((TreeNodeXY)object).x);
		}

	}


	// start of the actual tree class
	/*
	 *  public methods  
	 */
	// the root of our tree
	private TreeNode root;
	private TreeNodeXY rootXY;
	
	private String description;

	public Tree()
	{
		root = null;
	}

	public Comparable find(Comparable element) {
		return findNode(element, root);
	}

	public void insert(Comparable element)
	{
		insertAtNode(element,root,null);
	}
	
	public void remove(Comparable element) {
		removeNode(element , root );
	}
	
	private void removeNode(Comparable element ,TreeNode current) {
		if(current == null) return;
		else if (element.compareTo(current.value) == 0) {
			if(current.leftNode == null) transplant(current ,current.rightNode);
			else if(current.rightNode == null) transplant(current ,current.leftNode); 
			else {
				TreeNode y = minNode( current.rightNode ); 
				if(y.parentNode != current) {
					transplant (y , y.rightNode );
					y.rightNode = current.rightNode ; 
					y.rightNode.parentNode = y;
				}
				transplant(current ,y);
				y.leftNode = current.leftNode ;
				y.leftNode.parentNode = y ;
			}
		}
		else if (element.compareTo(current.value) < 0) {
			removeNode(element , current . getLeftTree ());
		}else removeNode(element , current . getRightTree ());
	}
	
	private void transplant(TreeNode oldNode, TreeNode newNode) {
		if(oldNode.parentNode == null) root = newNode;
		else if(oldNode.parentNode.getLeftTree() == oldNode)
		{
			oldNode . parentNode . leftNode = newNode ;
		}
		else oldNode.parentNode.rightNode = newNode;
		if(newNode != null) newNode.parentNode = oldNode.parentNode; 
	}
	
	public TreeNode minNode(TreeNode current ) {
		if(current == null) return null;
		else if(current.getLeftTree() == null) return current; else return minNode( current . getLeftTree ());
	}
	
	
	//traverse queue based 
	public void traverse(TreeAction action)
	{
		Queue t = new Queue();
		//Stack t = new Stack();
		t.push(root);
		while(!t.isEmpty())
		{
			TreeNode n = (TreeNode)t.pop();
			action.run(n);
			if(n.getLeftTree() != null) t.push(n.getLeftTree());
			if(n.getRightTree() != null) t.push(n.getRightTree());
		}
	}

	//traverse recursively
	public void traverseInOrder(TreeAction action)
	{
		traverseNode(root,action);
	} 

	public void print()
	{
		traverseInOrder(new TreeAction()
		{
			public void run(TreeNode n)
			{
				System.out.print(" " + n.value + " \n");
			}
		});
		System.out.println("");
	}
	
	public String toString() {
		description = "";
		traverseInOrder(new TreeAction()
		{
			public void run(TreeNode n)
			{
				description +=n.value + " \n";
			}
		});
		return description;
	}
	

	public int maxDepth() {
		return maxDepthNode(root);
	}

	public Comparable biggest() {
		return biggestNode(root);
	}

	public Comparable smallest() {
		return smallestNode(root);
	}

	public Comparable smallestX() {
		return smallestXNode(rootXY);
	}

	public void swapTree() {
		swapNode(root);
	}

	/*
	 * <<<<<<<<<Private methods>>>>>>>>>>
	 */


	private Comparable findNode(Comparable element, TreeNode current) {

		if (current == null) {
			return null;
		}
		else if (element.compareTo(current.value)==0) {
			return current.value;
		}
		else if (element.compareTo(current.value)<0) {
			return findNode(element, current.getLeftTree());
		}
		else {
			return findNode(element, current.getRightTree());
		}
	}


	// we traverse the tree.
	// Current holds the pointer to the TreeNode we are currently checking
	// Parent holds the pointer to the parent of the current TreeNode
	private void insertAtNode(Comparable element,TreeNode current,TreeNode parent)
	{
		// if the node we check is empty
		if(current == null)
		{
			TreeNode newNode = new TreeNode(element);
			// the current node is empty, but we have a parent
			if(parent != null)
			{
				// do we add it to the left?
				if(element.compareTo(parent.value) < 0)
				{
					parent.leftNode = newNode;
				}
				// or do we add it to the right?
				else
				{
					parent.rightNode = newNode;
				}
				newNode . parentNode = parent ;
			}
			// the current node is empty and it has no parent, we actually have an empty tree
			else root = newNode;
		}
		else if(element.compareTo(current.value) == 0)
		{
			// if the element is already in the tree, what to do?
			//update/override ?
			current.value = element;
		}
		// if the element is smaller than current, go left
		else if(element.compareTo(current.value) < 0)
		{
			insertAtNode(element,current.getLeftTree(),current);
		}
		// if the element is bigger than current, go right
		else insertAtNode(element,current.getRightTree(),current);
	}

	private void traverseNode(TreeNode n,TreeAction action)
	{
		if(n != null)
		{
			action.run(n);
			if(n.getLeftTree() != null) traverseNode(n.getLeftTree(),action);
			
			if(n.getRightTree() != null) traverseNode(n.getRightTree(),action);
		}
	}

	int maxDepthNode(TreeNode current)  
	{ 
		if (current == null) 
			return 0; 
		else 
		{ 
			/* compute the depth of each subtree */
			int leftDepth = maxDepthNode(current.leftNode); 
			int rightDepth = maxDepthNode(current.rightNode); 

			/* use the larger one */
			if (leftDepth > rightDepth) 
				return (leftDepth + 1); 
			else 
				return (rightDepth + 1); 
		} 
	}

	Comparable biggestNode(TreeNode current) {

		if (current == null) 
			return Integer.MIN_VALUE; 
		else 
		{  

			Comparable value = current.getValue(); 
			Comparable leftValue = biggestNode(current.leftNode); 
			Comparable rightValue = biggestNode(current.rightNode); 
			//System.out.println("value      :"+value);
			//System.out.println("leftValue  :"+leftValue);
			//System.out.println("rightValue :"+rightValue);
			
			if (leftValue.compareTo(value) > 0) 
				value = leftValue; 
			if (rightValue.compareTo(value) > 0) 
				value = rightValue; 
			return value;  
		} 
	}

	Comparable smallestNode(TreeNode current) {

		if (current == null) 
			return Integer.MAX_VALUE; 
		else 
		{ 

			Comparable value = current.getValue(); 
			Comparable leftValue = smallestNode(current.leftNode); 
			Comparable rightValue = smallestNode(current.rightNode); 

			if (leftValue.compareTo(value) < 0) 
				value = leftValue; 
			if (rightValue.compareTo(value) < 0) 
				value = rightValue; 
			return value;  
		} 
	}

	void swapNode(TreeNode current) {
		if(current == null) {
			return;
		}else {
			TreeNode temp = current.leftNode; 
			current.leftNode = current.rightNode;
			current.rightNode = temp;
			swapNode(current.leftNode);
			swapNode(current.rightNode);
		}
	}

	Comparable smallestXNode(TreeNodeXY current) {

		if (current == null) 
			return Integer.MAX_VALUE; 
		else 
		{ 

			Comparable value = current.getX(); 
			Comparable left1Value = smallestXNode(current.left1Node);
			Comparable left2Value = smallestXNode(current.left2Node);
			Comparable right1Value = smallestXNode(current.right1Node);
			Comparable right2Value = smallestXNode(current.right2Node);

			Tree tree = new Tree();
			tree.insert(value);
			tree.insert(left1Value);
			tree.insert(left2Value);
			tree.insert(left1Value);
			tree.insert(right2Value);

			return tree.smallest();  
		} 
	}

	//Extra work 
	public String printRecursively(){
		return printNodeRecur(root);
	}
	
	public String printNodeRecur(TreeNode n) {
		String string = new String();
		if (n!=null) {
			printNodeRecur(n.rightNode);
			string += n.value;
			//System.out.println(n.value);
			printNodeRecur(n.leftNode);
			
		}
		return string;
	}
	
	public void printStack() {
		Stack t = new Stack (); t.push(root);
		while (!t.isEmpty())
		{
			TreeNode n = (TreeNode)t.pop(); 
			System.out.println(n.value);  
			if(n.getLeftTree() != null) t.push(n.getLeftTree());
			if(n.getRightTree() != null) t.push(n.getRightTree());
		}
	}
	
	public void printQueue() {
		Queue t = new Queue (); t.push(root);
		while (!t.isEmpty())
		{
			TreeNode n = (TreeNode)t.pop(); 
			System.out.println(n.value);  
			if(n.getRightTree() != null) t.push(n.getRightTree());
			if(n.getLeftTree() != null) t.push(n.getLeftTree());
			
		}
	}

}


