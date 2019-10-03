
import java.util.ArrayList;

/**
 * Respresents an individual user
 */
class Individual extends User{
    
    /**
     * Individual's birthday
     */
    private String birthDay;

    /**
     * Individual's bank info
     */
    private String bankInfo;

    /**
     * Individual's posts
     */
    private ArrayList<IndividualPost> post;

    /**
     * Events individual is registered to 
     */
    private ArrayList<String> registeredEvents;

    /**
     * Non-profits donated to 
     */
    private ArrayList<String> donatedTo;

    /**
     * true if 18 and over
     */
    private boolean eightTeen;

    /**
     * Constucts an indiviual
     * @param userName individual's display name as String Object
     * @param name individual's real name as String Object
     * @param email individual's email as String Object
     * @param password individual's password as String Object
     * @param bio individual's bio as String Object
     * @param birthDay individual's bio as String Object
     * @param bankInfo individual's bankInfo as String Object
     */
    
    Individual(String userName, String name, String email ,String password, String bio,String birthDay, String bankInfo){

        super(userName, name, email, password, bio);
        this.birthDay = birthDay;
        this.bankInfo = bankInfo;
        post = new ArrayList<IndividualPost>();
        donatedTo = new ArrayList<String>();
        registeredEvents = new ArrayList<String>();
    }

    /**
     * Edits banks info
     * @param bankInfo as String Object 
     */
    public void changeBankInfo(String bankInfo){

        this.bankInfo = bankInfo;

    }
    
    /**
     * Adds an event to registedEvents list
     * @param eventName as String Objects
     */
    public void addRegisteredEvent(String eventName){
        registeredEvents.add(eventName);
    }

    /**
     * Adds company name to donatedTo List
     * @param companyName
     */
    public void donate(String companyName, int donation){
        String message = "I just donated " + donation+" to "+ companyName;
        post.add(new IndividualPost(this.getUserName(), message, ""));
        donatedTo.add(companyName);
    }

    public ArrayList<IndividualPost> getPost(){
        return post;
    }
    
    /**
     * Displays the individual's page nicely
     */
    public void displayPage(){

        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Name: "+ this.getUserName()+" | Birthday: " + birthDay +" | Bio: "+this.getBio());

        for(IndividualPost i : post)
            i.displayPost();

        if(eightTeen){
            System.out.println("Donated to:" + donatedTo.size() + " companies");
            for(String i : donatedTo)
                System.out.print(i+" | ");
            System.out.println();
        }
        System.out.println("Registered to:" + donatedTo.size() + " events");
        for(String i : registeredEvents)
                System.out.print(i+" | ");
                
    }
}