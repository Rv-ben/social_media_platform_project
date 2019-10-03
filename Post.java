import java.util.*;

/**
 * Represents a post on a social media site
 */
public class Post{
    
    /**
     * post message
     */
    private String message;

    /**
     * post image
     */
    private String image;

    /**
     * keeps track of time posted
     */
    private Date timePosted;

    /**
     * username of person posting
     */
    private String userName;

    /**
     * constructs Post Object using a message and image
     */
    public Post(String userName, String message, String image){
        this.userName = userName;
        this.message = message;
        this.image = image;
        this.timePosted = new Date();
    }

    /**
     * constucts a Post Object using a message ONLY
     */
    public Post(String message){
        this.message = message;
        this.image = null;
    }

    /**
     * constucts a Post Object with innital conditions of null
     */
    public Post(){
        this.message = null;
        this.message = null;
    }

    /**
     * displays post as string
     */
    public void displayPost(){
        System.out.println("________________________________________________________________________________________________________");
        System.out.println(this.userName+" @ "+this.getTimePosted().toString()+": "+ this.getMessage() + " "+ this.getImage());
        System.out.println("________________________________________________________________________________________________________");
    }

    /**
     * gets message
     * @return message as String Object
     */
    public String getMessage(){
        return message;
    }

    /**
     * gets image
     * @return image as String Object
     */
    public String getImage(){
        return image;
    }

    /**
     * gets Date
     * @return timePosted as Date Object
     */
    public Date getTimePosted(){
        return timePosted;
    }
}