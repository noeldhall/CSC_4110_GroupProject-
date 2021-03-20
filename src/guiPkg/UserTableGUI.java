package guiPkg;

import java.awt.BorderLayout;
import java.util.Vector;
//import org.apache.commons.dbutils.DbUtils;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.lang.Class;
import javax.swing.RowFilter;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import pkg.UserProfile;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserTableGUI extends JPanel {
	private static final long serialVersionUID = 7727161324173086559L;
	JTable table;
	private JTextField SearchtxtField;
	/**
	 * Create the panel.
	 */
	public UserTableGUI(Vector<UserProfile> data) {
		UserTableModel model = new UserTableModel(data);
		JScrollPane scrollPane = new JScrollPane();
		table = new JTable(model);
		table.setBorder(new EmptyBorder(5, 5, 5, 5));
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		final TableRowSorter<TableModel> search = new TableRowSorter<>(table.getModel());
		JLabel lblNewLabel = new JLabel("Search:");
		table.setRowSorter(search);
		SearchtxtField = new JTextField();
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
		SearchtxtField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(53)
							.addComponent(lblNewLabel)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(SearchtxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(SearchtxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
