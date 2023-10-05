//Cleaned
import java.io.Serializable;  
public class CustomerNode implements Serializable  {
    private String name;
    private String email;
    private String creditCardNumber;
    private MovieNode[] wishList;
    private int key;
    private CustomerNode next;
    public CustomerNode left;
	public CustomerNode right;
    private Boolean admin;


    public CustomerNode(String name, String email, String creditCardNumber, MovieNode[] wishList, int key, Boolean admin) {
        this.name = name;
        this.email = email;
        this.creditCardNumber = creditCardNumber;
        this.wishList = wishList;
        this.key = key;
        this.next = null;
        this.admin = admin;

    }

    public CustomerNode getLeft() {
        return left;
    }

    public CustomerNode getRight() {
        return right;
    }

    public void setLeft(CustomerNode newNode) {
        left = newNode;
    }

    public void setRight(CustomerNode newNode) {
        right = newNode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public MovieNode[] getWishList() {
        return wishList;
    }

    public void setWishList(MovieNode[] wishList) {
        this.wishList = wishList;
    }

    public CustomerNode getNext() {
        return next;
    }

    public void setNext(CustomerNode next) {
        this.next = next;
    }

    public int getKey() {
        return key % 10000;
    }
      public Boolean getAdminStatus() {
        return admin == true;
    }
}
