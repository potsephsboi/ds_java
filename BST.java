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
	
	public boolean isLeaf(Node node) {
		if (node.left == null && node.right == null) {
			return true;
		}
		return false;
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
		if (delNode == null) {
			return ;
		}
		
		if (isLeaf(delNode)) {
			delNode = null;
			return ;
		}
		
		if (delNode.left == null && delNode.right != null) {
			delNode = delNode.right;
			delNode.right = null;
			return ;
		}
		
		if (delNode.right == null && delNode.left != null) {
			delNode = delNode.left;
			delNode.left = null;
			return ;
		}
		
		if (delNode.right != null && delNode.left != null) {
			//
		}
		
	}
	
}



