package crms;

public class OfficerBean {

	private String officerName;
	private String officerID;
	private String designation;
	private String station;
	private String password;
	private int age;
	private long phoneNumber;
	
	public void setAge(int age) {
		this.age = age;
	}
	
	//Setter methods
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public void setOfficerID(String officerID) {
		this.officerID = officerID;
	}
	
	public void setOfficerName(String officerName) {
		this.officerName = officerName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setStation(String station) {
		this.station = station;
	}
	
	//Getter Methods
	
	public int getAge() {
		return age;
	}
	public String getDesignation() {
		return designation;
	}
	public String getOfficerID() {
		return officerID;
	}
	public String getOfficerName() {
		return officerName;
	}
	public String getPassword() {
		return password;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public String getStation() {
		return station;
	}
	
}
