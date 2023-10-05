//movie list heap ordering by popularity score

import java.io.Serializable;  


public class MovieListP implements Serializable {
	
	private int n;
	private MovieNode[] MovieListP;
	
	
	public MovieListP(){
		MovieListP = new MovieNode[255];
		n = 0;
		}
		
		
	public MovieNode findMin() {
		return MovieListP[0];
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
			MovieListP[n] = x;
			n += 1;
		
			int i = n-1;
			int parent = (i-1)/2;
			

			while( i > 0 && MovieListP[i].getPopularityScore() < MovieListP[parent].getPopularityScore()){
				swap(i, parent);
				i = parent;
				parent = (i-1)/2;
	
				}
		}
	public MovieNode deleteMin() {
		if (n == 0) {
			return null;
			}
		MovieNode minNode = MovieListP[0];
		MovieListP[0] = MovieListP[n-1];
		MovieListP[n-1] = null;
		n --;
		int i = 0;
			
		while (i < n) {
			int right = 2*i + 2;
			int left = 2*i + 1;
			
			int min = i;
			
			if (left < n && MovieListP[left].getReleaseDate()< MovieListP[min].getReleaseDate()) {
				min = left;
				}
			
			
			if (right < n && MovieListP[right].getReleaseDate() < MovieListP[min].getReleaseDate()) {
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

		    
			 
			
			System.out.print(MovieListP[i].getPopularityScore() + " ");
            System.out.print(MovieListP[i].getTitle() + " ");
			System.out.print(MovieListP[i].getReleaseDate() + " ");
			System.out.print(MovieListP[i].getTitle() + " ");
			System.out.print(MovieListP[i].getIdCode() + " ");
			
		
			
		System.out.println("");
		}
		}
	
	public void swap(int i, int j) {
		MovieNode temp = MovieListP[i];
		MovieListP[i] = MovieListP[j];
		MovieListP[j] = temp;
		
		}
		
	
	}