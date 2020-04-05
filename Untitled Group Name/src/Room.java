import java.util.ArrayList;

/**
 * A class representing a hotel room.
 *
 */
public class Room {
    private int numGuests;
    private String name;
    private int birthDate;
    private String address;
    private int startDate;
    private int endDate;
    private ArrayList<RoomService> orders;
    private int numOrders;
    private boolean checkedIn;
    private boolean needsCleaning;

    private void reset() {
        numGuests = 0;
        name = null;
        birthDate = 0;
        address = null;
        startDate = 0;
        endDate = 0;
        numOrders = 0;
        checkedIn = false;
    }

    /**
     * Default constructor for the Room class.
     */
    public Room() {
        orders = new ArrayList<RoomService>();
        needsCleaning = false;
        reset();
    }

    /**
     * Sets the room as checked-in.
     * If it's already checked-in, returns false.
     */
    public boolean checkIn() {
        if (checkedIn) {
            return false;
        }
        else {
            checkedIn = true;
            return true;
        }
    }

    /**
     * Sets a room as checked-out & needing cleaning.
     * If the rooms is already checked-out, return false.
     */
    public boolean checkOut() {
        if (checkedIn) {
            needsCleaning = true;
            orders.clear();
            reset();
            return true;
        }
        else {

            return false;
        }
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

    /**
     *
     */
    public void makeRestaurantReservation(String date, String time) {
        //set reservation
    }

    public void viewRestaurantReservation() {
        //output reservation info
    }

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
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

    public void setStartDate(int startDate) {
        this.startDate = startDate;
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

    public void setOrders(ArrayList<RoomService> orders) {
        this.orders = orders;
    }

    public int getNumOrders() {
        return numOrders;
    }

    public void setNumOrders(int numOrders) {
        this.numOrders = numOrders;
    }

    public boolean isCheckedIn() {
        return checkedIn;
    }

    public boolean needsCleaning() {
        return needsCleaning;
    }

    public void setNeedsCleaning(boolean needsCleaning) {
        this.needsCleaning = needsCleaning;
    }

}