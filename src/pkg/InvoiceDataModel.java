package pkg;

//Authored by Brett Gloomis

import java.util.ArrayList;
import java.util.List;

//Authored by Brett Gloomis

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class InvoiceDataModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 985637898177670210L;

	private static List<InvoiceOrdersObserver> observers = new ArrayList<InvoiceOrdersObserver>();
	private static int state = 0;
	
	static DatabaseII<CustomerProfile> customerData;
	private final String[] columnNames = new String[] { "Customer Name"};
	private final Class[] columnClass = new Class[] { String.class};

	public InvoiceDataModel(Class<CustomerProfile> dt, String s) {
		customerData = new DatabaseII<CustomerProfile>(dt, s);
	}
	@Override
	public int getRowCount() {
	return customerData.getData().size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	public CustomerProfile getRow(int rowIndex) {
		return customerData.getData().get(rowIndex);
	}
	
	@Override
	public String getColumnName(int index)
	{
		return columnNames[index];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		CustomerProfile cp = customerData.getData().get(rowIndex);
		switch(columnIndex) {
			case 0:
				return cp.getCustomerInfo().getCustomerName();
			default:
				return null;
		}

	}
	
	public static CustomerProfile searchCustomerName(String name) {
		for(CustomerProfile cp : customerData.getData()) {
			if(cp.customerInfo.customerName.trim().equalsIgnoreCase(name)) {
				return cp;
			}
		}
		return null;
	}
	
	
	public static Vector<CustomerProfile> getDatabase(){
		return customerData.getData();
	}
	
	//observer
	public int getState() {
		return state;
	}
	public static void setState(int state) {
		notifyAllObservers();
	}	
	public static void attach(InvoiceOrdersObserver observer){
		observers.add(observer);		
	}

	public static void notifyAllObservers(){
		for (InvoiceOrdersObserver observer : observers) {
			observer.update();
			}
	}
}
