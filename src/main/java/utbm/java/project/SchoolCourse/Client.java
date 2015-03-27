package utbm.java.project.SchoolCourse;

public class Client {

	private int id;
	
	private String firstname;
	
	private String lastname;
	
	private String address;
	
	private String cellphone;

	private String email;
	
	private int sessionID;

	public Client() {
		
	}
	
	public Client(String firstname, String lastname, String address, String phone, String email, int sessionID) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.cellphone = phone;
		this.email = email;
		this.sessionID = sessionID;
		
	}
	public int getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSessionID() {
		return sessionID;
	}

	public void setSessionID(int sessionID) {
		this.sessionID = sessionID;
	}
}
