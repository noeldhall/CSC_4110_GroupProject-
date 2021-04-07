package pkg;

//Authored by Nicholas Foster

public class ProfileFactory {
	public static Profile makeProfile(String type, String[] data) {
		if(type.equals("VendorProfile")) {
			return new VendorProfile(data);
		}
		else if(type.equals("CustomerProfile")) {
			return new CustomerProfile(data);
		}
		else if(type.equals("UserProfile")) {
			return new UserProfile(data);
		}
		else {
			return null;
		}
	}
}
