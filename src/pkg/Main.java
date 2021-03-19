package pkg;
import java.awt.EventQueue;
import javax.swing.JFrame;
import guiPkg.*;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Main {
	private Database db;
	private JFrame frame;
	private static loginGUI login;
	private static MainMenu menu;
	private static JLayeredPane layeredPane;
	private static VendorListGUI vendorTab;
	private static ManagerGUI manager;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					//window.frame.add(menu.$$$getRootComponent$$$());
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		initialize();
		db = new Database();
		vendorTab = new VendorListGUI(Database.vendors);
		Database.printVendors();
		Database.printUsers();
	//	db.printCustomers();
	}

	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(480, 270, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		login = new loginGUI();
		layeredPane.add(login, "1");
		
		menu = new MainMenu();
		layeredPane.add(menu, "2");
		
		manager = new ManagerGUI();
		
		
	}
	
	public static void swapPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	public static void swapToMain(Roles role) {
		layeredPane.removeAll();
		layeredPane.add(menu);
		
		switch(role) {
		case OWNER:
			menu.openTab(manager);
			menu.openTab(vendorTab);
			break;
		case ADMIN:
			menu.openTab(manager);
			break;
		case INVENTORY_MANAGER:
			menu.openTab(manager);
			break;
		case PURCHASER:
			menu.openTab(vendorTab);
			break;
		case ACCOUNTANT:
			break;
		case SALES_PERSON:
			break;
		default:
			break;
		}

		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public static void swapToLogin() {
		layeredPane.removeAll();
		layeredPane.add(login);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
}
