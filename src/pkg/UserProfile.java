package pkg;
import java.util.Scanner;

public class UserProfile {
    String lastName;
    String firstName;
    String userID;
    String password;
    Roles userRole;

    public UserProfile() {
    	
    }
    
    public boolean login(String id, String pass){
        if(userID.equals(id))
            if(pass.isEmpty() && password.isEmpty())
            {
                createPassword(pass); // TODO create new password
            }
            else if(password.equals(pass))
                return true;

        return false;
    }

    boolean logout(){
    	return true;
    }

    public boolean createPassword(String pass){          //when user profile is first login
        if(pass.length() >= 8 && pass.length() <= 16)
        {
            password = pass;
            System.out.println(userID + ", " + password);
            return true;
        }

        return false;
    }
    
    public boolean changeRole(Object object){          
    	userRole = (Roles) object;
        return true;
    }
    
    public boolean deleteProfile(){          

        Database.deleteUser(userID);
        return true;
    }

    public UserProfile(String ln, String fn, String id, String pass, Roles role){           //constructor
        lastName = ln;
        firstName = fn;
        userID = id;
        password = pass;
        userRole = role;
        System.out.println(userID + ", " + password + "!");

    }
    public UserProfile(UserProfile up){           //constructor
        lastName = up.lastName;
        firstName = up.firstName;
        userID = up.userID;
        password = up.password;
        userRole = up.userRole;
        System.out.println(userID + ", " + password + "!");
    }
    public UserProfile(String[] data) {
        for(int x = 0; x < data.length; x++) {

            lastName = data[0];
            firstName = data[1];
            userID = data[2];
            password = data[3];
            userRole = Roles.valueOf(data[4]);

        }
    }
    public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Roles getUserRole() {
		return userRole;
	}

	public void setUserRole(Roles userRole) {
		this.userRole = userRole;
	}

	public String toString() {
        String data = "";
        data += lastName + "\n";
        data += firstName + "\n";
        data += userID + "\n";
        data += password + "\n";
        data += userRole + "\n";
        return data;
    }
}