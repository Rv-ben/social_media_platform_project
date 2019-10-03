

/**
 * Respesents a post by an indiviual
 */
public class IndividualPost extends Post{

    /**
     * User name of person posting
     */
    private String individualPoster;

    /**
     * Constucts a post of an individual
     * @param userName user name of person posting as String Object
     * @param message body of post as String Object
     * @param image attached image to post as String Object
     */
    public IndividualPost(String userName,String message, String image){
        super(message, image);
        this.individualPoster = userName;
    }

    /**
     * displays post as string
     */
    @Override
    public void displayPost(){
        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println(this.individualPoster+" @ "+this.getTimePosted().toString()+": "+ this.getMessage() + " "+ this.getImage());
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }


}