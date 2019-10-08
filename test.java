import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


public class test{
    static ArrayList<User> users = new ArrayList<User>();
    public static void main(String [] args)throws Exception{
        
        Scanner input = new Scanner(System.in);
        Scanner file = new Scanner(new File("SaveFile.txt"));
        createUser(input);
        users.get(0).post("Hey","..////s");
        Individual t = (Individual)users.get(0);
        t.displayPage();
    }

    public static void donate(Individual donator, int donation ,Organization org){
        donator.donate(org.getUserName(),donation);
        org.addDonar(donator.getUserName(), donation);
    }

    public static void registerToEvent(Individual participant, VolunteerEvent event){
        event.registerUser(participant.getUserName());
        participant.addRegisteredEvent(event.getUserName());
    }

    public static void createUser(Scanner input)throws Exception{

        System.out.println("What kind of account do you want to make?");
        System.out.println("I)ndividual");
        System.out.println("O)rganization");
        System.out.println("V)olunteer");
        System.out.println("C)ancel");
        String choice = input.next();

        System.out.print("Enter real name: ");
        String name = input.next();
        System.out.print("Enter email: ");
        String email = input.next();
        System.out.print("Enter display name: ");
        String userName = input.next();
        System.out.print("Enter password: ");
        String password = input.next();
        System.out.print("Enter bio: ");
        String bio = input.next();

        switch(choice.charAt(0)){

            case('I'):
                Individual individ = new Individual(name,email,userName,password,bio);
                users.add(individ);
                createIndividual(individ,input);
                break;

            case('O'):
                Organization org = new Organization(name,email,userName,password,bio);
                users.add(org);
                createOrganization(org,input);
                break;

            case('V'):
                VolunteerEvent vol = new VolunteerEvent(name,email,userName,password,bio);
                users.add(vol);
                createVolunteerEvent(vol,input);
                break;


        }

    }

    public static void createIndividual(Individual person,Scanner input){
        
        System.out.print("Enter date of birth (mm/dd/yyyy): ");
        String birthDay = input.next();
        person.setBirthDay(birthDay);
        
        System.out.print("Enter bank info: ");
        String bankInfo = input.next();
        person.setBankInfo(bankInfo);
    }

    public static void createOrganization(Organization org,Scanner input){

        System.out.print("Enter mailing address: ");
        String mailingAddress = input.next();
        org.setMailingAddress(mailingAddress);

        System.out.print("Enter phone number: ");
        String phoneNumber = input.next();
        org.setPhoneNumber(phoneNumber);

        System.out.print("Enter tax-exempt number: ");
        String taxExempt = input.next();
        org.setTaxNumber(taxExempt);

        System.out.print("Enter bank information: ");
        String bankInfo = input.next();
        org.setBankInfo(bankInfo);
    }

    public static void createVolunteerEvent(VolunteerEvent event,Scanner input) throws Exception{

        System.out.print("Enter date and time of event: (mm/dd/yyyy  HH:mm )");
        String date = input.next();
        Date d = new SimpleDateFormat("MM/dd/yyyy HH::mm").parse(date);

        System.out.print("Enter location of event: ");
        String location = input.next();

        Event e = new Event(d, location);

        System.out.print("Enter contact number: ");
        String phoneNumber = input.next();

        event.setEvent(e);
        event.setContactNum(phoneNumber);

    }
    
    public static void actLikeUser(){

    }

    public static void displayAllUsers(){
        int x = 0;
        for(User i: users){
            System.out.println(x+": "+i.getUserName());
            x++;
        }
    }

    public static void individualUser(User user,Scanner input){
        System.out.println("What do you want to do?");
        System.out.println("M)ake a donation");
        System.out.println("P)ost an update");
        System.out.println("R)egister for event");
        System.out.println("C)ancel");
        char answer = input.next().charAt(0);

        switch(answer){
            case 'P':
                makePost(user, input);
            case 'M':


        }
    }

    public static int findUser(String answer){
        boolean found = false;
        int x = 0;
        while(answer != "C"){
            for(User i : users){
                if(answer == i.getUserName()){
                    found = true;
                    break;
                }
                x++;
            }
            if(found)
                return x;
        }
        return -1;
    }

    public static void makePost(User i , Scanner input) {
        System.out.print("Enter a message:");
        String message = input.next();

        System.out.print("Enter a message:");
        String image = input.next();

        i.post(message, image);
    }

    public static int makeDonation(User i, Scanner input){
        System.out.print("What organization do you want to donate too?");
        String answer = input.next();
        int index = findUser(answer);
        
        if(index == -1)
            return -1;
        
        
    }
}