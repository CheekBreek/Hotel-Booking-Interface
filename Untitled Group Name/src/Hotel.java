import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
	
	private String name; 
	private String description;
	private ArrayList <Announcement> announcements;
	private ArrayList <Room> rooms; 
	private String hotelFile = "HotelFile";
	
	public Hotel () throws Exception{

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
			
			for (int num = 20; num > 0; num--) {
				Room init = new Room();
				rooms.add(init);
			}
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
	public String getDescrition() {
		return description;
	}
	public Room getRoom(int index) {
		return rooms.get(index);
	}
}
