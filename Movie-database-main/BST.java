// This program creates a Binary Search Treeclass with linked nodes that contains its methods
import java.io.Serializable;

public class BST implements Serializable {
	private CustomerNode root;
	
	public void createEmptyTree() {
		root = null;
	}
	
	public void delete(CustomerNode p) {
		if (root != null) {
			if (p == root) {
				root = deleteRoot(root);
			}
			else {
				delete2(root, p);
			}
		}
	}
		
	public CustomerNode deleteRoot(CustomerNode tree) {
		CustomerNode temp = tree;
		if ((tree.getLeft() == null) && (tree.getRight() == null)) {
			return null;
		}
		else if (tree.getLeft() == null) {
			tree = tree.getRight();
			temp.setRight(null);
			return tree;
		}
		else if (tree.getRight() == null) {
			tree = tree.getLeft();
			temp.setLeft(null);
			return tree;
		}
		else {
			temp = getSuccesor(tree.getRight());
			delete(temp);
			temp.setRight(tree.getRight()); 
			temp.setLeft(tree.getLeft());
			tree.setLeft(null);
			tree.setRight(null);
			return temp;
		}
	}

	public void delete2(CustomerNode tree, CustomerNode p) {
		if ((tree.getLeft() != null) && (p.getKey() < tree.getKey())) {
			if (p.getKey() == tree.getLeft().getKey()) {
				tree.setLeft(deleteRoot(tree.getLeft()));
			}
			else {
				delete2(tree.getLeft(), p);
			}
		}
		else if ((tree.getRight() != null) && (p.getKey() > tree.getKey())) {
			if (p.getKey() == tree.getRight().getKey()) {
				tree.setRight(deleteRoot(tree.getRight()));
			}
			else {
				delete2(tree.getRight(), p);
			}
			
		}
	}
	
	public CustomerNode getSuccesor(CustomerNode t) {
		if (t.getLeft() == null) {
			return t;
		}
		else {
			return getSuccesor(t.getLeft());
		}
	}
	
	public void insert(CustomerNode p) {
		if (root == null) {
			root = p;
		}
		else {
			insert2(root, p);
		}
	}
		
	public void insert2(CustomerNode t, CustomerNode p) {
		if (p.getKey() < t.getKey()) {
			if (t.getLeft() == null) {
				t.setLeft(p);
			}
			else {
				insert2(t.getLeft(), p);
			}
		}
		else {
			if (t.getRight() == null) {
				t.setRight(p);
			}
			else {
				insert2(t.getRight(), p);
			}
		}
	}
		
	public CustomerNode search(int key) {
		return searchr(root, key);
	}

	public CustomerNode searchr(CustomerNode t, int key) {
		if (t == null) {
			return null;
		}
		else if (key == t.getKey()) {
			return t;
		}
		else if (key < t.getKey()) {
			return searchr(t.getLeft(), key);
		}
		else {
			return searchr(t.getRight(), key);
		}
	}
		
	public void traverse() {
		traverser(root);
		System.out.println();
	}
		
	public void traverser(CustomerNode t) {
		if (t != null) {
			traverser(t.getLeft());
			System.out.print(t.getKey() + " ");
			traverser(t.getRight());
			}
	}
	
	public boolean isEmptyTree() {
		return root == null;
	}
		
    public void printTree() {
	    printTree2(root);
	    System.out.println();
    }

    private void printTree2(CustomerNode tree) {
	    if (tree != null) {
	        System.out.print(tree.getKey() + " ");
            if (tree.getLeft() != null) {
	            System.out.print("Left: " + tree.getLeft().getKey() + " ");
			}
            else {
            	System.out.print("Left: null ");
			}
            if (tree.getRight() != null) {
	            System.out.println("Right: " + tree.getRight().getKey() + " ");
			}
            else {
                System.out.println("Right: null ");
			}
	        printTree2(tree.getLeft());
	        printTree2(tree.getRight());
		}
	}
}