import java.util.ArrayList;

/**
 * Represents a user in the form of an oganization
 * @author Ruben Bramasco
 * @version 1.0.0
 * @since 10/12/2019
 */
public class Organization extends User{

    /**
     * Organizations mailing address
     */
    private String mailingAddress;

    /**
     * Organizations phone number
     */
    private String phoneNumber;

    /**
     * Organizations tax number
     */
    private String taxNumber;

    /**
     * Organizations banking information
     */
    private String bankInfo;

    /**
     * Amount of money raised 
     */
    private int money;

    /**
     * List of individuals names that donated
     */
    private ArrayList<String> donationList;

    /**
     * List of post with costum message
     */
    private ArrayList<Post> post;

    /**
     * Constucts a new Organization given basic User Info
     * @param userName  username as String Object 
     * @param name name as String Object 
     * @param email email as String Object
     * @param password password as String Object
     * @param bio bio as String Object
     */
    Organization(String userName, String name,String email, String password, String bio){
        super(userName, name, email, password, bio);
        donationList = new ArrayList<String>();
        post = new ArrayList<Post>();
        money = 0;
    }

    /**
     * Constucts a new Organization given basic User Info
     * @param userName  username as String Object 
     * @param name name as String Object 
     * @param email email as String Object
     * @param password password as String Object
     * @param bio bio as String Object
     * @param mailingAddresss mailingAddress as String Object
     * @param phoneNumber phoneNumber as String Object
     * @param taxNumber taxNumber as String Object
     * @param bankInfo bankInfo as String Object
     */
    Organization(String userName, String name,String email, String password, String bio, String mailingAddress,
                    String phoneNumber, String taxNumber, String bankInfo){

        super(userName, name, email, password, bio);
        this.mailingAddress = mailingAddress;
        this.phoneNumber = phoneNumber;
        this.taxNumber = taxNumber;
        this.bankInfo = bankInfo;
        donationList = new ArrayList<String>();
        post = new ArrayList<Post>();
        money = 0;
    }

    /**
     * Sets mailing address
     * @param mailingAddress as String Object
     */
    public void setMailingAddress(String mailingAddress){
        this.mailingAddress = mailingAddress;
    }

    /**
     * sets Phone Number 
     * @param phoneNumber as String Object
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * sets taxNumber
     * @param taxNumber as String Object
     */
    public void setTaxNumber(String taxNumber){
        this.taxNumber = taxNumber;
    }

    /**
     * sets bank info 
     * @param bankInfo as String Object
     */
    public void setBankInfo(String bankInfo){
        this.bankInfo = bankInfo;
    }

    /**
     * gets organization's mailing address
     * @return mailing address 
     */
    public String getMailingAddress(){
        return mailingAddress;
    }

    /**
     * gets phone number
     * @return phone number as String Object 
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * gets tax number
     * @return as String Object
     */
    public String getTaxNumber(){
        return taxNumber;
    }

    /**
     * gets bankInfo
     * @return as String Object
     */
    public String getBankInfo(){
        return bankInfo;
    }

    /**
     * gets List of donars
     * @return list of donars as ArrayList<String> 
     */
    public ArrayList<String> getDonationList(){
        return donationList;
    }

    /**
     * adds a new donar
     * @param member  new donar name as String Objectt
     * @param donation amount of donation in dollars as Int
     */
    public void addDonar(String member, int donation){
        donationList.add(member);
        money += donation;
        addDonationPost(member, donation);
    }

    /**
     * adds a new donation post
     * @param userName username of donar as String Object 
     * @param donation amount of donation in dollars as Int
     */
    private void addDonationPost(String userName, int donation ){
        post.add(new OrgPost(this.getUserName(), userName, donation));
    }

    /**
     * post a message with message and image Location
     */
    public void post(String message, String image){
        post.add(new Post(this.getUserName(),message,image));
    }

    /**
     * gets list of post
     * @return list of post as ArrayList<Post>
     */
    public ArrayList<Post> getPost(){
        return post;
    }

    /**
     * Displays the org's page
     */
    public void displayPage(){
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Name: "+ this.getUserName()+" | Bio: "+this.getBio());
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Money Raised: "+ money);

        System.out.println("-----------------------Post------------------------------------------");
        for(Post i : post)
            i.displayPost();

        System.out.println("-----------------------Supporters------------------------------------");
        for(String i:donationList){
            System.out.print(i+" ");
        }
    }
}