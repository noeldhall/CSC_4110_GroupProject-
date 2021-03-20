package pkg;

public class CustomerAccount  implements Comparable<CustomerAccount>{
	private double balance;
	private double lastPaidAmount;
	
	public CustomerAccount() {
		balance=0;
		lastPaidAmount=0;
	};
	
	public CustomerAccount(double b, double l) {
		balance=b;
		lastPaidAmount=l;
	}
	
	public String toString() {
		String data= "balance: "+balance+"\n"+"last paid amount: "+lastPaidAmount+"\n";
	return data;
	}

	public int compareTo(CustomerAccount c) {
		if(balance == c.balance) {
			return 0;
		}
		else {
			return (int) (balance - c.balance);
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
	
	
}