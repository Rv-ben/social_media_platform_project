/**
 * respresents a post made by an organization
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

    OrgPost(String orgName, String userName, int moneyDonated){
        super(orgName,"","");
        this.userName = userName;
        this.moneyDonated = moneyDonated;
    }
    
    @Override
    public void displayPost() {
        super.displayPost();
        System.out.print(userName + " donated "+ moneyDonated+"\n");
    }
    
}