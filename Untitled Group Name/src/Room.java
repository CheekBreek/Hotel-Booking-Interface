import java.util.ArrayList;

/**
 * A class representing a hotel room.
 *
 */
public class Room {
    private int roomNum;
    private int capacity;
    private String name;
    private Date birthDate;
    private String address;
    private Date startDate;
    private Date endDate;
    private ArrayList<RoomService> orders;
    private boolean booked;
    private boolean checkedIn;
    private boolean needsCleaning;
    private Reservation reservation = null;

    private void reset() {
        name = null;
        birthDate = null;
        address = null;
        startDate = null;
        endDate = null;
        booked = false;
        checkedIn = false;
    }

    /**
     * Default constructor for the Room class.
     */
    public Room(int roomNum, int capacity) {
        booked = false;
        checkedIn = false;
        orders = new ArrayList<RoomService>();
        needsCleaning = false;
        reset();
    }

    /**
     * Books a room & sets the guest's personal information.
     */
     public void bookRoom(String name, Date birthDate, String address, Date startDate, Date endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        booked = true;   
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
     * Creates a reservation for specific date and time, if there is no pre-existing one.
     */
    public boolean makeRestaurantReservation(Date date, String time) {
       if (reservation == null) {
           reservation = new Reservation (name, date, time);
           return true;
       }
       else {
           return false;
       }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ArrayList<RoomService> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<RoomService> orders) {
        this.orders = orders;
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

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isBooked() {
        return booked;
    }
}
