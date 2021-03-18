package pkg;

public class PersonalInformation implements Comparable<PersonalInformation> {
	String fullName;
	String streetAddress;
	String city;
	States state;
	String phone;
	
	public PersonalInformation(String fullName, String streetAddress, String city, States state, String phone) {
		this.fullName = fullName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.phone = phone;
	}
	
	public String toString() {
		return fullName + "\t" + streetAddress + "\t" + city + "\t" + state + "\t" + phone + "\t";
	}
	
	public int compareTo(PersonalInformation o) {
		return this.fullName.compareTo(o.fullName);
	}
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state.toString();
	}

	public void setState(States state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
