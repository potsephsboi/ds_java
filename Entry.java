package ds_java;

public class Entry<K, V> {
	K key; V value;
	int hash;
	
	public Entry(K key, V value){
		this.key = key;
		this.value = value;
		this.hash = hashCode();
	}
	
	public boolean equals(Entry<K, V> other) {
	    if (hash != other.hash) return false;
	    return key.equals(other.key);
	  }
}
