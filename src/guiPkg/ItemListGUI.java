package guiPkg;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.TableRowSorter;

import pkg.Item;
import pkg.ItemDataModel;
import pkg.Main;
import pkg.VendorDataModel;
import pkg.VendorProfile;
import javax.swing.JLabel;
/**
 * @author Noel Hall
 *
 */
public class ItemListGUI extends JPanel {
	private static final long serialVersionUID = 8777161324173056561L;
	private JTextField searchField;

	private JTable table;
	private TableRowSorter<ItemDataModel> sorter;
	JScrollPane scrollPane ;
	JButton Logoutbtn;

	/**
	 *
	 */
	public ItemListGUI(Vector<Item> data) {
		setName("Inventory");

		
		//Variables
		ItemDataModel model=Main.itemDAO;
		scrollPane = new JScrollPane();
		table = new JTable(model);
		sorter=new TableRowSorter<ItemDataModel>(model);
		
		searchField = new JTextField();
		searchField.setColumns(10);
		setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		table.setBorder(new EmptyBorder(3,3,3,3));
		table.setFillsViewportHeight(true);
		table.setRowSorter(sorter);
		table.setBackground(Color.LIGHT_GRAY);
		
		scrollPane.getViewport().setBackground(Color.gray);
		
      searchField.getDocument().addDocumentListener(new DocumentListener() {
					@Override
					public void insertUpdate(DocumentEvent e) {
						newFilter();
					}
					@Override
					public void removeUpdate(DocumentEvent e) {
						newFilter();
					}
					@Override
					public void changedUpdate(DocumentEvent e) {
						newFilter();
					}
      });
      
		searchField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				table.clearSelection();
				searchField.setText("");
			}
		});
		
		Logoutbtn = new JButton("Log out");
		Logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.swapToLogin();
			}
		});
		add(Logoutbtn);
		
		JLabel lblSearchField = new JLabel("Search item:");
		add(lblSearchField);
		add(searchField);

		//add(scrollPane);
		
		
	}
	
	public JTable getTable() {
		return table;
	}

	private void newFilter() {
    RowFilter<ItemDataModel, Object> rf = null;
    //If current expression doesn't parse, don't update.
    try {
        rf = RowFilter.regexFilter("(?i).*" + searchField.getText() +".*", 1);
    } catch (java.util.regex.PatternSyntaxException e) {
        return;
    }
    sorter.setRowFilter(rf);
}
	
	
}
