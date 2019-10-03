/**
 * represents a post made by a volunteer page
 */
public class VolunteerPost extends Post{

    /**
     * Name of VolunteerPage
     */
    private String volunteerName;

    /**
     * Number of people attending
     */
    private int numAttending;

    VolunteerPost(String volunteerName, int numAttending){
        super("","","");
        this.volunteerName = volunteerName;
        this.numAttending = numAttending;
    }

    /**
     * updates the amount of people attending
     */
    public void update(int attending){
        this.numAttending = attending;
    }

    @Override
    public void displayPost() {
        System.out.println(volunteerName + " @ "+ this.getTimePosted() + ": "+ volunteerName + " now have " + numAttending + " attending" );
    }

}