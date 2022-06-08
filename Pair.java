package ds_java;

public class Pair <T1, T2> {
	T1 p1;
	T2 p2;
	public Pair(T1 p1, T2 p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public T1 first() {
		return p1;
	}
	
	public T2 second() {
		return p2;
	}
	
}
