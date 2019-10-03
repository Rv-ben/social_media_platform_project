import java.util.ArrayList;

/**
 * Represents a user in the form of an oganization
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
     * List of all donation post
     */
    private ArrayList<OrgPost> donationPost;

    /**
     * List of post with costum message
     */
    private ArrayList<Post> messagePost;

    Organization(String userName, String name,String email, String password, String bio){
        super(userName, name, email, password, bio);
        }

    Organization(String userName, String name,String email, String password, String bio, String mailingAddress,
                    String phoneNumber, String taxNumber, String bankInfo){

        super(userName, name, email, password, bio);
        this.mailingAddress = mailingAddress;
        this.phoneNumber = phoneNumber;
        this.taxNumber = taxNumber;
        this.bankInfo = bankInfo;
        donationList = new ArrayList<String>();
        donationPost = new ArrayList<OrgPost>();
        messagePost = new ArrayList<Post>();
        money = 0;
    }

    public void setMailingAddress(String mailingAddress){
        this.mailingAddress = mailingAddress;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setTaxNumber(String taxNumber){
        this.taxNumber = taxNumber;
    }

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

    public String getTaxNumber(){
        return taxNumber;
    }

    public String getBankInfo(){
        return bankInfo;
    }

    public ArrayList<String> getDonationList(){
        return donationList;
    }

    public void addDonar(String member, int donation){
        donationList.add(member);
        money += donation;
        addDonationPost(new OrgPost(this.getUserName(), member, donation));
    }

    private void addDonationPost(OrgPost newPost){
        donationPost.add(newPost);
    }

    public void addMessagePost(Post newPost){
        messagePost.add(newPost);
    }

    public void displayPage(){
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Name: "+ this.getUserName()+" | Bio: "+this.getBio());

        System.out.println("Money Raised: "+ money);

        System.out.println("-----------------------Post------------------------------------------");
        for(Post i : messagePost)
            i.displayPost();
        
        for(OrgPost i : donationPost)
            i.displayPost();

        System.out.println("-----------------------Supporters------------------------------------");
        for(String i:donationList){
            System.out.print(i+" ");
        }
    }
}