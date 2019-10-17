import java.util.ArrayList;

/**
 * Represents an abstract user
 * @author Ruben Bramasco
 * @version 1.0.0
 * @since 10/12/2019
 */
public abstract class User{

    /**
     * user's display name
     */
    private String userName;

    /**
     * user's real name
     */
    private String name;

    /**
     * user's email
     */
    private String email;

    /**
     * user's password
     */
    private String password;

    /**
     * User's bio
     */
    private String bio;

    /**
     * Constucts a new User given basic User Info
     * @param userName  username as String Object 
     * @param name name as String Object 
     * @param email email as String Object
     * @param password password as String Object
     * @param bio bio as String Object
     */
    User(String userName, String name, String email, String password, String bio){
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bio = bio;
    }

    /**
     * gets user's display name
     * @return display name as String Object
     */
    public String getUserName(){
        return userName;
    }

    /**
     * gets user's real name
     * @return real name as String Object
     */
    public String getName(){
        return name;
    }

    /**
     * gets user's email 
     * @return email as String Object
     */
    public String getEmail(){
        return email;
    }

    /**
     * gets user's password
     * @return password as String Object
     */
    public String getPassword(){
        return password;
    }

    /**
     * gets user's bio
     * @return bio as String Object
     */
    public String getBio(){
        return bio;
    }

    /**
     * Gives the user the ablity to post
     * @param message message of post as String Object
     * @param image imageLocation as String Object
     */
    public abstract void post(String message, String image);

    /**
     * gets a list of post from user
     * @return list of post as ArrayList<Post>
     */
    public abstract ArrayList<Post> getPost();

}