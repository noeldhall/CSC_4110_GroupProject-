package pkg;

//Authored by Nicholas Foster

public class DataFactory {
	public static Data makeDataObject(String type, String[] data) {
		if(type.equals("VendorProfile")) {
			return new VendorProfile(data);
		}
		else if(type.equals("CustomerProfile")) {
			return new CustomerProfile(data);
		}
		else if(type.equals("UserProfile")) {
			return new UserProfile(data);
		}
		else if(type.equals("Item"))
		{
			return new Item(data);
		}
		else if(type.equals("PurchaseOrder")) {
			return new PurchaseOrder(data);
		}
		else if(type.equals("CustomerOrder")) {
			return new CustomerOrder(data);
		}
		else {
			return null;
		}
	}
}
