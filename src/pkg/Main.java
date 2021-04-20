package pkg;
import java.awt.EventQueue;
import javax.swing.JFrame;
import guiPkg.*;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class Main {
	public static final VendorDataModel vendorDAO = new VendorDataModel(VendorProfile.class, "data\\Feature3_dummyData.txt");
	public static final UserDataModel userDAO = new UserDataModel(UserProfile.class, "data\\Login_and_Logout_User_Data.txt");
	public static final ItemDataModel itemDAO = new ItemDataModel(Item.class, "data\\Items_profile_dummy_data.txt");
	public static final CustomerDataModel customerDAO=new CustomerDataModel(CustomerProfile.class,"data\\Customer Profiles Data.txt");
	public static final InvoiceDataModel customerInvoiceDAO=new InvoiceDataModel(CustomerProfile.class,"data\\Customer Profiles Data.txt");
	public static final CustomerOrderDataModel customerOrderDAO=new CustomerOrderDataModel(CustomerOrder.class,"data\\Customer_order_dummyData.txt");
	public static final PurchaseOrderDataModel purchaseOrderDAO = new PurchaseOrderDataModel(PurchaseOrder.class, "data\\PurchaseOrderDummyData.txt");
	public static final CustomerInvoice newInvoice = new CustomerInvoice();
	
	private JFrame frame;
	private static loginGUI login;
	private static MainMenu menu;
	private static JLayeredPane layeredPane;
	private static VendorListGUI vendorTab;
	private static ManagerGUI manager;
	private static VendorSearchGUI supplierTab;
	private static DefaultLoginGUI defaultLogin;
	private static OwnerCustomerListGUI customerTab;
	private static SalesCustomerListGUI salesCustomerTab;
	private static CustomerSearchGUI customerSearchTab;
	private static ItemListGUI itemTab;
	private static PurchaserGUI purchaserTab;
	public static CustomerOrderItemListGUI customerOrderItemTab;
	private static InvoiceMainGUI invoiceTab;
	
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
		System.out.println("finprint");
		vendorTab=new VendorListGUI(VendorDataModel.getDatabase());
		customerTab=new OwnerCustomerListGUI(CustomerDataModel.getDatabase());
		setSalesCustomerTab(new SalesCustomerListGUI(CustomerDataModel.getDatabase()));
		salesCustomerTab.attach(customerOrderItemTab);
				invoiceTab = new InvoiceMainGUI(CustomerDataModel.getDatabase());
				
		invoiceTab = new InvoiceMainGUI(CustomerDataModel.getDatabase());
		itemTab=new ItemListGUI(ItemDataModel.getDatabase());
		purchaserTab = new PurchaserGUI();
		customerOrderItemTab=new CustomerOrderItemListGUI(ItemDataModel.getDatabase());
		salesCustomerTab.attach(customerOrderItemTab);
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
		
		setMenu(new MainMenu());
		layeredPane.add(getMenu(), "2");
		
		manager = new ManagerGUI();
		supplierTab = new VendorSearchGUI();
		customerSearchTab=new CustomerSearchGUI(); 
		ItemDataModel.attach(new ItemsObserver());
		CustomerOrderDataModel.attach(new OrdersObserver());
	
	}
	
	public static void swapPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	public static void swapToMain(Roles role) {
		manager = new ManagerGUI();
		setMenu(new MainMenu());
		login = new loginGUI();
		layeredPane.removeAll();
		layeredPane.add(getMenu());
		
		switch(role) {
		case OWNER:
			getMenu().openTab(manager);
			getMenu().openTab(vendorTab);
			getMenu().openTab(customerTab);
			getMenu().openTab(customerSearchTab);
			getMenu().openTab(invoiceTab);
			getMenu().openTab(supplierTab);
			break;
		case ADMIN:
			getMenu().openTab(manager);
			break;
		case INVENTORY_MANAGER:
			defaultLogin = new DefaultLoginGUI();
			swapPanel(defaultLogin);
			break;
		case PURCHASER:
			getMenu().openTab(purchaserTab);
			getMenu().openTab(supplierTab);
			break;
		case ACCOUNTANT:
			getMenu().openTab(invoiceTab);
			break;
		case SALES_PERSON:
			getMenu().openTab(salesCustomerTab);
			customerOrderItemTab.expiredCheck();
			
			break;
		default:
			break;
		}

		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public static void swapToLogin() {
		getMenu().clearTabs();
		layeredPane.removeAll();
		layeredPane.add(login);
		layeredPane.repaint();
		layeredPane.revalidate();
		
		UserDataModel.currentUser = null;
	}

	public static MainMenu getMenu() {
		return menu;
	}

	public static void setMenu(MainMenu menu) {
		Main.menu = menu;
	}

	public static SalesCustomerListGUI getSalesCustomerTab() {
		return salesCustomerTab;
	}

	public static void setSalesCustomerTab(SalesCustomerListGUI salesCustomerTab) {
		Main.salesCustomerTab = salesCustomerTab;
	}

	public static CustomerOrderItemListGUI getCustomerOrderItemTab() {
		return customerOrderItemTab;
	}

	public static void setCustomerOrderItemTab(CustomerOrderItemListGUI customerOrderItemTab) {
		Main.customerOrderItemTab = customerOrderItemTab;
	}
}