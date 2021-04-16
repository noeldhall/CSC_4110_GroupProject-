/**
 * 
 */
package guiPkg;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.Vector;
import pkg.CustomerProfile;

/**
 * @author Noel Hall
 *
 */
public class CustomerTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 4254378981778670210L;
	private final String[] columnNames = new String[] { "Name", "phone number", "balance", "last paid amount"};
	private final Vector<CustomerProfile> customerList;
	@SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] { String.class, String.class, Double.class, Double.class};
	
	
	public CustomerTableModel(Vector<CustomerProfile> data) {
		customerList = data;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return customerList.size();
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		CustomerProfile cp = customerList.get(rowIndex);
		switch(columnIndex) {
			case 0:
				return cp.getCustomerInfo().getCustomerName();
			case 1:
				return cp.getCustomerInfo().getPhone();
			case 2:
				return cp.getCustomerAccount().getBalance();
			case 3:
				return cp.getCustomerAccount().getLastPaidAmount();
			default:
				return null;
		}

	}
	
	public void addRow(CustomerProfile p) {
		if(Database.insertCustomer(p)) {
			this.fireTableDataChanged();
		}
	}

	public void removeRow(int index) {
		//TODO need to make sure only delete where balance is 0
		if(index != -1) {
			if(customerList.elementAt(index).getCustomerAccount().getBalance() == 0) {
				if(0 == JOptionPane.showConfirmDialog(null, "Warning: deleting a customer will also delete all invoices associated with that customer. Would you like to proceed with deletion?", "Confirm Delete?", JOptionPane.OK_CANCEL_OPTION)){
					customerList.remove(index);
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
}
