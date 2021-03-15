package guiPkg;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class MainMenu extends JPanel {
	JTabbedPane tabs;
	/**
	 * Create the panel.
	 */
	public MainMenu() {
		setLayout(new BorderLayout(0, 0));
		
		tabs = new JTabbedPane(JTabbedPane.TOP);
		add(tabs);
		
	}
	
	public void openTab(JPanel panel) {
		tabs.addTab(panel.getName(),null, panel,null);
	}
	
	

}
