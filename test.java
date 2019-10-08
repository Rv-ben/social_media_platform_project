import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;


public class test{
    static ArrayList<User> users = new ArrayList<User>();
    static ArrayList<Post> feed = new ArrayList<Post>();

    public static void main(String [] args)throws Exception{
        
        Scanner input = new Scanner(System.in);
        Scanner file = new Scanner(new File("user.txt"));
        while(file.hasNext())
            createUser(file);
        mainMenu(input);
    }

    public static void mainMenu(Scanner input)throws Exception{
        char answer = ' ';
        while (answer != 'E'){
        clearScreen();
        mainMenuText();
        System.out.println("C)reate new user");
        System.out.println("A)ct as user");
        System.out.println("D)isplay feed");
        System.out.println("E)xit");
        answer = input.next().charAt(0);

        switch(answer){
            case 'C':
                createUser(input);
                break;
            case 'A':
                actLikeUser(input);
                break;
            case 'D':
                break;
        }
        
        }
    }

    public static void createUser(Scanner input)throws Exception{
        clearScreen();
        System.out.println("What kind of account do you want to make?");
        System.out.println("I)ndividual");
        System.out.println("O)rganization");
        System.out.println("V)olunteer");
        System.out.println("C)ancel");
        String choice = input.next();
        System.out.print("Enter real name: ");
        String name = input.next();
        System.out.print("Enter display name: ");
        String userName = input.next();
        System.out.print("Enter email: ");
        String email = input.next();
        System.out.print("Enter password: ");
        String password = input.next();
        System.out.print("Enter bio: ");
        input.nextLine();
        String bio = input.nextLine();

        switch(choice.charAt(0)){
            case('I'):
                Individual individ = new Individual(name,userName,email,password,bio);
                users.add(individ);
                createIndividual(individ,input);
                break;

            case('O'):
                Organization org = new Organization(userName,name,email,password,bio);
                users.add(org);
                createOrganization(org,input);
                break;

            case('V'):
                VolunteerEvent vol = new VolunteerEvent(userName,name,email,password,bio);
                users.add(vol);
                createVolunteerEvent(vol,input);
                break;


        }

    }

    public static void createIndividual(Individual person,Scanner input){
        clearScreen();
        System.out.print("Enter date of birth (mm/dd/yyyy): ");
        String birthDay = input.next();
        person.setBirthDay(birthDay);
        
        System.out.print("Enter bank info: ");
        String bankInfo = input.next();
        person.setBankInfo(bankInfo);
    }

    public static void createOrganization(Organization org,Scanner input){
        clearScreen();
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
        clearScreen();
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
    
    public static void actLikeUser(Scanner input){
        clearScreen();
        displayAllUsers();
        System.out.println("Which user do you want to act like? (Number)");
        int x  = input.nextInt();
        if(users.get(x).getClass() == Individual.class){
            individualMenu(users.get(x), input);
        }
        else if(users.get(x).getClass() == VolunteerEvent.class){
            volunteerEventMenu(users.get(x), input);
        }
        else{
            organizationMenu(users.get(x), input);
        }
    }

    public static void displayAllUsers(){
        int x = 0;
        for(User i: users){
            System.out.println(x+": "+i.getUserName()+" "+i.getClass());
            x++;
        }
    }

    public static void individualMenu(User user,Scanner input){
        char answer = ' ';
        while(answer != 'E'){
            clearScreen();
            System.out.println("What do you want to do?");
            System.out.println("P)ost an update");
            System.out.println("M)ake a donation");
            System.out.println("R)egister for event");
            System.out.println("E)xit");
            answer = input.next().charAt(0);

            switch(answer){
                case 'E': break;
                case 'P':
                    makePost(user, input);
                    break;
                case 'M':
                    makeDonation(user, input);
                    break;
                case 'R':
                    register(user,input);
                    break;

            }
        }
    }

    public static void organizationMenu(User user, Scanner input) {
        char answer = ' ';
        while(answer != 'E'){
            clearScreen();
            System.out.println("What do you want to do?");
            System.out.println("P)ost an update");
            System.out.println("E)xit");
            answer = input.next().charAt(0);

            switch(answer){
                case 'E': break;
                case 'P':
                    makePost(user, input);
                    break;
            }
        }
    }

    public static void volunteerEventMenu(User user, Scanner input) {
        char answer = ' ';
        while(answer != 'E'){
            clearScreen();
            System.out.println("What do you want to do?");
            System.out.println("P)ost an update");
            System.out.println("M)odify event day/time/location");
            System.out.println("E)xit");
            answer = input.next().charAt(0);

            switch(answer){
                case 'E': break;
                case 'P':
                    makePost(user, input);
                    break;
                case 'M':
                    modifyEvent(user, input);
                    break;
            }
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
        clearScreen();
        input.nextLine();
        System.out.print("Enter a message:");
        String message = input.nextLine();

        System.out.print("Enter a image Location:");
        String image = input.next();

        i.post(message, image);
    }

    public static int makeDonation(User i, Scanner input){
        clearScreen();
        System.out.print("What organization do you want to donate to?");
        String answer = input.next();
        int index = findUser(answer);
        
        if(index == -1)
            return -1;
        
        System.out.print("Enter the amount (int):");
        int donation = input.nextInt();
        
        Individual user = (Individual)i;
        Organization org = (Organization)users.get(index);
        
        org.addDonar(user.getUserName(), donation);
        user.donate(answer, donation);

        return 1;
        
    }

    public static int register(User user, Scanner input) {
        clearScreen();
        System.out.print("What volunteer event do you want to register to?");
        for(User i: users){
            if(i.getClass() == VolunteerEvent.class)
                System.out.println(i.getUserName());
        }
        String answer = input.next();
        int index = findUser(answer);
        
        if(index == -1)
            return -1;
        
        Individual indiv = (Individual)user;
        VolunteerEvent vol = (VolunteerEvent)users.get(index);

        vol.addNewVolunteer(user.getUserName());
        indiv.addRegisteredEvent(answer);

        return 1;
    }

    public static int modifyEvent(User i,Scanner input){
        clearScreen();
    
        try{
            System.out.print("Enter date and time of event: (mm/dd/yyyy  HH:mm )");
            String date = input.next();
            Date d = new SimpleDateFormat("MM/dd/yyyy HH::mm").parse(date);
            System.out.print("Enter location of event: ");
            String location = input.next();

            Event e = new Event(d, location);

            VolunteerEvent event = (VolunteerEvent)i;
            event.setEvent(e);

        }catch(Exception x){
            return -1;
        }
        return 1;
    }

    public static void displayFeed(){
        clearScreen();
        System.out.println("CURRENT FEED AS OF"+ new Date().toString());
        for(Post i :feed)
            i.displayPost();
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");
    }  
    public static void mainMenuText(){
        System.out.println("  __  __       _         __  __                  ");
        System.out.println(" |  \\/  |     (_)       |  \\/  |                 ");
        System.out.println(" | \\  / | __ _ _ _ __   | \\  / | ___ _ __  _   _ ");
        System.out.println(" | |\\/| |/ _` | | '_ \\  | |\\/| |/ _ \\ '_ \\| | | |");
        System.out.println(" | |  | | (_| | | | | | | |  | |  __/ | | | |_| |");
        System.out.println(" |_|  |_|\\__,_|_|_| |_| |_|  |_|\\___|_| |_|\\__,_|");
        System.out.println("                                                   ");
    }

}