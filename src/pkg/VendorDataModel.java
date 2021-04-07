package pkg;

import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

//Authored by Nicholas Foster
//4-6-2021 2am

public class VendorDataModel extends AbstractTableModel{
	/**
	 * The vendorDataModel is a all-in-one class that handles data transactions between the client
	 * and data structure. It will house all activities and data related to the vendorData vector
	 * that will be populated as per the Database object.
	 */
	private static final long serialVersionUID = 4254378981778670206L;
	static DatabaseII<VendorProfile> vendorData;
	private final String[] columnNames = new String[] { "Name", "phone number", "balance", "last paid amount", "last order date"};
	@SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] { String.class, String.class, Double.class, Double.class, Date.class};
	
	public VendorDataModel(Class<VendorProfile> dt, String s) {
		vendorData = new DatabaseII<VendorProfile>(dt, s);
	}
	
	@Override
	public int getRowCount() {
		// returns number of items (rows) in our table
		return vendorData.getData().size();
	}
	
	@Override
	public int getColumnCount() {
		// returns the number of columns in our table
		return columnNames.length;
	}
	
	public VendorProfile getRow(int rowIndex) {
		return vendorData.getData().get(rowIndex);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		VendorProfile vp = vendorData.getData().get(rowIndex);
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
		if(insertVendor(p)) {
			this.fireTableDataChanged();
		}
	}
	
	public void updateRow(VendorProfile p, int index) {
		if(index != -1) {
			if(updateVendor(p, index)) {
				this.fireTableDataChanged();
			}
		}
	}
	
	public void removeRow(int index) {
		if(index != -1) {
			if(vendorData.getData().elementAt(index).getvAccount().getBalance() == 0) {
				if(0 == JOptionPane.showConfirmDialog(null, "Warning: deleting a vendor will also delete all purchase orders associated with that vendor. Would you like to proceed with deletion?", "Confirm Delete?", JOptionPane.OK_CANCEL_OPTION)){
					vendorData.getData().remove(index);
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
	
	public static int generateVendorID() {
		int uniInt = 1;
		for(VendorProfile vp: vendorData.getData()) {
			if(uniInt == Integer.parseInt(vp.getVendorID())) {
				uniInt++;
			}
			else {
				return uniInt;
			}
		}
		return 0;
	}
	
	public static VendorProfile searchVendorID(String id) {
		for(VendorProfile vp : vendorData.getData()) {
			if(vp.vendorID.equals(id)) {
				return vp;
			}
		}
		return null;
	}
	
	public static VendorProfile searchVendorName(String name) {
		for(VendorProfile vp : vendorData.getData()) {
			if(vp.personal.fullName.trim().equalsIgnoreCase(name)) {
				return vp;
			}
		}
		return null;
	}
	
	public static boolean insertVendor(VendorProfile p) {
		if(searchVendorName(p.getPersonal().getFullName()) == null) {
			vendorData.getData().add(p);
			return true;
		}
		else {
			JOptionPane.showMessageDialog(null, "Integrity Constraint Violation - Duplicate Vendor Name - row rejected", "insert Error", JOptionPane.OK_OPTION);
			return false;
		}
	}
	
	public static boolean updateVendor(VendorProfile p, int index) {
		try {
			vendorData.getData().elementAt(index).updateProfile(p);
		}
		catch(IllegalArgumentException e) {
			return false;
		}
		return true;
	}
	
	public static boolean deleteVendor(VendorProfile p) {
		//find and delete a vendor profile based on a passed in vendor profile
		if(p.getvAccount().getBalance() == 0) {
			for(VendorProfile profile: vendorData.getData()) {
				if(p.compareTo(profile) == 0) {
					if(0 == JOptionPane.showConfirmDialog(null, "Warning: deleting a vendor will also delete all purchase orders associated with that vendor. Would you like to proceed with deletion?", "Confirm Delete?", JOptionPane.OK_CANCEL_OPTION)){
						vendorData.getData().remove(profile);
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
	
	public static Vector<VendorProfile> getDatabase() {
		return vendorData.getData();
	}
}
