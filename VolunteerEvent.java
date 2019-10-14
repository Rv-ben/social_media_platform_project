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
    private ArrayList<Post> post;

    VolunteerEvent(String userName, String name, String email, String password, String bio){
        super(userName, name, email, password, bio);
        resgisteredVolunteers = new ArrayList<String>();
        post = new ArrayList<Post>();
        post.add(new VolunteerPost(this.getUserName(), resgisteredVolunteers.size()));
    }

    VolunteerEvent(String userName, String name, String email, String password, String bio, 
                Event event, String phoneNumber){
        super(userName, name, email, password, bio);
        this.event = event;
        this.phoneNumber = phoneNumber;
        resgisteredVolunteers = new ArrayList<String>();
        post = new ArrayList<Post>();
        post.add(new VolunteerPost(this.getUserName(), resgisteredVolunteers.size()));
    }

    public void setEvent(Event event){
        this.event = event;
        post.add(new VolunteerPost(this.getUserName(), resgisteredVolunteers.size()));
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
        VolunteerPost temp = (VolunteerPost)post.get(0);
        temp.update(resgisteredVolunteers.size());
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
     * adds a post with custom message
     * @param message String Object 
     * @param image String Object
     */
    public void post(String message, String image){
        post.add(new Post(this.getUserName(), message, image));
    }

    /**
     * resgisters a person to an event
     */
    public void registerUser(String userName){
        resgisteredVolunteers.add(userName);
        VolunteerPost poste = (VolunteerPost)post.get(0);
        poste.update(resgisteredVolunteers.size());
    }

    public ArrayList<Post> getPost(){
        return post;
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