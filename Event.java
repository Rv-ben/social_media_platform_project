import java.util.Date;

/**
 * Represents an event with time/date/location
 */
public class Event{

    /**
     * Location of event 
     */
    private String location;

    /**
     * Date and Time of event
     */
    private Date date;

    /**
     * Name of event
     */
    private String name;

    /**
     * Constructs an Event with Date and Location
     * @param date
     * @param location
     */
    Event(Date date, String location){
        this.location = location;
        this.date = date;
    }

    /**
     * gets date
     * @return date as Date Object
     */
    public Date getDate(){
        return date;
    }

    /**
     * gets location 
     * @return location as String Object
     */
    public String getLocation(){
        return location;
    }

    /**
     * Display event info
     */
    public String toString(){
        return name + " @ " + date.toString() + " " + location;
    }
}