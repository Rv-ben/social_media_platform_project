/**
 * respresents a post made by an organization
 */
public class OrgPost extends Post{

    /**
     * name of org posting
     */
    private String orgName;

    /**
     * name of donar
     */
    private String userName;
    
    /**
     * amount of money donated by the individual
     */
    private int moneyDonated;

    OrgPost(String orgName, String userName, int moneyDonated){
        super("","","");
        this.orgName = orgName;
        this.userName = userName;
        this.moneyDonated = moneyDonated;
    }
    
    
    @Override
    public void displayPost() {
        System.out.println(orgName+" @ "+ this.getTimePosted().toString() + ":" + userName + " donated "+ moneyDonated + " "+this.getImage());
    }
    
}