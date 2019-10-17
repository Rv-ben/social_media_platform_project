
import java.util.ArrayList;

/**
 * Respresents an individual user
 * @author Ruben Bramasco
 * @version 1.0.0
 * @since 10/12/2019
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
    private ArrayList<Post> post;

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
     */
    Individual(String userName, String name, String email ,String password, String bio){

        super(userName, name, email, password, bio);
        post = new ArrayList<Post>();
        donatedTo = new ArrayList<String>();
        registeredEvents = new ArrayList<String>();
    }

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
        post = new ArrayList<Post>();
        donatedTo = new ArrayList<String>();
        registeredEvents = new ArrayList<String>();
    }

    /**
     * Edits banks info
     * @param bankInfo as String Object 
     */
    public void setBankInfo(String bankInfo){
        this.bankInfo = bankInfo;
    }

    /**
     * sets the users bday 
     * @param birthDay birthdate as String Object
     */
    public void setBirthDay(String birthDay){
        this.birthDay = birthDay;
    }
    
    /**
     * Adds an event to registedEvents list
     * @param eventName as String Objects
     */
    public void addRegisteredEvent(String eventName){
        String message = "I just registered to "+ eventName;
        post.add(new Post(this.getUserName(), message, ""));
        registeredEvents.add(eventName);
    }

    /**
     * Adds company name to donatedTo List
     * @param companyName
     */
    public void donate(String companyName, int donation){
        String message = "I just donated " + donation+" to "+ companyName;
        post.add(new Post(this.getUserName(), message, ""));
        donatedTo.add(companyName);
    }

    /**
     * creates a new post given a message and imageLocation
     * @param message message as String Object
     * @param image image as String Object
     */
    public void post(String message, String image){
        post.add(new Post(this.getUserName(), message, image));
    }

    /**
     * gets post list
     * @return post as ArrayList<Post>
     */
    public ArrayList<Post> getPost(){
        return post;
    }

    /**
     * gets UserName
     * @return birthday as String Object
     */
    public String getBirthDay(){
        return birthDay;
    }
    
    /**
     * gets bankInfo
     * @return bankInfo
     */
    public String getBankInfo(){
        return bankInfo;
    }

    /**
     * Displays the individual's page nicely
     */
    public void displayPage(){

        System.out.println("_________________________________________________________________________________________");
        System.out.println("|Name: "+ this.getUserName()+" | Birthday: " + birthDay +" | Bio: "+this.getBio()+"                    |");
        System.out.println("_________________________________________________________________________________________");
        System.out.println("_________________________________ Post _______________________________________________________");
        for(Post i : post)
            i.displayPost();
        System.out.println("_________________________________________________________________________________________");
        System.out.println("___________________________________DONATED TO________________________________________________");
        if(eightTeen){
            System.out.println("Donated to:" + donatedTo.size() + " companies");
            for(String i : donatedTo)
                System.out.print(i+" | ");
            System.out.println();
        }
        System.out.println("_________________________________________________________________________________________");
        System.out.println("___________________________________Registered to_______________________________________________");
        System.out.println("Registered to:" + registeredEvents.size() + " events");
        for(String i : registeredEvents)
                System.out.print(i+" | ");
                
    }
}