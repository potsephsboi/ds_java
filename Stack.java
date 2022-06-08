package ds_java;


public class Stack <T> extends SinglyLL<T>{
	Node head;
	
	
	public void push(T data) {
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
		
	}
	
	public T pop() {
		Node temp = head;
		head = head.next;
		return temp.data;
	}
	
	public void showStack() {
		Node trav = head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}
	
	
}
