import java.util.ArrayList;

/**
 * A class representing a booked hotel room.
 *
 */
public class Room {
    private int numGuests;
    private String name;
    private int birthDate;
    private String address;
    private final int startDate;
    private int endDate;
    private ArrayList<RoomService> orders;
    //private RoomService[] orders = null;
    private final int maxFlags = 10; //max can change, temporary
    private final int maxOrders = 10;
    private int numFlags;
    private int numOrders;
    //private ArrayList<Flag> flags;

    /**
     * Constructor for the Room class.
     * The number of guests in the room, one of the guest's personal information (name, date of birth, address),
     * and the start & end date of the booking must be passed in.
     */
    public Room(int numGuests, String name, int birthDate, String address, int startDate, int endDate) {
        super();
        this.numGuests = numGuests;
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        orders = new ArrayList<RoomService>();
        //flags = new ArrayList<Flag>();
    }

    /**
     *
     * @return
     */
    public boolean checkIn() {
        //add check-in flag
        return true;
    }

    public boolean checkOut() {
        //remove check-in flag
        return true;
    }

    /**
     * Add's a service to the queue of services for the room.
     * If the service has already been ordered, then the function returns false, true otherwise.
     */
    public boolean orderRoomService(RoomService service) {

        if (orders.contains(service)) {
            return false;
        }
        else {
            orders.add(service) ;
            return true;
        }
    }

    /**
     * Searches for a service in the queue, and removes it.
     * If the service is not in the queue, returns false, otherwise, returns true;
     */
    public boolean clearService(RoomService service) {
        if (orders.contains(service)) {
            orders.remove(service);
            return true;
        }
        else {
            return false;
        }
    }

    public void makeRestaurantReservation(String date, String time) {
        //set reservation
    }

    public void viewRestaurantReservation() {
        //output reservation info
    }

    public int getCapacity() {
        return numGuests;
    }

    public void setCapacity(int capacity) {
        this.numGuests = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStartDate() {
        return startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    public ArrayList<RoomService> getOrders() {
        return orders;
    }

    public int getMaxFlags() {
        return maxFlags;
    }

    public int getMaxOrders() {
        return maxOrders;
    }

    public int getNumFlags() {
        return numFlags;
    }

    public void setNumFlags(int numFlags) {
        this.numFlags = numFlags;
    }

    public int getNumOrders() {
        return numOrders;
    }

    public void setNumOrders(int numOrders) {
        this.numOrders = numOrders;
    }


}