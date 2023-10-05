//AVL Tree for admins searching by release date
import java.io.Serializable;

public class DateBST implements Serializable {
	private MovieNode root;
	
	public void createEmptyTree() {
		root = null;
	}
	
	public void delete(MovieNode p) {
		if (root != null) {
			if (p == root) {
				root = deleteRoot(root);
			}
			else {
				delete2(root, p);
			}
		}
	}
		
	public MovieNode deleteRoot(MovieNode tree) {
		MovieNode temp = tree;
		if ((tree.getLeftDate() == null) && (tree.getRightDate() == null)) {
			return null;
		}
		else if (tree.getLeftDate() == null) {
			tree = tree.getRightDate();
			temp.setRightDate(null);
			return tree;
		}
		else if (tree.getRightDate() == null) {
			tree = tree.getLeftDate();
			temp.setLeftDate(null);
			return tree;
		}
		else {
			temp = getSuccesor(tree.getRightDate());
			delete(temp);
			temp.setRightDate(tree.getRightDate()); 
			temp.setLeftDate(tree.getLeftDate());
			tree.setLeftDate(null);
			tree.setRightDate(null);
			return temp;
		}
	}

	public void delete2(MovieNode tree, MovieNode p) {
		//if (tree.getLeft()){
			if (p.getReleaseDate() < tree.getReleaseDate()) {
				if (p.getReleaseDate() == tree.getLeftDate().getReleaseDate()) {
					tree.setLeftDate(deleteRoot(tree.getLeftDate()));
				} 
				else {
					delete2(tree.getLeftDate(), p);
				}
			}
		//else if (tree.getReleaseDate()) {
		 		if(p.getReleaseDate() > tree.getReleaseDate()) {
					if (p.getReleaseDate() == tree.getRightDate().getReleaseDate()) {
						tree.setRightDate(deleteRoot(tree.getRightDate()));
					} 
					else {
						delete2(tree.getRightDate(), p);
					}
				}
		}

	public MovieNode getSuccesor(MovieNode t) {
		if (t.getLeftDate() == null) {
			return t;
		}
		else {
			return getSuccesor(t.getLeftDate());
		}
	}
		
	public void insert(MovieNode p) {
		if (root == null) {
			root = p;
		}
		else {
			insert2(root, p);
		}
	}
		
	public void insert2(MovieNode t, MovieNode p) {
		if (p.getReleaseDate() < t.getReleaseDate()) {
			if (t.getLeftDate() == null) {
				t.setLeftDate(p);
			}
			else {
				insert2(t.getLeftDate(), p);
			}
		}
		else {
			if (t.getRightDate() == null) {
				t.setRightDate(p);
			}
			else {
				insert2(t.getRightDate(), p);
			}
		}
	}
		
	public MovieNode search(int key) {
		return searchr(root, key);
	}
		
	public MovieNode searchr(MovieNode t, int key) {
		if (t == null) {
			return null;
		}
		else if (key == t.getReleaseDate()) {
			return t;
		}
		else if (key < t.getReleaseDate()) {
			return searchr(t.getLeftDate(), key);
		}
		else {
			return searchr(t.getRightDate(), key);
		}
	}
		
	public void traverse() {
		traverser(root);
		System.out.println();
	}
		
	public void traverser(MovieNode t) {
		if (t != null) {
			traverser(t.getLeftDate());
			System.out.print(t.getReleaseDate() + " ");
			traverser(t.getRightDate());
		}
	}
	
	public boolean isEmptyTree() {
		return root == null;
	}
		
    public void printTree() {
	    printTree2(root);
	    System.out.println();
    }
	
    private void printTree2(MovieNode tree) {
	    if (tree != null) {
	        System.out.print(tree.getReleaseDate() + " ");
            if (tree.getLeftDate() != null) {
	            //System.out.print("Left: " + tree.getLeftDate().getReleaseDate() + " ");
			}
            else {
                //System.out.print("Left");
			}
            if (tree.getRightDate() != null) {
	            //System.out.println("Right: " + tree.getRightDate().getReleaseDate() + " ");
			}
            else {
                //System.out.println("Right ");
			}

			System.out.println(tree.getReleaseDate() + " ");
			System.out.println();
			printTree2(tree.getLeftDate());
			System.out.println();
	        printTree2(tree.getRightDate());
	    }
	}
}