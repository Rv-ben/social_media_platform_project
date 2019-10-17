/**
 * represents a post made by a volunteer page
 * @author Ruben Bramasco
 * @version 1.0.0
 * @since 10/12/2019
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

    /**
     * adds register features to display
     */
    @Override
    public void displayPost() {
        super.displayPost();
        System.out.print(volunteerName + " now have " + numAttending + " attending\n" );
    }

}