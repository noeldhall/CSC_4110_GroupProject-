package pkg;
import java.util.Scanner;

class Main{
	public static void main(String[] args){
	    UserProfile profile = new UserProfile("Nick", "Foster", "111111", "", Roles.OWNER);
	    Scanner in = new Scanner(System.in);
	    String username, password;
	    
	    do {
		    System.out.println("enter username: ");
		    username = in.nextLine();
		    
		    System.out.println("Enter password: ");
		    password = in.nextLine();	
	    }while(!profile.login(username, password));
        
	    System.out.println("Good Job Sport!");
	    
	    in.close();
	}
}