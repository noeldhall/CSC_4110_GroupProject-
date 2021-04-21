package pkg;

//Authored by Nicholas Foster

public class PersonalInformation implements Comparable<PersonalInformation> {
	String fullName;
	String streetAddress;
	String city;
	States state;
	String phone;
	
	public PersonalInformation() {
		fullName = "";
		streetAddress = "";
		city = "";
		state = States.MI;
		phone = "000-000-0000";
	}
	
	public PersonalInformation(String fullName, String streetAddress, String city, States state, String phone) throws IllegalArgumentException {
		setFullName(fullName);
		setStreetAddress(streetAddress);
		setCity(city);
		setState(state);
		setPhone(phone);
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

	public void setFullName(String fullName) throws IllegalArgumentException {
		if(fullName.length() > 20) {
			throw new IllegalArgumentException("Invalid input length [max 20]");
		}
		else {
			this.fullName = fullName;
		}
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) throws IllegalArgumentException {
		if(streetAddress.length() > 20) {
			throw new IllegalArgumentException("Invalid input length [max 20]");
		}
		else {
			this.streetAddress = streetAddress;
		}
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) throws IllegalArgumentException{
		if(city.length() > 20) {
			throw new IllegalArgumentException("Invalid input length [max 20]");
		}
		else {
			this.city = city;
		}
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

	public void setPhone(String phone) throws IllegalArgumentException {
		if(phone.matches("\\d{3}-\\d{3}-\\d{4}")) {
			this.phone = phone;
		}
		else {
			throw new IllegalArgumentException("Invalid input, must match (XXX-XXX-XXXX) where X is a 0-9 digit");
		}
	}

	public void setPersonal(PersonalInformation personal) {
		setFullName(personal.getFullName());
		setStreetAddress(personal.getStreetAddress());
		setCity(personal.getCity());
		setState(States.valueOf(personal.getState()));
		setPhone(personal.getPhone());
		
	}
}
