package pkg;
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

    boolean createPassword(String pass){          //when user profile is first loggin
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
}
