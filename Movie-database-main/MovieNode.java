
import java.io.Serializable;  


public class MovieNode implements Serializable{
    private String title;
    private int releaseDate;
    private int popularityScore;
    private boolean isAvailable;
    private int value;
    private int key;
    private MovieNode next;
    private MovieNode leftId;
    private MovieNode rightId;
    private MovieNode leftDate;
    private MovieNode rightDate;
    private int IdCode;
    

    
    

    public MovieNode(String title, int releaseDate, int popularityScore, boolean isAvailable, int IdCode) {

       
        
        this.IdCode = IdCode;
        this.title = title;
        this.releaseDate = releaseDate;
        this.popularityScore = popularityScore;
        this.isAvailable = isAvailable;
        this.key = key;
    
        this.next = null;
        this.leftId = null;
        this.rightId = null;
        this.rightDate = null;
        this.leftDate = null;
        this.IdCode = IdCode;
    }   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getIdCode() {
        return IdCode;
    }
    
    public int getPopularityScore() {
        return popularityScore;
    }
    
    public void setPopularityScore(int popularityScore) {
        this.popularityScore = popularityScore;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    //Delete this?
    public int getValue(){
        return value;
    }
    //Delete this?
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public MovieNode getNext() {
        return next;
    }
    
    public void setNext(MovieNode next) {
        this.next = next;
    }   

    public MovieNode getLeftId() {
        return leftId;
    }

    public void setLeftId(MovieNode leftId) {
        this.leftId = leftId;
    }

    public MovieNode getRightId() {
        return rightId;
    }

    public void setRightId(MovieNode rightId) {
        this.rightId = rightId;
    }
    
    public MovieNode getLeftDate() {
        return leftDate;
    }

    public MovieNode getRightDate() {
        return rightDate;
    }
    
    public void setLeftDate(MovieNode leftDate) {
        
        this.leftDate = leftDate;
    }

    public void setRightDate(MovieNode rightDate) {
        this.rightDate = rightDate;
    }
    
    
}