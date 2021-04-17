package guiPkg;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class PurchaserGUI extends JPanel {
	public PurchaserGUI() {
		
		searchTxt = new JTextField();
		searchTxt.setColumns(10);
		
		JButton searchBtn = new JButton("Vendor Search");
		
		JButton makeOrderBtn = new JButton("New Purchase Order");
		makeOrderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(makeOrderBtn, Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(searchTxt, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(searchBtn))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(searchTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchBtn))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(makeOrderBtn)
					.addContainerGap())
		);
		
		JComboBox vendorBox = new JComboBox();
		scrollPane.setViewportView(vendorBox);
		setLayout(groupLayout);
	}

	/**
	 * Author: Nicholas Foster
	 */
	private static final long serialVersionUID = 3360425635918542473L;
	private JTextField searchTxt;
}
