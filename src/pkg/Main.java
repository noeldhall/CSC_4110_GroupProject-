package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
//
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		Database db = new Database();
		db.printVendors();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
/*
        ---DONT DELETE---
		 * This main will be a temporary testing ground for our objects.
		 * Feel free to delete/ add test code at your leisure here
		 * This main will not be included in the final project because we'll require GUI implementation
		 * later down the road.
		 * -nick
		---END DONT DELETE---

		Database db = new Database();
		db.printVendors();
	}


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
*/
}
