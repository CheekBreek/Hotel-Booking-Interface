/**
 * A class representing a room service.
 * Stores the name of the service & it's description.
 *
 */
public class RoomService {
    private String name;
    private String description;

    /**
     *  Constructor for the RoomService class.
     */
    public RoomService(String name, String description) {
        super();
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

}
