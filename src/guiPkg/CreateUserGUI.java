package guiPkg;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import pkg.Database;
import pkg.Roles;
import pkg.UserDataModel;
import pkg.UserProfile;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateUserGUI extends JPanel {
	private JTextField firstNametxtField;
	private JTextField LastNametxtField;
	private JTextField UserIDtxtField;
	private JTextField PasstxtField;

	/**
	 * Create the panel.
	 */
	public CreateUserGUI(JTextField userIDMan) {
		setBackground(Color.CYAN);
		
		JLabel lblNewLabel = new JLabel("First Name:");
		
		firstNametxtField = new JTextField();
		firstNametxtField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("LastName:");
		
		LastNametxtField = new JTextField();
		LastNametxtField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("User ID:");
		
		UserIDtxtField = new JTextField();
		UserIDtxtField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		
		PasstxtField = new JTextField();
		PasstxtField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Role:");
		
		final JComboBox RolecomboBox = new JComboBox();
		RolecomboBox.setModel(new DefaultComboBoxModel(Roles.values()));
		if(Database.currentUser.getUserRole() == Roles.ADMIN)
		{
			RolecomboBox.removeItemAt(1);
			RolecomboBox.removeItemAt(1);
		}
		JButton AddUserbtn = new JButton("Add User");
		AddUserbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserProfile newUser = new UserProfile();
				newUser.setFirstName(firstNametxtField.getText());
				newUser.setLastName(LastNametxtField.getText());
				newUser.setUserID(UserIDtxtField.getText());
				newUser.setPassword(PasstxtField.getText() + "");
				newUser.setUserRole((Roles) RolecomboBox.getSelectedItem());
				newUser.setLogCheck("false");
				
				if(UserDataModel.searchIDMatch(newUser.getUserID()))
				{
					JOptionPane.showMessageDialog(null, "User profile already exists.");
				}
				else if (newUser.getFirstName() == null || newUser.getLastName() == null || newUser.getPassword() == null || newUser.getUserID() == null)
				{
					JOptionPane.showMessageDialog(null, "User profile not created.");
				}
				else
				{
					Database.users.add(newUser);
					JOptionPane.showMessageDialog(null, "User profile has been created.");
				}
			}
		});
		
		
		
		
		
		
		
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel)
								.addComponent(lblNewLabel_3)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_2)
									.addGap(10)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(PasstxtField, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(firstNametxtField, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(lblNewLabel_1))
										.addGroup(groupLayout.createSequentialGroup()
											.addComponent(UserIDtxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblNewLabel_4)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(RolecomboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(LastNametxtField, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(187)
							.addComponent(AddUserbtn)))
					.addContainerGap(32, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(firstNametxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1)
						.addComponent(LastNametxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(PasstxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(UserIDtxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(RolecomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
					.addComponent(AddUserbtn)
					.addGap(34))
		);
		setLayout(groupLayout);
		
	}
}
