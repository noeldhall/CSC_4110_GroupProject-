package guiPkg;

import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import pkg.Database;
import pkg.VendorProfile;

public class VendorTableModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4254378981778670206L;
	private final Vector<VendorProfile> vendorList;
	private final String[] columnNames = new String[] { "Name", "phone number", "balance", "last paid amount", "last order date"};
	@SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] { String.class, String.class, Double.class, Double.class, Date.class};
	
	public VendorTableModel(Vector<VendorProfile> data) {
		vendorList = data;
	}
	
	@Override
	public int getRowCount() {
		// returns number of items (rows) in our table
		return vendorList.size();
	}

	@Override
	public int getColumnCount() {
		// returns the number of columns in our table
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		VendorProfile vp = vendorList.get(rowIndex);
		switch(columnIndex) {
			case 0:
				return vp.getPersonal().getFullName();
			case 1:
				return vp.getPersonal().getPhone();
			case 2:
				return vp.getvAccount().getBalance();
			case 3:
				return vp.getvAccount().getLastPaidAmount();
			case 4:
				if(vp.getLastOrderDate() != null) {
					return vp.getLastOrderDate().toString();
				}
				return new String("");
			default:
				return null;
		}
	}

	public void addRow(VendorProfile p) {
		if(Database.searchVendorName(p.getPersonal().getFullName()) != null) {
			vendorList.add(p);
			this.fireTableDataChanged();
		}
		else {
			JOptionPane.showMessageDialog(null, "Integrity Constraint Violation - Duplicate Vendor Name - row rejected", "insert Error", JOptionPane.OK_OPTION);
		}
	}
	
	public void removeRow(int index) {
		//TODO need to make sure only delete where balance is 0
		if(index != -1) {
			if(vendorList.elementAt(index).getvAccount().getBalance() == 0) {
				if(0 == JOptionPane.showConfirmDialog(null, "Warning: deleting a vendor will also delete all purchase orders associated with that vendor. Would you like to proceed with deletion?", "Confirm Delete?", JOptionPane.OK_CANCEL_OPTION)){
					vendorList.remove(index);
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
