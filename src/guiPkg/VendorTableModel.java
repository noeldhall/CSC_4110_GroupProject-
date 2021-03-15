package guiPkg;

import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import pkg.PersonalInformation;
import pkg.VendorAccount;
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
				return vp.getLastOrderDate().toGMTString();
			default:
				return null;
		}
	}

}
