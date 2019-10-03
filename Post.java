import java.util.*;

/**
 * Represents a post on a social media site
 */
public abstract class Post{
    
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
     * constructs Post Object using a message and image
     */
    public Post(String message, String image){
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

    public abstract void displayPost();

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