package ds_java;	

public class BinaryHeap {
	
	
	class Node{
		int data;
		Node left;
		Node right;
		Node parent;
		Node(int data, Node parent){
			this.data = data;
			this.parent = parent;
			this.left = null;
			this.right = null;
		}
		
	}

	
	int height;
	
	Node root = new Node(0, null);
	DynArray<Node> NodesLst = new DynArray<Node>();
	public BinaryHeap(int rdata) {
		root.data = rdata;
		NodesLst.add(root);
		height = 1;
		
	}
	
	private Node findNode(int data) {
		for (int i = 0; i < NodesLst.len; i++) {
			if (NodesLst.get(i).data == data) {
				return NodesLst.get(i);
			}
		}
		return null;
	}
	
	private void bubbleUp(Node node){
		if (node.parent == null || node.data > node.parent.data) {
			return;
		}
		int temp = node.parent.data;
		node.parent.data = node.data;
		node.data = temp;
		
		bubbleUp(node.parent);
		 
	}
	
	
	private void bubbleDown(Node node) {
		if ((node.left == null && node.right == null ) || (node.data < node.left.data && node.data < node.right.data )) {
			return;
		}
		
		if (node.left != null && node.data > node.left.data) {
			int temp = node.left.data;
			node.left.data = node.data;
			node.data = temp;
			bubbleDown(node.left);
		}
		
		else if (node.right != null && node.data > node.right.data) {
			int temp = node.right.data;
			node.right.data = node.data;
			node.data = temp;
			bubbleDown(node.right);
		}
		
	}
	
	private int findInsertPoint() {
		for(int i = 0; i < NodesLst.len+1; i++){ 
			if (NodesLst.get(i).left == null || NodesLst.get(i).right == null) {
				return i;
			}
		}
		return -1;
	}

	private void updateNodesLst(Node root) {
		for (int i = 1; i <= height; i++) {
			updateLevel(root, i);
		}
		
	}
	
	private void updateLevel(Node root, int level) {
		if (root == null)
	        return;
		
	    if (level == 1)
	        NodesLst.add(root);
	    
	    else if (level > 1)
	    {
	    	updateLevel(root.left, level-1);
	    	updateLevel(root.right, level-1);
	    }
	}
	
	public int peek() {
		return root.data;
	}
	
	
	public void poll() {

		Node swapElement = NodesLst.getLast();
		root.data = swapElement.data;
		swapElement = null;
		
		bubbleDown(root);
		
		NodesLst.clear();
		updateNodesLst(root);
	}
	
	
	public void remove(int data) {
		Node node = findNode(data);
		Node swapElement = NodesLst.getLast();
		node.data = swapElement.data;
		
		if (node.parent != null && node.parent.data > node.data) {
			bubbleUp(node);
		}
		else if ((node.left != null && node.right != null ) && (node.data > node.left.data || node.data > node.right.data )) {
			bubbleDown(node);
		}
		
		NodesLst.clear();
		updateNodesLst(root);
		NodesLst.removeAt(NodesLst.len-1);
		NodesLst.len -= 1;
	}
	
	public void insert(int data) {
		int index = findInsertPoint();
		Node InsNode = NodesLst.get(index);
		if (InsNode.left == null && InsNode.right == null) {
			height += 1;
			
		}
		Node newnode = new Node(data, InsNode);
		if (InsNode.left == null) {
			InsNode.left = newnode;
		}
		else {
			InsNode.right = newnode;
		}

		if (newnode.data < InsNode.data) {
			bubbleUp(newnode);
			NodesLst.clear();
			updateNodesLst(root);
		}
		else {
			NodesLst.add(newnode);
		}
		
		
		
	}
	
	public void showBH() {
		for(int i = 0; i < NodesLst.len; i++){ 
			System.out.print(NodesLst.get(i).data);
			System.out.print(" ");
		}
	}
	


}
