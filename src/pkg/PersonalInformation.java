package pkg;

public class PersonalInformation {
	String fullName;
	String streetAddress;
	String city;
	String state;
	String phone;
	
	public PersonalInformation(String fullName, String streetAddress, String city, String state, String phone) {
		this.fullName = fullName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.phone = phone;
	}
	
	public String toString() {
		return fullName + "\n" + streetAddress + "\n" + city + "\n" + state + "\n" + phone + "\n";
	}
	
}
