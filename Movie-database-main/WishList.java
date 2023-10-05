import java.io.Serializable;  


public class WishList implements Serializable{
	private MovieNode[] queueC;
	private int n;
	private int front;
	private int m;
	
	
	public WishList() {
		queueC = new MovieNode[20];
		n = 0;
		front = 0;
		m = 0;
		
	}
	
	public MovieNode front() {
		m = m + 1;
		return queueC[m];
		
	}

	
	public MovieNode enqueue(MovieNode node) {
		int end = (front + n) % 100; 
		queueC[end] = node; 
		n = n + 1;
		return queueC[end];
	}

	public MovieNode dequeue () {
		int temp = front;
		front = (front ) % 100;
		n = n - 1;
		return queueC[temp];
	}

	public boolean isEmpty() {
		return n == 0;
	}
	
	public void printQueue() {
		int tail = (front + n) % 100;
		System.out.println(front);
		System.out.println(tail);
		if(front <= tail) {
			for(int i = front; i < tail; i++) {
				System.out.println(queueC[i].getTitle());
				
			}
		}
		else {
			for(int i = front; i < 100; i++) {
				System.out.println(queueC[i].getTitle());
			}
			for(int i = 0; i < tail; i++) {
				System.out.println(queueC[i].getTitle());
			}
		}
	}
        //System.out.println(queueC.getWishList());
}