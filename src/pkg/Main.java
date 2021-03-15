package pkg;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import guiPkg.*;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JComboBox;

public class Main {
	private Database db;
	private JFrame frame;
	private static projectGUI login;
	private static MainMenu menu;
	private static myPanel p1;
	private static JLayeredPane layeredPane;
	
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
		menu = new MainMenu();
		db = new Database();
		db.printVendors();
		db.printUsers();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 414, 239);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		login = new projectGUI();
		layeredPane.add(login, "1");
		
		menu = new MainMenu();
		layeredPane.add(menu, "2");
		
	}
	
	public static void swapPanel(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}

	public static void swapToMain() {
		layeredPane.removeAll();
		layeredPane.add(menu);
		layeredPane.repaint();
		layeredPane.revalidate();
		
	}
	
}
