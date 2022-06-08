package ds_java;


public class UnionFind {
	
	class Node{
		int data;
		Node parent;
		Node(int data){
			this.data = data;
			this.parent = this;
		}
	}
	
	int size;
	
	DynArray<Node> NodesLst = new DynArray<Node>();
	public UnionFind(int arr[]){
		for (int i = 0; i < arr.length; i++) {			
			Node n = new Node(arr[i]);			
			NodesLst.add(n);
		}
		this.size = arr.length;
	}


	public void unify(Node a, Node b) {
		Pair<Node, Integer> rootA_data = find(a);
		Pair<Node, Integer> rootB_data = find(b);
		Node node_A = rootA_data.first();
		Node node_B = rootB_data.first();
		int len_A = rootA_data.second();
		int len_B = rootB_data.second();
		
		if (node_A == node_B) {
			return ;
		}
		else {
			if (len_A >= len_B) {
				node_B.parent = node_A;
			}
			else {
				node_A.parent = node_B;
			}
		}
			
	}
	
	DynArray<Node> compress = new DynArray<Node>();
	public Pair<Node, Integer> find(Node node) {
		compress.add(node);
		
		if (node.parent == node) {
			int length = 0;
			for (int i = 0; i < compress.len; i++) {
				compress.get(i).parent = node;
				length += 1;
			}
			Pair<Node, Integer> p = new Pair<Node, Integer>(node, length);
			compress.clear(); 
			return p;
		}
		
		return find(node.parent);
		
			
	}
	
	
	
}
