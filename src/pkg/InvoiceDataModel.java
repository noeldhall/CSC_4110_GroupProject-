package pkg;

//Authored by Brett Gloomis

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class InvoiceDataModel extends AbstractTableModel {
	private static final long serialVersionUID = 985637898177670210L;

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
	
	public void addRow(CustomerProfile p) {
		if(insertCustomer(p)) {
			this.fireTableDataChanged();
		}
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

//	public static int generateCustomerID() {
//		int uniInt = 1;
//		
//		for (CustomerProfile cp:customerData.getData())
//		{
//			if(uniInt==Integer.parseInt(cp.getCustomerId())) {
//				uniInt++;
//			}
//			else 
//				return uniInt;
//		}
//		return 0;
//	}
	
	public void removeRow(int index) {
		//TODO need to make sure only delete where balance is 0
		if(index != -1) {
			if(customerData.getData().elementAt(index).getCustomerAccount().getBalance() == 0) {
				if(0 == JOptionPane.showConfirmDialog(null, "Warning: deleting a customer will also delete all invoices associated with that customer. Would you like to proceed with deletion?", "Confirm Delete?", JOptionPane.OK_CANCEL_OPTION)){
					customerData.getData().remove(index);
					this.fireTableDataChanged();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Error - Account has a remaining balance. Cannot delete if non-zero.", "Deletion Error", JOptionPane.OK_OPTION);
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Error - must select an account with a balance of 0 for deletion operation", "Deletion Error", JOptionPane.OK_OPTION);
		}
	}
	
	public static CustomerProfile searchCustomerID(String id) {
		for(CustomerProfile cp : customerData.getData()) {
			if(cp.customerId.equals(id)) {
				return cp;
			}
		}
		return null;
	}
	
	public static CustomerProfile searchCustomerName(String name) {
		for(CustomerProfile cp : customerData.getData()) {
			if(cp.customerInfo.customerName.trim().equalsIgnoreCase(name)) {
				return cp;
			}
		}
		return null;
	}
	
	public static boolean insertCustomer(CustomerProfile p) {
		if(searchCustomerName(p.getCustomerInfo().getCustomerName()) == null) {
			customerData.getData().add(p);
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Integrity Constraint Violation - Duplicate Customer Name - row rejected", "insert Error", JOptionPane.OK_OPTION);
			return false;
		}
	}
	
	public static boolean deleteCustomer(CustomerProfile p) {
		//find and delete a vendor profile based on a passed in vendor profile
		if(p.getCustomerAccount().getBalance() == 0) {
			for(CustomerProfile profile: customerData.getData()) {
				if(p.compareTo(profile) == 0) {
					if(0 == JOptionPane.showConfirmDialog(null, "Warning: deleting a customer will also delete all invoices associated with that vendor. Would you like to proceed with deletion?", "Confirm Delete?", JOptionPane.OK_CANCEL_OPTION)){
						customerData.getData().remove(profile);
						return true;
					}
					else {
						break;
					}
				}
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "Error - Account has a remaining balance. Cannot delete if non-zero.", "Deletion Error", JOptionPane.OK_OPTION);
		}
		return false;
	}
	
	public static Vector<CustomerProfile> getDatabase(){
		return customerData.getData();
	}
}
