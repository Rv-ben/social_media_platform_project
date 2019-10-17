/**
 * respresents a post made by an organization
 * @author Ruben Bramasco
 * @version 1.0.0
 * @since 10/12/2019
 */
public class OrgPost extends Post{


    /**
     * name of donar
     */
    private String userName;
    
    /**
     * amount of money donated by the individual
     */
    private int moneyDonated;

    /**
     * Constructs a new OrgPost object given OrgName, the user, and money donated
     * @param orgName
     * @param userName
     * @param moneyDonated
     */
    OrgPost(String orgName, String userName, int moneyDonated){
        super(orgName,"","");
        this.userName = userName;
        this.moneyDonated = moneyDonated;
    }
    
    /**
     * Adds donation features to the post
     */
    @Override
    public void displayPost() {
        super.displayPost();
        System.out.print(userName + " donated "+ moneyDonated+"\n");
    }
    
}