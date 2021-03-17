package guiPkg;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import pkg.UserProfile;

public class UserTableGUI extends JPanel {
	private static final long serialVersionUID = 7727161324173086559L;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public UserTableGUI(Vector<UserProfile> data) {
		UserTableModel model = new UserTableModel(data);
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);
		table = new JTable(model);
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
	}

}
