package pkg;

public class VendorAccount {
	double balance;
	double lastPaidAmount;
	
	public VendorAccount(double balance, double lastPaidAmount) {
		this.balance = balance;
		this.lastPaidAmount = lastPaidAmount;
	}
	
	public String toString() {
		String data = "";
		data = "balance: " + balance + "\n" + 
				"last Paid Amount: " + lastPaidAmount + "\n";
		return data;
	}
}
