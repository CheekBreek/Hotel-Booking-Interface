
public class Facility {
	private String name;
	private String time;
	private String description;
	private Boolean availability;
	
	public Facility (String Name, String Time, String Description){
		name = Name;
		time = Time;
		description = Description;
		availability = true;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getTime () {
		return time;
	}
	public Boolean getAvailability () {
		return availability;
	}
	public void setTime(String Time) {
		time = Time;
	}
	public void setAvailablity (Boolean Avalable) {
		availability = Avalable;
	}
}