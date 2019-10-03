import java.text.SimpleDateFormat;
import java.util.*;


public class test {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Individual> individuals = new ArrayList<Individual>();
    static ArrayList<Organization> organizations = new ArrayList<Organization>();
    static ArrayList<VolunteerEvent> volunteerEvents = new ArrayList<VolunteerEvent>();

    public static void main(String [] args){

    }

    public static void donate(Individual donator, int donation ,Organization org){
        donator.donate(org.getUserName(),donation);
        org.addDonar(donator.getUserName(), donation);
    }

    public static void registerToEvent(Individual participant, VolunteerEvent event){
        event.registerUser(participant.getUserName());
        participant.addRegisteredEvent(event.getUserName());
    }

    public static void createUser()throws Exception{

        System.out.println("What kind of account do you want to make?");
        System.out.println("I)ndividual");
        System.out.println("O)rganization");
        System.out.println("V)olunteer");
        System.out.println("C)ancel");
        String choice = input.next();

        System.out.print("Enter real name: ");
        String name = input.next();
        System.out.println("Enter email: ");
        String email = input.next();
        System.out.println("Enter display name: ");
        String userName = input.next();
        System.out.println("Enter password: ");
        String password = input.next();
        System.out.println("Enter bio: ");
        String bio = input.next();

        switch(choice.charAt(0)){

            case('I'):
                individuals.add(new Individual(name,email,userName,password,bio));
                createIndividual(individuals.get(individuals.size()-1));
                break;

            case('O'):
                organizations.add(new Organization(name,email,userName,password,bio));
                createOrganization(organizations.get(organizations.size()-1));
                break;

            case('V'):
                volunteerEvents.add(new VolunteerEvent(name,email,userName,password,bio));
                createVolunteerEvent(volunteerEvents.get(volunteerEvents.size()-1));
                break;


        }

    }

    public static void createIndividual(Individual person){
        
        System.out.print("Enter date of birth (mm/dd/yyyy): ");
        String birthDay = input.next();
        person.setBirthDay(birthDay);
        
        System.out.print("Enter bank info: ");
        String bankInfo = input.next();
        person.setBankInfo(bankInfo);
    }

    public static void createOrganization(Organization org){

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

    public static void createVolunteerEvent(VolunteerEvent event) throws Exception{

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
    
}