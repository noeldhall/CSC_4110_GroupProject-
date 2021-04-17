package pkg;

import java.util.Vector;

public class CustomerInvoice implements Data{
	public String CustomerName;
	private String invoiceDate;
	private String orderDate;
	private String orderNumber;
	private String orderedItems;
	private Double invoiceTotal;
	private int invoiceNumber;
	private Vector<CustomerInvoice> customerInvoice = new Vector<CustomerInvoice>();
	
	public Vector<CustomerInvoice> getCustomerInvoice(String customer) {
		
		Vector<CustomerInvoice> cov=new Vector<CustomerInvoice>();
		for(CustomerInvoice co: Main.newInvoice.customerInvoice) {
		if(co.getCustomerName().equals(customer))
			cov.add(co);
		}
		return cov;
		
		
	}
	public void setCustomerInvoice(Vector<CustomerInvoice> customerInvoice) {
		this.customerInvoice = customerInvoice;
	}
	public void addCustomerInvoice(CustomerInvoice invoice) {
		customerInvoice.add(invoice);
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderedItems() {
		return orderedItems;
	}
	public void setOrderedItems(String orderedItems) {
		this.orderedItems = orderedItems;
	}
	public Double getInvoiceTotal() {
		return invoiceTotal;
	}
	public void setInvoiceTotal(Double invoiceTotal) {
		this.invoiceTotal = invoiceTotal;
	}
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}	
	@Override
	public String toString()
	{
		return Integer.toString(invoiceNumber);
		
	}
}
