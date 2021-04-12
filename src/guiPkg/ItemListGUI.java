package guiPkg;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;

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
	private JTable table;
	private TableRowSorter<ItemDataModel> sorter;

	/**
	 * TODO: functionality of displaying all items in inventory.
	 */
	public ItemListGUI(Vector<Item> data) {
		
		ItemDataModel model=Main.itemDAO;
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable(model);
		sorter=new TableRowSorter<ItemDataModel>(model);
		JButton btnNewButton = new JButton("New button");
		
		JButton btnNewButton_1 = new JButton("New button");
		
		JButton btnNewButton_2 = new JButton("New button");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(80)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(btnNewButton)
					.addGap(5)
					.addComponent(btnNewButton_1)
					.addGap(5)
					.addComponent(btnNewButton_2))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(16)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton_1))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(btnNewButton_2))
		);
		setLayout(groupLayout);

	}


}
