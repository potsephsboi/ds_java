package ds_java;


public class HashTable <K, V> {
	
	private static final int DEFAULT_CAPACITY = 3;
	private static final double DEFAULT_LOAD_FACTOR = 0.75;
	int capacity, size, threshold = 0;
	
	SinglyLL <Entry<K, V>> table [];
	
	@SuppressWarnings("unchecked")
	public HashTable(int capacity) {
		
		this.capacity = java.lang.Math.max(capacity, DEFAULT_CAPACITY);
		this.threshold = (int) (capacity*DEFAULT_LOAD_FACTOR);
		table = new SinglyLL[this.capacity];
	}
	
	
	private void resizeTable() {
		// TODO Auto-generated method stub	
	}
	
	private int normalizeIndex(int keyHash) {
		return (keyHash & 0x7FFFFFFF) % capacity;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmty() {
		return this.size == 0;
	}
	
	public void clear() {
		for (int i = 0; i < table.length; i++) {
			table[i] = null;
		}
		size = 0; 
	}
	
	public boolean containsKey(K key) {
		int index = normalizeIndex(key.hashCode());
		 SinglyLL<Entry<K,V>>.Node trav = table[index].head;
		 while (trav != null) {
			 if (trav.data.key == key) {
				 return true;
			 }
			 trav = trav.next;
		 }
		 return false;
	}
	
	
	public V add(K key, V value) {
		return insert(key, value);
	}
	
	public V put(K key, V value) {
		return insert(key, value);
	}


	public V insert(K key, V value) {
		int table_index = normalizeIndex(key.hashCode());
		SinglyLL<Entry<K, V>> bucket = table[table_index];

		Entry<K, V> entry = new Entry<>(key, value);
	    if (bucket == null) table[table_index] = bucket = new SinglyLL<>();
	    
	    SinglyLL<Entry<K, V>>.Node trav = bucket.head;
		while (trav != null) {
			if (trav.data.key == key) {
				V oldVal = trav.data.value;
				trav.data.value = value;
				return oldVal;
			}
			trav = trav.next;
		}
		bucket.InsertTail(entry);
		
		
		if (size++ > threshold) {
			resizeTable();
			size++;
		}
		return null; 
	}

	
	public V get(K key) {	
		int table_index = normalizeIndex(key.hashCode());
		SinglyLL <Entry<K, V>> bucket = table[table_index];
		if (bucket == null) return null;
		SinglyLL<Entry<K, V>>.Node trav = bucket.head;
		while (trav != null) {
			if (trav.data.key == key) {
				return trav.data.value;
			}
			trav = trav.next;
		}
		
		return null;
	}
	
	
	public V delete(K key) {
		int table_index = normalizeIndex(key.hashCode());
		SinglyLL <Entry<K, V>> bucket = table[table_index];
		SinglyLL<Entry<K, V>>.Node trav = bucket.head;
		Entry <K, V> entry = null;
		while (trav != null) {
			if (trav.data.key == key) {
				entry = trav.data;
				break;
			}
			trav = trav.next;
		}
		if (entry == null) {
			return null;
		}
		V entry_val = entry.value;
		bucket.DeleteKey(entry);
		size--;
		return entry_val;
	}

}


/*
 while (trav.next != null) {
			if (trav.next.data.key == key) {
				SinglyLL<Entry<K, V>>.Node temp = trav.next;
				trav.next = trav.next.next;
				size--;
				
				V temp_data = temp.data.value;
				temp = null;	
				return temp_data;
			}
			trav_prev = trav;
			trav = trav.next;
		}
		if (trav.data.key == key) {
			V temp_data = trav.data.value;
			trav_prev.next = null;
			trav = null;
			return temp_data;
		}
		
		return null;
 */
 