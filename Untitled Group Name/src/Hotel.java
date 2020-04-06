import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
	
	private String name; 
	private String description;
	private ArrayList <Announcement> announcements = new ArrayList<Announcement>();
	private Room [][] rooms = new Room [2][10]; 
	private ArrayList <Facility> facilities = new ArrayList<Facility>();

	
	public Hotel () throws Exception{
			String hotelFile = "HotelFile";
			File Input = new File(hotelFile);
			Scanner readIn = new Scanner (Input);

			String line = readIn.nextLine();
			name = line;
			
			while (readIn.hasNext()) {
				line = readIn.nextLine();
				if (description == null) {
					description = line + '\n';
				}
				else {
					description = description + line + '\n';
				}
			}
			
			readIn.close();
			
			int capacity = 4;
			int roomNum = 300;
			for (int floor = 1; floor >= 0; floor--) {
				for (int num = 9; num >= 0; num--) {
					if (num < 5) {
						capacity = capacity / 2;
					}
					Room init = new Room(roomNum + num + 1, capacity);
					rooms[floor][num] = init;
				}
				roomNum = roomNum - 100;
			}
		
			String facilityFile = "FacilityFile";
			Input = new File(facilityFile);
			readIn = new Scanner (Input);
			
			while (readIn.hasNextLine()) {
				Facility addFacility = new Facility(readIn.nextLine(),readIn.nextLine(), readIn.nextLine());
				facilities.add(addFacility);
			}
			readIn.close();
	}
	
	public void addAnnouncement (String announcement, String date) {
		
		Announcement newAnnounce = new Announcement(announcement, date);
		announcements.add(newAnnounce);		
	}
	public void removeAnnouncement (int index) {
		announcements.remove(index);
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Room getRoom(int floor, int room) {
		return rooms [floor][room];
	}
	public Facility getFacility(int index) {
		return facilities.get(index);
	}	
}
