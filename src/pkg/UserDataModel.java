package pkg;

//Authored by Brett Gloomis

import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class UserDataModel extends AbstractTableModel {
	
	static DatabaseII<UserProfile> userList;
	public static UserProfile currentUser;
	private static final long serialVersionUID = 4254378981778670206L;
	private final String[] columnNames = new String[] { "First Name", "Last Name", "User ID", "Role"};
	@SuppressWarnings("rawtypes")
	private final Class[] columnClass = new Class[] { String.class, String.class, String.class, String.class};

	public UserDataModel(Class<UserProfile> dt, String s) {
		userList = new DatabaseII<UserProfile>(dt, s);
	}
	
	@Override
	public String getColumnName(int i) {
		return columnNames[i];
	}
	
	@Override
	public int getRowCount() {
		// returns number of items (rows) in our table
		return userList.getData().size();
	}

	@Override
	public int getColumnCount() {
		// returns the number of columns in our table
		return columnNames.length;
	}
	
	public UserProfile getRow(int rowIndex) {
		return userList.getData().get(rowIndex);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		UserProfile vp = userList.getData().get(rowIndex);
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
	
	public static UserProfile login(String username, String password) {
		boolean loginFlag = false;
		
		for(UserProfile up : userList.getData()) {
			//attempt to find the user for login process
			loginFlag = up.login(username, password);
			if(loginFlag == true) {
				//if the login is ever successful, we can just break, we found our user.
				return up;
			}		
		}
		return null;
	}
	
	public static UserProfile findUser(String userID) {
		Iterator<UserProfile> userIndex = userList.getData().iterator();
			
		while(userIndex.hasNext())
		{	
			UserProfile jeff = userIndex.next();
			if(jeff.getUserID().equals(userID))
			{
				return jeff;
			}				
		}		
		JOptionPane.showMessageDialog(null, "User profile not found.");			//TODO fix this error		
		return null;		
	}
	
	public static UserProfile deleteUser(String userID) {
		Iterator<UserProfile> userIndex = userList.getData().iterator();
			
		while(userIndex.hasNext())
		{	
			UserProfile jeff = userIndex.next();
			if(jeff.getUserID().equals(userID))
			{
				userIndex.remove();
				return jeff;
			}			
		}
		return null;			
	}
	
	public static boolean searchIDMatch(String ID) {
		for(UserProfile vp : userList.getData()) {
			if(vp.userID.equals(ID)) {
				return true;
			}
		}
		return false;
	}
	
	public static Vector<UserProfile> getDatabase() {
		return userList.getData();
	}
	
}
