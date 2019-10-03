import java.util.Date;
import java.util.ArrayList;

public class test {
    public static void main(String [] args){
        Organization testOrg = new Organization("apple", "name", "email", "password", "bio", "mailingAddress", "phoneNumber"
            , "taxNumber", "bankInfo");
        
        Individual testIndiv = new Individual("Ruben", "name", "email", "password", "bio", "birthDay", "bankInfo");

        Date d = new Date(2019, 8, 23);
        Event e = new Event(d, "Place");
        VolunteerEvent voltest = new VolunteerEvent("BeachClean up", "fs", "email", "password", "bio", e, "phoneNumber");

        donate(testIndiv, 10 , testOrg);
        ArrayList<IndividualPost> feed = testIndiv.getPost();
        for( IndividualPost i: feed){
            i.displayPost();
        }
    }

    public static void donate(Individual donator, int donation ,Organization org){
        donator.donate(org.getUserName(),donation);
        org.addDonar(donator.getUserName(), donation);
    }
}