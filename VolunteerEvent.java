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

    private ArrayList<IndividualPost> messagePost;

    private VolunteerPost post;

    VolunteerEvent(String userName, String name, String email, String password, String bio, 
                Event event, String phoneNumber){
        super(userName, name, email, password, bio);
        this.event = event;
        this.phoneNumber = phoneNumber;
        resgisteredVolunteers = new ArrayList<String>();
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

    public void generateFirstPost(){
        String message = "NEW VOLUNTEER EVENT: "+ this.getUserName() + "Join us!!!";
    }

    public void displayPage(){
        System.out.println(event.toString());
        System.out.println("Contact Number: "+ phoneNumber);
        System.out.println("----------------------------Registered Users-------------------------");
        
        
        for(String i : resgisteredVolunteers){
            System.out.print(i+"\n");
        }
    }
}