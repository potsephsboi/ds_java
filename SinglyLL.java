package ds_java;


public class SinglyLL <T>{
	Node head;
	
	public class Node{
		T data;
		Node next;
		Node(T data){
			this.data = data;
			this.next = null;
		}
			
	}

	public boolean DeleteKey(T key) {
		Node start = head;
		Node prev = head;
		
		if (start.data == key) {
			head = start.next;
			return true;
		}
		if (start.next.data == key) {
			head.next = null;
			return true;
		}
		
		while(start.next != null) {
			if (start.data == key) {
				prev.next = start.next;
				start = null;
				return true;
			}
			prev = start;
			start = start.next;
		}
		
		return false;
	}
	
	public void InsertFront(T data) {
		Node newnode = new Node(data);
		newnode.next = head;
		head = newnode;
		
	}
	
	public void InsertTail(T data) {
		Node newnode = new Node(data);
		Node temp = head;
		
		if(head == null) {
			
		    head = newnode;
		  } 
		else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newnode;
		}
	}
	
	public void InsertAfterKey(T data, T key) {
		boolean found = false;
		Node newnode = new Node(data);
		Node trav = head;
		
		while (trav != null) {
			if (trav.data == key) {
				found = true;
				break;
			}
			trav = trav.next;
			
		}
		if (found) {
			Node temp =  new Node(null);
			temp.next = trav.next;
			trav.next = newnode;
			newnode.next = temp.next;
		}
		else { return; }		
		
	}
	
	public void delete_key(T key) {
		boolean found = false;
		Node trav = head;
		while (trav != null) {
			if (trav.next.data == key) {
				found = true;
				break;
			}
			trav = trav.next;
			
		}
		if (found) {
			Node del = trav.next;
			trav.next = del.next;
			System.gc();
		}
		else { return; }
		
	}
	
	public void show() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	
	
}