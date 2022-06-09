package ds_java;


public class BST {

	
	class Node{
		
		int data;
		Node parent;
		Node left;
		Node right;
		Node (int data, Node parent){
			this.data = data;
			this.parent = parent;
			this.left = null;
			this.right = null;
		}
	}
	

	int height;
	
	Node root = new Node(0, null);
	public BST(int r_data) {
		root.data = r_data;
		root.parent = root;
		
	}
	
	
	private Node findInsertNode(Node cur_node, int data) {
		if ((cur_node.left == null && data < cur_node.data) || (cur_node.right == null && data > cur_node.data)) {
			return cur_node;
		}
		else if (cur_node.data > data) {
			return findInsertNode(cur_node.left, data);
		}
		
		else if (cur_node.data < data) {
			return findInsertNode(cur_node.right, data);
		}
		else {
			return null;
		}
		
	}
	
	
	private Node findDeleteNode(Node cur_node, int data) {
		if (cur_node == null) {
			System.out.println("Node with given data does not exist");
			return null;
		}
		
		else if (cur_node.data == data) {
			return cur_node;
		}
		
		else if (cur_node.data > data) {
			return findDeleteNode(cur_node.left, data);
		}
		
		else {
			return findDeleteNode(cur_node.right, data);
		}
		
		
	}
	
	private void quickDelete(Node delNode) {
		if (delNode == null) {
			return ;
		}
		
		if (isLeaf(delNode)) {
			if (delNode.parent.right == delNode) {
				delNode.parent.right = null;
				delNode = null;
			}
			else if (delNode.parent.left == delNode) {
				delNode.parent.left = null;
				delNode = null;
			}
			return ;
		}
		
		if (delNode.left == null && delNode.right != null) {
			
			delNode.parent.right = delNode.right;
			delNode = null;
			return ;
		}
		
		if (delNode.right == null && delNode.left != null) {
			
			delNode.parent.left = delNode.left;
			delNode = null;
			return ;
		}
	}
	
	
	private Node findSuccessor(Node cur_node) { 	// smallest in right subtree
		while (cur_node.left != null) {
			findSuccessor(cur_node.left);
		}
		return cur_node;
	}
	
	public boolean isLeaf(Node node) {
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
	}
	
	
	public int findHeight(Node cur_node) {
		if (cur_node != null) {
			int h1 = findHeight(cur_node.left);
			int h2 = findHeight(cur_node.right);
			if (h1 >= h2) {
				height = h1;
			}
			else {
				height = h2;
			}
			
			return height+1;
			
		}
		return 0;
	}
	
	
	public void insert(int data) {
		Node InsNode = findInsertNode(root, data);
		if (InsNode == null) {
			System.out.println("Node with specified data already exists");
			return ;
		}
		if (InsNode.data > data) {
			Node newnode = new Node(data, InsNode);
			InsNode.left = newnode;
		}
		else {
			Node newnode = new Node(data, InsNode);
			InsNode.right = newnode;
		}
		
	}
	
	
	public void delete(int data) {
		Node delNode = findDeleteNode(root, data);
		
		quickDelete(delNode);
		
		if (delNode.right != null && delNode.left != null) {
			Node swapNode = findSuccessor(delNode.right);
			delNode.data = swapNode.data;
			quickDelete(swapNode);
			
		}
		
	}
	
	
	
	public void printLevelOrder(Node root)
	{
		height = findHeight(root);
	    for (int i=1; i<=height; i++)
	    {
	        printGivenLevel(root, i);
	        System.out.println();
	    }
	}

	private void printGivenLevel(Node root, int level)
	{
		
		
	    if (root == null) 
	        return;
	    
	    if (level == 1)
	        System.out.print(root.data);
	    else if (level > 1)
	    {
	        printGivenLevel(root.left, level-1);
	        printGivenLevel(root.right, level-1);
	    }
	}
	
}



