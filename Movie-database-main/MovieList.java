//movielist when ordering by date
import java.io.Serializable;  


public class MovieList implements Serializable {
	
	private int n;
	private MovieNode[] MovieList;
	
	
	public MovieList(){
		MovieList = new MovieNode[255];
		n = 0;
		}
		
		
	public MovieNode findMin() {
		return MovieList[0];
		}
		
	/*public void insert(Node x) {
		int parent = (n-1)/2;

		if (x.getKey()> heap[parent].getKey()) {
			heap[n] = x;
			n +=1;
			}
		else{
			
			heap[n] = x;
			n +=1;
			while(heap[n-1].getKey() < heap[parent].getKey()){
				parent = (n-1)/2;
				swap(n-1, parent);
				n = parent;
				}
			}
		}

	*/	
	
	public void insert(MovieNode x) {
			MovieList[n] = x;
			n += 1;
		
			int i = n-1;
			int parent = (i-1)/2;
			

			while( i > 0 && MovieList[i].getReleaseDate() < MovieList[parent].getReleaseDate()){
				swap(i, parent);
				i = parent;
				parent = (i-1)/2;
	
				}
		}
	public MovieNode deleteMin() {
		if (n == 0) {
			return null;
			}
		MovieNode minNode = MovieList[0];
		MovieList[0] = MovieList[n-1];
		MovieList[n-1] = null;
		n --;
		int i = 0;
			
		while (i < n) {
			int right = 2*i + 2;
			int left = 2*i + 1;
			
			int min = i;
			
			if (left < n && MovieList[left].getReleaseDate()< MovieList[min].getReleaseDate()) {
				min = left;
				}
			
			
			if (right < n && MovieList[right].getReleaseDate() < MovieList[min].getReleaseDate()) {
				min = right;
				}
				
			if (min != i) {
				swap(i, min);
				i = min;
				}
				
			else {
				break;
				}
			}
				return minNode;
			}
		
	
	public boolean isEmpty() {
		return n == 0;
		
		}
		
	public void printMovieList() {
		
		for(int i = 0; i < n; i++){

		    System.out.print(MovieList[i].getReleaseDate() + " ");
			 
			System.out.print(MovieList[i].getTitle() + " ");
			System.out.print(MovieList[i].getPopularityScore() + " ");
			
			System.out.print(MovieList[i].getTitle() + " ");
			System.out.print(MovieList[i].getIdCode() + " ");
			
		
			
		System.out.println("");
		}
		}
	
	public void swap(int i, int j) {
		MovieNode temp = MovieList[i];
		MovieList[i] = MovieList[j];
		MovieList[j] = temp;
		
		}
		
	
	}