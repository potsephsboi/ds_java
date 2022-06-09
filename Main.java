package ds_java;


public class Main {
	
	// driver code
	public static void main(String[] args) {

		
	/*	
		SinglyLL<Integer> ll = new SinglyLL<Integer>();
		for (Integer i = 0; i < 5; i++) {
			ll.InsertFront(i);
		}
		ll.show();
		System.out.println();
		

		ll.InsertAfterKey(12, 1);
		ll.InsertFront(5);
		ll.InsertTail(3);
		ll.delete_key(0);
		ll.show();
														*/
		
		
		// --------------------------------//
		
	
	/*
		Stack<Integer> stk = new Stack<Integer>();
		for (int i = 1; i < 6; i++) {
			stk.push(i);
		}
		stk.showStack();
		System.out.println();
		System.out.println(stk.pop());
		System.out.println();
		stk.showStack();
														*/
		
		// --------------------------------//
		
		
	/*
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 1; i < 6; i++) {
			q.enqueue(i);
		}
		q.showQueue();
		System.out.println();
		q.enqueue(6);
		q.dequeue();
		q.showQueue();
														*/
		// --------------------------------//
		
		
	/* 
		BinaryHeap bh = new BinaryHeap(34);
		bh.insert(21);
		bh.insert(1);
		bh.insert(10);
		bh.insert(35);
		bh.insert(36);
		bh.insert(37);
		bh.insert(38);
		bh.poll();
		bh.remove(34);
		
		bh.showBH();
		
														*/
		// --------------------------------//
		
		
	/*
		int a[] = {3, 5, 2, 6, 7};
		UnionFind uf = new UnionFind(a);
		uf.unify(uf.NodesLst.get(0), uf.NodesLst.get(1));
		uf.unify(uf.NodesLst.get(1), uf.NodesLst.get(2));
		uf.unify(uf.NodesLst.get(3), uf.NodesLst.get(4));
		uf.unify(uf.NodesLst.get(1), uf.NodesLst.get(4));
		
														*/
		
		BST bst = new BST(5);
		bst.insert(3);
		bst.insert(7);
		bst.insert(2);
		bst.insert(10);
		bst.insert(11);
		bst.printLevelOrder(bst.root);
		System.out.println();
		
		
	}
	

}
