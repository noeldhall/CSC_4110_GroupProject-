package pkg;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class UserProfile implements Data {
    String lastName;
    String firstName;
    String userID;
    String password;
    Roles userRole;
    String logCheck;

    public UserProfile() {
    	 lastName = "";
         firstName = "";
         userID = "";
         password = "";
         userRole = Roles.EMPTY;
         logCheck = "";
    }
    
    public boolean login(String id, String pass){
        if(userID.equals(id))
            if(pass.isEmpty() && password.isEmpty())
            {
                createPassword(pass);
            }
            else if(password.equals(pass))
                return true;

        return false;
    }

    public boolean createPassword(String pass){          //when user profile is first login
    	pass = JOptionPane.showInputDialog(null, "Enter a new password:");

        setPassword(pass);
        System.out.println(userID + ", " + password);
        return true;

    }
    
    public boolean changeRole(Object object){          
    	userRole = (Roles) object;
        return true;
    }
    
    public boolean deleteProfile(){          

    	UserDataModel.deleteUser(userID);
        return true;
    }

    public UserProfile(String ln, String fn, String id, String pass, Roles role, String check){           //constructor
        lastName = ln;
        firstName = fn;
        userID = id;
        password = pass;
        userRole = role;
        logCheck = check;
        System.out.println(userID + ", " + password + "!");
    }
    public UserProfile(UserProfile up){           //constructor
        lastName = up.lastName;
        firstName = up.firstName;
        userID = up.userID;
        password = up.password;
        userRole = up.userRole;
        logCheck = up.logCheck;
        System.out.println(userID + ", " + password + "!");
    }
    public UserProfile(String[] data) {
        for(int x = 0; x < data.length; x++) {

            lastName = data[0];
            firstName = data[1];
            userID = data[2];
            password = data[3];
            userRole = Roles.valueOf(data[4]);
            logCheck = data[5];
        }
    }
    public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if(lastName.length() <= 15)
			this.lastName = lastName;
		else JOptionPane.showMessageDialog(null, "Last name must be less than 15 charachters.");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName.length() <= 15)
			this.firstName = firstName;
		else JOptionPane.showMessageDialog(null, "First name must be less than 15 charachters.");
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		if(userID.matches("[A-Za-z0-9]+") && userID.length() <= 6)
			this.userID = userID;
		else JOptionPane.showMessageDialog(null, "UserID must be less than 6 charachters and alphanumeric.");
		
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pass) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(pass);
		if(matcher.find())
		{
			if(this.password.equals(pass))
			{
				JOptionPane.showMessageDialog(null, "User password can not be same as origional.");
			}
			else 
			{
				System.out.println(this.password);
				System.out.println(pass);
				this.password = pass;
				this.logCheck = "true";
				
				JOptionPane.showMessageDialog(null, "User password has been set!");
			}
		}
		else JOptionPane.showMessageDialog(null, "Password must be a combination of alpha numeric and special characters and minimum 8 and maximum 16 characters.");
	}

	public Roles getUserRole() {
		return userRole;
	}

	public void setUserRole(Roles userRole) {
		this.userRole = userRole;
	}
	
	public String getLogCheck() {
		return logCheck;
	}
	
	public void setLogCheck(String logCheck) {
		this.logCheck = logCheck;
	}

	public String toString() {
        String data = "";
        data += lastName + "\n";
        data += firstName + "\n";
        data += userID + "\n";
        data += password + "\n";
        data += userRole + "\n";
        data += logCheck + "\n";
        return data;
    }
}