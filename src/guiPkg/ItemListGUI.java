package guiPkg;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.TableRowSorter;

import pkg.Item;
import pkg.ItemDataModel;
import pkg.Main;
import pkg.VendorDataModel;
import pkg.VendorProfile;

public class ItemListGUI extends JPanel {
	private static final long serialVersionUID = 8777161324173056561L;

	private JTable table;
	private TableRowSorter<ItemDataModel> sorter;

	/**
	 * TODO: functionality of displaying all items in inventory.
	 */
	public ItemListGUI(Vector<Item> data) {
		//Variables
		ItemDataModel model=Main.itemDAO;
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable(model);
		sorter=new TableRowSorter<ItemDataModel>(model);
		//JButton btnNewButton = new JButton("New button");
		
		//JButton btnNewButton_1 = new JButton("New button");
		
		//JButton btnNewButton_2 = new JButton("New button");
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		table.setBorder(new EmptyBorder(3,3,3,3));
		table.setFillsViewportHeight(true);
		table.setRowSorter(sorter);
		
		scrollPane.getViewport().setBackground(Color.gray);
		
		JButton Logoutbtn = new JButton("Log out");
		Logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.swapToLogin();
			}
		});
		add(Logoutbtn);

		add(scrollPane);
		
		
	}


}
