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
        // ArrayList<Post> feed = testIndiv.getPost();
        // for(Post i: feed){
        //     i.displayPost();
        // }

        registerToEvent(testIndiv, voltest);

        //voltest.displayPage();
        testIndiv.displayPage();
    }

    public static void donate(Individual donator, int donation ,Organization org){
        donator.donate(org.getUserName(),donation);
        org.addDonar(donator.getUserName(), donation);
    }

    public static void registerToEvent(Individual participant, VolunteerEvent event){
        event.registerUser(participant.getUserName());
        participant.addRegisteredEvent(event.getUserName());
    }
    
}