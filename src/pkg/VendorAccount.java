package pkg;

//Authored by Nicholas Foster

public class VendorAccount implements Comparable<VendorAccount>{
	double balance;
	double lastPaidAmount;
	
	public VendorAccount() {
		balance = 0.00;
		lastPaidAmount = 0.00;
	}
	
	public VendorAccount(double balance, double lastPaidAmount) {
		this.balance = balance;
		this.lastPaidAmount = lastPaidAmount;
	}
	
	public String toString() {
		String data = "";
		data = "balance: " + balance + "\t" + 
				"last Paid Amount: " + lastPaidAmount + "\t";
		return data;
	}
	
	public int compareTo(VendorAccount o) {
		if(balance == o.balance) {
			return 0;
		}
		else {
			return (int) (balance - o.balance);
		}
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getLastPaidAmount() {
		return lastPaidAmount;
	}

	public void setLastPaidAmount(double lastPaidAmount) {
		this.lastPaidAmount = lastPaidAmount;
	}

	public void setvAccount(VendorAccount acc) {
		setBalance(acc.getBalance());
		setLastPaidAmount(acc.getLastPaidAmount());
	}
}