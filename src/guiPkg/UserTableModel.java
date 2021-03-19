package guiPkg;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import pkg.UserProfile;

public class UserTableModel extends AbstractTableModel{
	private static final long serialVersionUID = 4254378981778670206L;
	private final Vector<UserProfile> userList;
	private final String[] columnNames = new String[] { "First Name", "Last Name", "User ID", "Role"};
	@SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] { String.class, String.class, String.class, String.class};
	
	public UserTableModel(Vector<UserProfile> data) {
		userList = data;
	}
	
	@Override
	public String getColumnName(int i) {
		return columnNames[i];
	}
	
	@Override
	public int getRowCount() {
		// returns number of items (rows) in our table
		return userList.size();
	}

	@Override
	public int getColumnCount() {
		// returns the number of columns in our table
		return columnNames.length;
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		UserProfile vp = userList.get(rowIndex);
		switch(columnIndex) {
			case 0:
				return vp.getFirstName();
			case 1:
				return vp.getLastName();
			case 2:
				return vp.getUserID();
			case 3:
				return vp.getUserRole().toString();
			default:
				return null;
		}
	}

}
