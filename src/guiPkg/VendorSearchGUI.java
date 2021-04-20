package guiPkg;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import pkg.Main;
import pkg.PersonalInformation;
import pkg.VendorDataModel;
import pkg.VendorProfile;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

//Authored by Nicholas Foster

@SuppressWarnings("serial")
public class VendorSearchGUI extends JPanel {
	public VendorSearchGUI() {
		setName("Supplier");
		JLabel vendorLbl = new JLabel("Vendor Profile:");
		vendorLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		JButton addVendorBtn = new JButton("New Vendor");
		JButton deleteVendorBtn = new JButton("Delete Vendor");
		JButton searchIDBtn = new JButton("Search by ID");
		JButton searchNameBtn = new JButton("Search by Name");
		final VendorProfileGUI subPanel = new VendorProfileGUI();
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.swapToLogin();
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(vendorLbl, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(searchNameBtn, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(addVendorBtn, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(deleteVendorBtn, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(searchIDBtn, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnNewButton)))
							.addGap(2))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(subPanel, GroupLayout.PREFERRED_SIZE, 436, Short.MAX_VALUE)
							.addGap(4)))
					.addGap(71))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addVendorBtn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteVendorBtn, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchIDBtn, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(vendorLbl, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchNameBtn))
					.addGap(14)
					.addComponent(subPanel, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
		addVendorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddVendorGUI makeVendorPanel = new AddVendorGUI();
				if(JOptionPane.showConfirmDialog(null, makeVendorPanel, "Create Vendor", JOptionPane.OK_CANCEL_OPTION) == 0) {
					VendorProfile vp = new VendorProfile(new PersonalInformation(makeVendorPanel.getName(), makeVendorPanel.getStreet(), makeVendorPanel.getCity(), makeVendorPanel.getState(), makeVendorPanel.getPhone()));
					VendorDataModel.insertVendor(vp);
					subPanel.setFields(vp);
				}
			}
		});
		
		deleteVendorBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(subPanel.getProfile() != null) {
					VendorDataModel.deleteVendor(subPanel.getProfile());
				}
				else {
					JOptionPane.showMessageDialog(null, "Error - Must have a profile selected to delete. Please note only vendors with a balance of $0.00 are eligible for deletion.", "Deletion Error", JOptionPane.OK_OPTION);
				}
			}
		});
		
		searchIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = JOptionPane.showInputDialog(null, "Please Input a Vendor ID to search for:");
				VendorProfile vp = VendorDataModel.searchVendorID(id);
				if(vp != null) {
					subPanel.setFields(vp);
				}
				else {
					JOptionPane.showMessageDialog(null, "No Vendor found with id: " + id, "No Vendor Found", JOptionPane.OK_OPTION);
				}
			}
		});
		
		searchNameBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(null, "Please Input a Vendor Name to search for:");
				VendorProfile vp = VendorDataModel.searchVendorName(name);
				if(vp != null) {
					subPanel.setFields(vp);
				}
				else {
					JOptionPane.showMessageDialog(null, "No Vendor found with name: " + name, "No Vendor Found", JOptionPane.OK_OPTION);
				}
			}
		});
		
	}
}
