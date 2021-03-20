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
	private static VendorSearchGUI supplierTab;
	private static DefaultLoginGUI defaultLogin;
	private static CustomerListGUI customerTab;
	private static CustomerSearchGUI customerSearchTab;
	
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
		customerTab=new CustomerListGUI(Database.customers);
		Database.printVendors();
		Database.printUsers();
		Database.printCustomers();
	}

	private void initialize() {
		frame = new JFrame("Group 5 Term Project");
		
		frame.setBounds(480, 270, 800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setResizable(false);
		
		layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		login = new loginGUI();
		layeredPane.add(login, "1");
		
		menu = new MainMenu();
		layeredPane.add(menu, "2");
		
		manager = new ManagerGUI();
		supplierTab = new VendorSearchGUI();
		customerSearchTab=new CustomerSearchGUI(); 

	
	}
	
	public static void swapPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	public static void swapToMain(Roles role) {
		manager = new ManagerGUI();
		menu = new MainMenu();
		login = new loginGUI();
		layeredPane.removeAll();
		layeredPane.add(menu);
		
		switch(role) {
		case OWNER:
			menu.openTab(manager);
			menu.openTab(vendorTab);
			menu.openTab(customerTab);
			menu.openTab(customerSearchTab);
			break;
		case ADMIN:
			menu.openTab(manager);
			break;
		case INVENTORY_MANAGER:
			defaultLogin = new DefaultLoginGUI();
			swapPanel(defaultLogin);
			break;
		case PURCHASER:
			menu.openTab(supplierTab);
			break;
		case ACCOUNTANT:
			defaultLogin = new DefaultLoginGUI();
			swapPanel(defaultLogin);
			break;
		case SALES_PERSON:
			defaultLogin = new DefaultLoginGUI();
			swapPanel(defaultLogin);
			break;
		default:
			break;
		}

		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public static void swapToLogin() {
		menu.clearTabs();
		layeredPane.removeAll();
		layeredPane.add(login);
		layeredPane.repaint();
		layeredPane.revalidate();
		
		Database.currentUser = null;
	}
}