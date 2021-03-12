package pkg;
import java.util.Date;
import java.util.Scanner;

public class UserProfile {
    String lastName;
    String firstName;
    String userID;
    String password;
    Roles userRole;

    boolean login(String id, String pass){
        if(userID.equals(id))
            if(pass.isEmpty() && password.isEmpty())
            {
                System.out.println("Type new password: ");

                Scanner scanner = new Scanner(System.in);
                pass = scanner.nextLine();
                createPassword(pass); // TODO create new password
                //scanner.close();
            }
            else if(password.equals(pass))
                return true;

        return false;
    }

    boolean logout(){
    	return true;
    }

    boolean createPassword(String pass){          //when user profile is first login
        if(pass.length() >= 8 && pass.length() <= 16)
        {
            password = pass;
            System.out.println(userID + ", " + password + "!");
            return true;
        }

        return false;
    }

    public UserProfile(String ln, String fn, String id, String pass, Roles role){           //constructor
        lastName = ln;
        firstName = fn;
        userID = id;
        password = pass;
        userRole = role;
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