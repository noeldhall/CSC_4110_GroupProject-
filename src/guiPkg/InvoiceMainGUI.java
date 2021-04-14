package guiPkg;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import pkg.CustomerDataModel;
import pkg.CustomerProfile;
import pkg.InvoiceDataModel;
import pkg.Main;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class InvoiceMainGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField SearchtxtField;
	private JTable table;
	private TableRowSorter<InvoiceDataModel> sorter;
	/**
	 * Create the panel.
	 */
	public InvoiceMainGUI(Vector<CustomerProfile> data) {
		setName("Accountant");
		JLabel lblNewLabel = new JLabel("Search:");
		final InvoiceDataModel model = Main.customerInvoiceDAO;
		JScrollPane scrollPane = new JScrollPane();
		SearchtxtField = new JTextField();
		SearchtxtField.setColumns(10);
		
		
		table = new JTable(model);
		
		
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		table.setFillsViewportHeight(true);
		
		final TableRowSorter<TableModel> search = new TableRowSorter<>(table.getModel());
		table.setRowSorter(search);
		SearchtxtField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
                String text = SearchtxtField.getText();

                if (text.trim().length() == 0) {
                	search.setRowFilter(null);
                } else {
                	search.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
			}
		});
		
		JButton LogOutButton = new JButton("Log Out");
		LogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.swapToLogin();
			}
		});
		
		
		
		JButton ViewOrdersbtn = new JButton("View Orders");
		ViewOrdersbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InvoiceOrdersGUI UserTab = new InvoiceOrdersGUI();
				JOptionPane.showMessageDialog(null, UserTab,"Customer Orders Page",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JButton ViewInvoicesbtn = new JButton("View Invoices");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(10)
							.addComponent(SearchtxtField, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(70)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(ViewInvoicesbtn)
										.addComponent(ViewOrdersbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(82)
									.addComponent(LogOutButton)))
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(SearchtxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(2)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(28)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(50)
							.addComponent(ViewOrdersbtn)
							.addGap(54)
							.addComponent(ViewInvoicesbtn)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(LogOutButton))))
		);
		
//		table = new JTable();
//		table.setFillsViewportHeight(true);
//		table.setBorder(new EmptyBorder(0, 0, 0, 0));
//		table.setModel(new DefaultTableModel(
//			new Object[][] {
//			},
//			new String[] {
//				"Customers:"
//			}
//		));
//		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}
}
