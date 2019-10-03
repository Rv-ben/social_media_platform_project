import java.util.ArrayList;
import java.util.Date;

/**
 * Respesnts a user in the form of a Volunteering Event
 */
public class VolunteerEvent extends User{

    /**
     * Volunteering event
     */
    private Event event;

    /**
     * Contact number for volunteering event
     */
    private String phoneNumber;

    /**
     * List of registered users to event
     */
    private ArrayList<String> resgisteredVolunteers;

    /**
     * list of post with a costum message
     */
    private ArrayList<Post> messagePost;

    /**
     * volunteer post keeps track of registered users
     */
    private VolunteerPost post;

    VolunteerEvent(String userName, String name, String email, String password, String bio){
        super(userName, name, email, password, bio);
    }

    VolunteerEvent(String userName, String name, String email, String password, String bio, 
                Event event, String phoneNumber){
        super(userName, name, email, password, bio);
        this.event = event;
        this.phoneNumber = phoneNumber;
        resgisteredVolunteers = new ArrayList<String>();
        messagePost = new ArrayList<Post>();
        post = generateFirstPost();
    }

    public void setEvent(Event event){
        this.event = event;
    }

    public void setContactNum(String contactNum){
        this.phoneNumber = contactNum;
    }

    /**
     * Add a volunteer to the volunteer event
     * @param memberName
     */
    public void addNewVolunteer(String memberName){
        resgisteredVolunteers.add(memberName);
    }

    /**
     * gets event date
     * @return event date as Date Object
     */
    public Date getEventDate(){
        return event.getDate();
    }

    /**
     * gets contact number as 
     * @return contact number as String Object
     */
    public String getContactNum(){
        return phoneNumber;
    }

    /**
     * Creates an initial post
     */
    private VolunteerPost generateFirstPost(){
        return  new VolunteerPost(this.getUserName(), resgisteredVolunteers.size());
    }

    /**
     * adds a post with custom message
     * @param message String Object 
     * @param image String Object
     */
    public void post(String message, String image){
        messagePost.add(new Post(this.getUserName(), message, image));
    }

    /**
     * resgisters a person to an event
     */
    public void registerUser(String userName){
        resgisteredVolunteers.add(userName);
        post.update(resgisteredVolunteers.size());
    }


    public void displayPage(){
        System.out.println("----------------------------------------------------------------------");
        System.out.println(this.getUserName()+ " "+ event.toString());
        System.out.println("Contact Number: "+ phoneNumber);
        System.out.println("----------------------------Registered Users-------------------------");
        
        for(String i : resgisteredVolunteers){
            System.out.print(i+" ");
        }
        System.out.println("----------------------------------------------------------------------");
    }
}