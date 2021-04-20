package guiPkg;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.util.Date;
import java.util.Vector;

import pkg.Main;
import pkg.CustomerDataModel;
import pkg.CustomerInfo;
import pkg.CustomerProfile;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
/**
 * @author Noel Hall
 *
 */
public class CustomerListGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 732535010724844851L;
	private JTable table;
	private JTextField searchField;
	private TableRowSorter<CustomerDataModel> sorter;
	final CustomerDataModel model = Main.customerDAO;
	JScrollPane scrollPane;
	private JLabel lblSearchLabel;

	public CustomerListGUI(Vector<CustomerProfile> data) {
		setName("Customers");

		
		scrollPane = new JScrollPane();
		sorter = new TableRowSorter<CustomerDataModel>(model);
		table = new JTable(model);
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//search field
		searchField = new JTextField();
		searchField.setColumns(10);
		
		//make table
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		table.setFillsViewportHeight(true);
		table.setRowSorter(sorter);
		table.setBackground(Color.LIGHT_GRAY);

	
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

	JButton Logoutbtn = new JButton("Log out");
	Logoutbtn.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		Main.swapToLogin();
	}
});
	add(Logoutbtn);
	
	lblSearchLabel = new JLabel("Search name:");
	add(lblSearchLabel);
	add(searchField);
	add(scrollPane);
	
	}
	
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	
	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	public CustomerDataModel getModel() {
return model;
}

	private void newFilter() {
	    RowFilter<CustomerDataModel, Object> rf = null;
	    //If current expression doesn't parse, don't update.
	    try {
	        rf = RowFilter.regexFilter("(?i).*" + searchField.getText() +".*", 0);
	    } catch (java.util.regex.PatternSyntaxException e) {
	        return;
	    }
	    sorter.setRowFilter(rf);
	}
}
