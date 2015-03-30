package utbm.java.project.SchoolCourse;

public class Location {

	private int id;

	private String city;

	public Location() {
		
	}

	public String getcity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public int getid() {
		return id;
	}

	public void setid(int id) {
		this.id = id;
	}
	
	public Location(int id, String city	) {
		this.id = id;
		this.city = city;
	}
	
}
