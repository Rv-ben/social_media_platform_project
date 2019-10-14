import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Period;
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
            answer = input.next().charAt(0);

            switch(answer){
                case 'C':
                    createUser(input);
                    break;
                case 'A':
                    actLikeUser(input);
                    break;
                case 'D':
                    displayFeed();
                    break;
            }
        
        }
    }

    public static int createUser(Scanner input){
        clearScreen();
        createNewUserText();
        System.out.println("What kind of account do you want to make?");
        System.out.println("I)ndividual");
        System.out.println("O)rganization");
        System.out.println("V)olunteer");
        System.out.println("C)ancel");
        String choice = input.next();
        if(choice.compareTo("C") == 0) return 0;
        input.nextLine();
        System.out.print("Enter real name: ");
        String name = input.nextLine();
        System.out.print("Enter display name: ");
        String userName = input.nextLine();
        System.out.print("Enter email: ");
        String email = input.nextLine();
        System.out.print("Enter password: ");
        String password = input.nextLine();
        System.out.print("Enter bio: ");
        String bio = input.nextLine();

        switch(choice.charAt(0)){
            case('I'):
                Individual individ = new Individual(name,userName,email,password,bio);
                users.add(individ);
                try{
                createIndividual(individ,input);
                }catch(Exception s){
                    System.out.println("Could not understand date input");
                }
                keyInput("Individual Created");
                break;

            case('O'):
                Organization org = new Organization(userName,name,email,password,bio);
                users.add(org);
                createOrganization(org,input);
                keyInput("Organization Created");
                break;

            case('V'):
                VolunteerEvent vol = new VolunteerEvent(userName,name,email,password,bio);
                users.add(vol);
                try{
                createVolunteerEvent(vol,input);
                }catch(Exception s){
                    System.out.println(s);
                }
                keyInput("Volunteer Event Created");
                break;


        }
        return 1;
    }

    public static void createIndividual(Individual person,Scanner input)throws Exception{
        clearScreen();
        System.out.print("Enter date of birth (mm/dd/yyyy): ");
        String birthDay = input.next();
        person.setBirthDay(birthDay);

        Date userBday = new SimpleDateFormat("MM/dd/yyyy").parse(birthDay);

        Date currentDate = new Date();
        

        if( (currentDate.getYear() - userBday.getYear()) >= 18){
            System.out.print("Enter bank info: ");
            String bankInfo = input.next();
            person.setBankInfo(bankInfo);
        }
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

    public static void createVolunteerEvent(VolunteerEvent event,Scanner input)throws Exception{
        clearScreen();
        System.out.print("Enter date and time of event: (mm/dd/yyyy HH::mm )");
        String date = input.nextLine();
        Date d = new SimpleDateFormat("MM/dd/yyyyHH::mm").parse(date);

        System.out.print("Enter location of event: ");
        String location = input.nextLine();

        Event e = new Event(d, location);

        System.out.print("Enter contact number: ");
        String phoneNumber = input.nextLine();

        event.setEvent(e);
        event.setContactNum(phoneNumber);

    }
    
    public static int actLikeUser(Scanner input){
        clearScreen();
        ActAsUserText();
        displayAllUsers();
        System.out.println("Which user do you want to act like? (Number), enter 0 to cancel");
        int x  = input.nextInt() -1;
        if(x ==-1) 
            return 0;
        if(users.get(x).getClass() == Individual.class){
            individualMenu(users.get(x), input);
        }
        else if(users.get(x).getClass() == VolunteerEvent.class){
            volunteerEventMenu(users.get(x), input);
        }
        else{
            organizationMenu(users.get(x), input);
        }
        return 1;
    }

    public static void displayAllUsers(){
        int x = 1;
        for(User i: users){
            System.out.println(x+": "+i.getUserName()+" "+i.getClass());
            x++;
        }
    }

    public static void individualMenu(User user,Scanner input){
        char answer = ' ';
        while(answer != 'E'){
            clearScreen();
            individualMenuText();
            answer = input.next().charAt(0);

            switch(answer){
                case 'E': break;
                case 'P':
                    makePost(user, input);
                    keyInput("Press Enter To Continue..");
                    break;
                case 'M':
                    makeDonation(user, input);
                    keyInput("Press Enter To Continue..");
                    break;
                case 'R':
                    register(user,input);
                    keyInput("Press Enter To Continue..");
                    break;
                case 'D':
                    Individual temp = (Individual)user;
                    temp.displayPage();
                    keyInput("Press Enter To Continue..");
                    break;
            }
        }
    }

    public static void organizationMenu(User user, Scanner input) {
        char answer = ' ';
        while(answer != 'E'){
            clearScreen();
            individualMenuText();
            answer = input.next().charAt(0);

            switch(answer){
                case 'E': break;
                case 'P':
                    makePost(user, input);
                    keyInput("Press Enter To Continue..");
                    break;
            }
        }
    }

    public static void volunteerEventMenu(User user, Scanner input) {
        char answer = ' ';
        while(answer != 'E'){
            clearScreen();
            volunteerEventMenuText();
            answer = input.next().charAt(0);

            switch(answer){
                case 'E': break;
                case 'P':
                    makePost(user, input);
                    keyInput("Press Enter To Continue..");
                    break;
                case 'M':
                    try{
                    modifyEvent(user, input);
                    keyInput("Press Enter To Continue..");
                    }catch(Exception e){
                        System.out.println("Nothing changed");
                    }
                    break;
            }
        }
    }

    public static int findUser(String answer){
        boolean found = false;
        int x = 0;
        if(answer != "C"){
            for(User i : users){
                if(answer.compareTo(i.getUserName()) == 0 ){
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
        makeAPostText();
        input.nextLine();
        System.out.print("Enter a message:");
        String message = input.nextLine();

        System.out.print("Enter a image Location:");
        String image = input.next();

        i.post(message, image);
    }

    public static int makeDonation(User user, Scanner input){
        clearScreen();
        donateText();
        System.out.print("What organization do you want to donate to?");
        System.out.println("------------------------------------------------");
        for(User i: users){
            if(i.getClass() == Organization.class)
                System.out.println(i.getUserName());
        }
        String answer = input.next();
        int index = findUser(answer);
        
        if(index == -1)
            return -1;
        
        System.out.print("Enter the amount (int):");
        int donation = input.nextInt();
        
        Individual indiv = (Individual)user;
        Organization org = (Organization)users.get(index);
        
        org.addDonar(user.getUserName(), donation);
        indiv.donate(answer, donation);

        return 1;
        
    }

    public static int register(User user, Scanner input) {
        clearScreen();
        registerText();
        System.out.println("What volunteer event do you want to register to?");
        System.out.println("------------------------------------------------");
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

    public static int modifyEvent(User i,Scanner input)throws Exception{
        clearScreen();
    
            System.out.print("Enter new date and time of event: (mm/dd/yyyy  HH:mm )");
            String userInput = input.next();

            if(userInput == "\n")
                return -1;
                
            Date eventDate = new SimpleDateFormat("MM/dd/yyyy HH::mm").parse(userInput);

            System.out.print("Enter location of event: ");
            String location = input.next();

            Event e = new Event(eventDate, location);

            VolunteerEvent event = (VolunteerEvent)i;
            event.setEvent(e);

        return 1;
    }

    public static void displayFeed(){
        clearScreen();
        feed.clear();
        updateFeed();
        feedText();
        System.out.println("CURRENT FEED AS OF"+ new Date().toString());
        System.out.println("------------------------------------");
        for(Post i :feed){
            i.displayPost();
            System.out.println("------------------------------------");
        }
        keyInput("Press Enter to continue");
    }

    public static void updateFeed(){
        if(users.size() != 0){
            for(User i: users){
                if(i.getClass() != VolunteerEvent.class){
                    for(Post j: i.getPost())
                    feed.add(j);
                }
                else{
                    VolunteerEvent temp = (VolunteerEvent)i;
                    Date eventDate = temp.getEventDate();
                    if(eventDate.compareTo(new Date()) > 0 ){
                        for(Post j: i.getPost())
                        feed.add(j);
                    }
                    else
                        temp.getPost().clear();
                }
            }
            Collections.sort(feed);
        }
    }

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");
    } 
    public static void keyInput(String message) {
        try{
            System.out.println(message);
            System.in.read();
        }catch(Exception s){}
    }
    public static void mainMenuText(){
        System.out.println(" ___  _____ ______   ________  ________  ________ _________   ");
        System.out.println("|\\  \\|\\   _ \\  _   \\|\\   __  \\|\\   __  \\|\\   ____\\\\___   ___\\ ");
        System.out.println("\\ \\  \\ \\  \\\\\\__\\ \\  \\ \\  \\|\\  \\ \\  \\|\\  \\ \\  \\___\\|___ \\  \\_| ");
        System.out.println(" \\ \\  \\ \\  \\\\|__| \\  \\ \\   ____\\ \\   __  \\ \\  \\       \\ \\  \\  ");
        System.out.println("  \\ \\  \\ \\  \\    \\ \\  \\ \\  \\___|\\ \\  \\ \\  \\ \\  \\____   \\ \\  \\ ");
        System.out.println("   \\ \\__\\ \\__\\    \\ \\__\\ \\__\\    \\ \\__\\ \\__\\ \\_______\\  \\ \\__\\");
        System.out.println("    \\|__|\\|__|     \\|__|\\|__|     \\|__|\\|__|\\|_______|   \\|__|");
        System.out.println("                                                              ");
        System.out.println("                                                              ");
        System.out.println("                                                             ");
        System.out.println("C)reate new user");
        System.out.println("A)ct as user");
        System.out.println("D)isplay feed");
        System.out.println("E)xit");
    }
    public static void individualMenuText(){
        System.out.println("  _____           _ _       _     _             _   __  __                  ");
        System.out.println(" |_   _|         | (_)     (_)   | |           | | |  \\/  |                 ");
        System.out.println("   | |  _ __   __| |___   ___  __| |_   _  __ _| | | \\  / | ___ _ __  _   _ ");
        System.out.println("   | | | '_ \\ / _` | \\ \\ / / |/ _` | | | |/ _` | | | |\\/| |/ _ \\ '_ \\| | | |");
        System.out.println("  _| |_| | | | (_| | |\\ V /| | (_| | |_| | (_| | | | |  | |  __/ | | | |_| |");
        System.out.println(" |_____|_| |_|\\__,_|_| \\_/ |_|\\__,_|\\__,_|\\__,_|_| |_|  |_|\\___|_| |_|\\__,_|");
        System.out.println("                                                                            ");
        System.out.println("What do you want to do?");
        System.out.println("P)ost an update");
        System.out.println("M)ake a donation");
        System.out.println("R)egister for event");
        System.out.println("D)isplay Page");
        System.out.println("E)xit");
        
    }
    public static void organizationMenuText(){
        System.out.println("   ____                        _          _   _               __  __                  ");
        System.out.println("  / __ \\                      (_)        | | (_)             |  \\/  |                 ");
        System.out.println(" | |  | |_ __ __ _  __ _ _ __  _ ______ _| |_ _  ___  _ __   | \\  / | ___ _ __  _   _ ");
        System.out.println(" | |  | | '__/ _` |/ _` | '_ \\| |_  / _` | __| |/ _ \\| '_ \\  | |\\/| |/ _ \\ '_ \\| | | |");
        System.out.println(" | |__| | | | (_| | (_| | | | | |/ / (_| | |_| | (_) | | | | | |  | |  __/ | | | |_| |");
        System.out.println("  \\____/|_|  \\__, |\\__,_|_| |_|_/___\\__,_|\\__|_|\\___/|_| |_| |_|  |_|\\___|_| |_|\\__,_|");
        System.out.println("              __/ |                                                                   ");
        System.out.println("             |___/                                                                   ");
        System.out.println("What do you want to do?");
        System.out.println("P)ost an update");
        System.out.println("E)xit");
    }
    public static void volunteerEventMenuText(){
        System.out.println(" __      __   _             _                   ______               _     __  __                  ");
        System.out.println(" \\ \\    / /  | |           | |                 |  ____|             | |   |  \\/  |                 ");
        System.out.println("  \\ \\  / /__ | |_   _ _ __ | |_ ___  ___ _ __  | |____   _____ _ __ | |_  | \\  / | ___ _ __  _   _ ");
        System.out.println("   \\ \\/ / _ \\| | | | | '_ \\| __/ _ \\/ _ \\ '__| |  __\\ \\ / / _ \\ '_ \\| __| | |\\/| |/ _ \\ '_ \\| | | |");
        System.out.println("    \\  / (_) | | |_| | | | | ||  __/  __/ |    | |___\\ V /  __/ | | | |_  | |  | |  __/ | | | |_| |");
        System.out.println("     \\/ \\___/|_|\\__,_|_| |_|\\__\\___|\\___|_|    |______\\_/ \\___|_| |_|\\__| |_|  |_|\\___|_| |_|\\__,_|");
        System.out.println("                                                                                                   ");
        System.out.println("                                                                                                  ");
        System.out.println("What do you want to do?");
        System.out.println("P)ost an update");
        System.out.println("M)odify event day/time/location");
        System.out.println("E)xit");
    }
    public static void makeAPostText() {
        System.out.println("  __  __       _                     _____          _   ");
        System.out.println(" |  \\/  |     | |            /\\     |  __ \\        | |  ");
        System.out.println(" | \\  / | __ _| | _____     /  \\    | |__) |__  ___| |_ ");
        System.out.println(" | |\\/| |/ _` | |/ / _ \\   / /\\ \\   |  ___/ _ \\/ __| __|");
        System.out.println(" | |  | | (_| |   <  __/  / ____ \\  | |  | (_) \\__ \\ |_ ");
        System.out.println(" |_|  |_|\\__,_|_|\\_\\___| /_/    \\_\\ |_|   \\___/|___/\\__|");
        System.out.println("                                                        ");
        System.out.println("                                                        ");

    }
    public static void ActAsUserText() {
        System.out.println("               _                    _    _               ");
        System.out.println("     /\\       | |       /\\         | |  | |              ");
        System.out.println("    /  \\   ___| |_     /  \\   ___  | |  | |___  ___ _ __ ");
        System.out.println("   / /\\ \\ / __| __|   / /\\ \\ / __| | |  | / __|/ _ \\ '__|");
        System.out.println("  / ____ \\ (__| |_   / ____ \\\\__ \\ | |__| \\__ \\  __/ |   ");
        System.out.println(" /_/    \\_\\___|\\__| /_/    \\_\\___/  \\____/|___/\\___|_|   ");
        System.out.println("                                                         ");
        System.out.println("                                                         ");
    }
    public static void feedText(){
        System.out.println("  _____                            _     ______            _ ");
        System.out.println(" |_   _|                          | |   |  ____|          | |");
        System.out.println("   | |  _ __ ___  _ __   __ _  ___| |_  | |__ ___  ___  __| |");
        System.out.println("   | | | '_ ` _ \\| '_ \\ / _` |/ __| __| |  __/ _ \\/ _ \\/ _` |");
        System.out.println("  _| |_| | | | | | |_) | (_| | (__| |_  | | |  __/  __/ (_| |");
        System.out.println(" |_____|_| |_| |_| .__/ \\__,_|\\___|\\__| |_|  \\___|\\___|\\__,_|");
        System.out.println("                 | |                                         ");
        System.out.println("                 |_|                                         ");
    }
    public static void createNewUserText(){
        System.out.println("   _____                _                    _    _               ");
        System.out.println("  / ____|              | |           /\\     | |  | |              ");
        System.out.println(" | |     _ __ ___  __ _| |_ ___     /  \\    | |  | |___  ___ _ __ ");
        System.out.println(" | |    | '__/ _ \\/ _` | __/ _ \\   / /\\ \\   | |  | / __|/ _ \\ '__|");
        System.out.println(" | |____| | |  __/ (_| | ||  __/  / ____ \\  | |__| \\__ \\  __/ |   ");
        System.out.println("  \\_____|_|  \\___|\\__,_|\\__\\___| /_/    \\_\\  \\____/|___/\\___|_|   ");
        System.out.println("                                                                  ");
        System.out.println("                                                                  ");
    }
    public static void registerText() {
        System.out.println("  _____            _     _            ");
        System.out.println(" |  __ \\          (_)   | |           ");
        System.out.println(" | |__) |___  __ _ _ ___| |_ ___ _ __ ");
        System.out.println(" |  _  // _ \\/ _` | / __| __/ _ \\ '__|");
        System.out.println(" | | \\ \\  __/ (_| | \\__ \\ ||  __/ |   ");
        System.out.println(" |_|  \\_\\___|\\__, |_|___/\\__\\___|_|   ");
        System.out.println("              __/ |                   ");
        System.out.println("             |___/                    ");
        System.out.println("                                                                  ");
        System.out.println("                                                                  ");
    }
    public static void donateText() {
        System.out.println("  _____                    _       ");
        System.out.println(" |  __ \\                  | |      ");
        System.out.println(" | |  | | ___  _ __   __ _| |_ ___ ");
        System.out.println(" | |  | |/ _ \\| '_ \\ / _` | __/ _ \\");
        System.out.println(" | |__| | (_) | | | | (_| | ||  __/");
        System.out.println(" |_____/ \\___/|_| |_|\\__,_|\\__\\___|");
        System.out.println("                                   ");
        System.out.println("                                                                  ");
        System.out.println("                                                                  ");
    }
    public static void modifyEventText() {
        System.out.println("  __  __           _ _  __         ______               _   ");
        System.out.println(" |  \\/  |         | (_)/ _|       |  ____|             | |  ");
        System.out.println(" | \\  / | ___   __| |_| |_ _   _  | |____   _____ _ __ | |_ ");
        System.out.println(" | |\\/| |/ _ \\ / _` | |  _| | | | |  __\\ \\ / / _ \\ '_ \\| __|");
        System.out.println(" | |  | | (_) | (_| | | | | |_| | | |___\\ V /  __/ | | | |_ ");
        System.out.println(" |_|  |_|\\___/ \\__,_|_|_|  \\__, | |______\\_/ \\___|_| |_|\\__|");
        System.out.println("                            __/ |                           ");
        System.out.println("                           |___/                           ");
        System.out.println("                                                                  ");
        System.out.println("                                                                  ");
    }
}