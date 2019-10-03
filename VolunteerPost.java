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

    VolunteerPost(String volunteerName, int numAttending, String message, String image){
        super(message, image);
        this.volunteerName = volunteerName;
        this.numAttending = numAttending;
    }

    @Override
    public void displayPost() {
        System.out.println(volunteerName + " @ "+ this.getTimePosted() + ": "+ volunteerName + " now have " + numAttending + " attending" );
    }

}