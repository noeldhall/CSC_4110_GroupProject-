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
import pkg.UserProfile;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdateUserGUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField firstNametxtField;
	private JTextField LastNametxtField;
	private JTextField UserIDtxtField;
	private JTextField PasstxtField;

	/**
	 * Create the panel.
	 */
	public UpdateUserGUI(JTextField userIDMan) {
		setBackground(Color.CYAN);
		//ManagerGUI userIDMan = new ManagerGUI();
		
		JLabel lblNewLabel = new JLabel("First Name:");
		
		firstNametxtField = new JTextField();
		firstNametxtField.setColumns(10);
		
		firstNametxtField.setText(Database.findUser(userIDMan.getText()).getFirstName());
		
		JLabel lblNewLabel_1 = new JLabel("LastName:");
		
		LastNametxtField = new JTextField();
		LastNametxtField.setColumns(10);
		
		LastNametxtField.setText(Database.findUser(userIDMan.getText()).getLastName());
		
		JLabel lblNewLabel_2 = new JLabel("User ID:");
		
		UserIDtxtField = new JTextField();
		UserIDtxtField.setColumns(10);
		
		UserIDtxtField.setText(Database.findUser(userIDMan.getText()).getUserID());
		
		JLabel lblNewLabel_3 = new JLabel("Password:");
		
		PasstxtField = new JTextField();
		PasstxtField.setColumns(10);
		
		PasstxtField.setText(Database.findUser(userIDMan.getText()).getPassword());
		
		JLabel lblNewLabel_4 = new JLabel("Role:");
		
		JComboBox RolecomboBox = new JComboBox();
		RolecomboBox.setModel(new DefaultComboBoxModel(Roles.values()));
		RolecomboBox.setSelectedItem(Database.findUser(userIDMan.getText()).getUserRole());
			
		JButton UpdateUserbtn = new JButton("Update Profile");
		UpdateUserbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName = firstNametxtField.getText();
				String lastName = LastNametxtField.getText();
				String userID = UserIDtxtField.getText();
				String password = PasstxtField.getText();
				Object selectedRole = RolecomboBox.getSelectedItem();
				
				Database.findUser(userIDMan.getText()).setFirstName(firstName);
				Database.findUser(userIDMan.getText()).setLastName(lastName);
				Database.findUser(userIDMan.getText()).setPassword(password);
				Database.findUser(userIDMan.getText()).setUserRole((Roles) selectedRole);
				Database.findUser(userIDMan.getText()).setUserID(userID);
				JOptionPane.showMessageDialog(null, "User profile has been updated.");				
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
							.addComponent(UpdateUserbtn)))
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
					.addComponent(UpdateUserbtn)
					.addGap(34))
		);
		setLayout(groupLayout);
		
	}
}
