package ds_java;

@SuppressWarnings("unchecked")
public class DynArray <T> {
	
	private T [] arr;
	private int capacity = 0;
	public int len = 0;
	
	
	public DynArray() { this(16); }
	
	public DynArray(int capacity) {
		if (capacity < 0 ) System.out.println("illegal capacity");
		this.capacity = capacity;
		arr = (T[]) new Object[this.capacity];	
	}
	
	public int size() { return len; }
	public boolean isEmpty() { return len == 0; }
	public void set(int index, T value) { arr[index] = value; } 
	public T get(int index) { return arr[index]; }
	
	public int getIndex(T obj) { 
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == obj) 
				{return i;} 
			
		}
		return -1;
	}
	
	public T getLast() {return arr[len-1];}
	
	public void clear() {
		for (int i = 0; i < len; i ++) {
			arr[i] = null;
			len = 0;
		}
	}
	public void add(T elem) {
		if (len + 1 > capacity) {
			if (capacity == 0) {
				capacity += 1;
			}
			else {
				capacity *= 2;
			}
			T[] newarr = (T[]) new Object[capacity];
			for (int i = 0; i < len; i++) {
				newarr[i] = arr[i];
			}
			arr = newarr;		
		}
		arr[len++] = elem;
	}
	
	public T removeAt(int index) {
		T temp = arr[index];
		if (index == len - 1) {arr[index] = null; return temp;}
		else {
			T[] newarr = (T[]) new Object[len-1];
			for (int i = 0, j = 0; i < len; i++, j++) {
				if (i == index) {
					j --;
				}
				else {
					newarr[j] = arr[i];
				}
			}
			arr = newarr;
			len -= 1;
			return temp;
		}
	}
	
	public void remove(T elem) {
		for (int i = 0; i < len; i ++) {
			if (arr[i] == elem) {
				removeAt(i);
			}
		}
	}
	
	public int indexOf(T elem) {
		for (int i = 0; i < len; i ++) {
			if (arr[i] == elem) return i;
		}
		return -1;
	}
	
	public boolean contains(T elem) {
		return indexOf(elem) != 1;
	}
	
	public void showArr() {
		for (int i = 0; i < len; i ++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
	}
	
}






