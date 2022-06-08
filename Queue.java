package ds_java;

public class Queue <T> extends SinglyLL<T>{
	Node head, tail;
	 
	public Queue() {
		this.head = this.tail = null;
	}
	
	public void enqueue(T data) {
		
		Node newnode = new Node(data);
		if (this.tail == null) {
            this.head = this.tail = newnode;
            return;
        }
		
		this.tail.next = newnode;
		this.tail = newnode;
		
	}
	
	public T dequeue() {
		if (this.head == null) {
			return null;
		}
		
		Node temp = this.head;
		this.head = this.head.next;
		if (this.head == null) {
			this.tail = null;
		}
		
		return temp.data;
	}
	
	public void showQueue() {
		Node trav = this.head;
		while (trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
	}
	
}




