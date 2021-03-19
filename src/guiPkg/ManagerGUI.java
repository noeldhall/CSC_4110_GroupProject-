package guiPkg;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import pkg.Database;
import pkg.Main;
import pkg.PersonalInformation;
import pkg.Roles;
import pkg.UserProfile;
import pkg.VendorProfile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ManagerGUI extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextField UserIDtxtField;
	private JTextField txtPassReset;
	private JButton btnNewButton;

	/**
	 * Create the panel.
	 */
	public ManagerGUI() {

		setName("Manager");
		setBackground(Color.CYAN);
		
		JLabel lblNewLabel = new JLabel("Enter User ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		UserIDtxtField = new JTextField();
		UserIDtxtField.setColumns(10);
		
		btnNewButton = new JButton("Display User List");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserTableGUI UserTab = new UserTableGUI(Database.users);
				JOptionPane.showMessageDialog(null, UserTab,"User Data Table",JOptionPane.PLAIN_MESSAGE);
			}
		});
		
		JButton btnCreateProfile = new JButton("Create User Profile");
		btnCreateProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUserGUI makeUserProfilePanel = new CreateUserGUI(UserIDtxtField);
				JOptionPane.showMessageDialog(null, makeUserProfilePanel, "Create User Profile", JOptionPane.CLOSED_OPTION);
			}
		});
		
		JButton btnNewButton_3 = new JButton("Update User Profile");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Database.currentUser.getUserRole() == Roles.ADMIN && Database.findUser(UserIDtxtField.getText()).getUserRole() != Roles.OWNER)
				{
					UpdateUserGUI updateUserProfilePanel = new UpdateUserGUI(UserIDtxtField);
					JOptionPane.showMessageDialog(null, updateUserProfilePanel, "Update User Profile", JOptionPane.CLOSED_OPTION);
				}
				else if(Database.currentUser.getUserRole() == Roles.OWNER)
				{
					UpdateUserGUI updateUserProfilePanel = new UpdateUserGUI(UserIDtxtField);
					JOptionPane.showMessageDialog(null, updateUserProfilePanel, "Update User Profile", JOptionPane.CLOSED_OPTION);
				}
				else JOptionPane.showMessageDialog(null, "You cannot alter an owner's profile.");
			}
		});
		
		JButton PassResetbtn = new JButton("Reset Password");
		PassResetbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Database.currentUser.getUserRole() == Roles.ADMIN && Database.findUser(UserIDtxtField.getText()).getUserRole() != Roles.OWNER)
				{
					if(Database.findUser(UserIDtxtField.getText()).createPassword(txtPassReset.getText()))
						JOptionPane.showMessageDialog(null, "User password has been reset!");
				}
				else if(Database.currentUser.getUserRole() == Roles.OWNER) 
				{
					if(Database.findUser(UserIDtxtField.getText()).createPassword(txtPassReset.getText()))
						JOptionPane.showMessageDialog(null, "User password has been reset!");
				}
				else JOptionPane.showMessageDialog(null, "You cannot alter an owner's profile.");
			}
		});
		
		txtPassReset = new JTextField();
		txtPassReset.setColumns(10);
		
		JButton btnDeleteUser = new JButton("Delete User Profile");
		btnDeleteUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Database.currentUser.getUserRole() == Roles.ADMIN && Database.findUser(UserIDtxtField.getText()).getUserRole() != Roles.OWNER)
				{
					if(Database.findUser(UserIDtxtField.getText()).deleteProfile())
						JOptionPane.showMessageDialog(null, "User profile has been deleted.");		
				}
				else if(Database.currentUser.getUserRole() == Roles.OWNER)
				{
					if(Database.findUser(UserIDtxtField.getText()).deleteProfile())
						JOptionPane.showMessageDialog(null, "User profile has been deleted.");
				}
				else JOptionPane.showMessageDialog(null, "You cannot alter an owner's profile.");
			}
		});
		
		JButton btnNewButton_2 = new JButton("Log out");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.swapToLogin();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(492)
							.addComponent(btnNewButton_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnNewButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
								.addComponent(btnCreateProfile, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
							.addGap(316))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(UserIDtxtField, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
							.addGap(74))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(PassResetbtn, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
								.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
								.addComponent(btnDeleteUser, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtPassReset, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
							.addGap(73)))
					.addGap(239))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addComponent(lblNewLabel)
					.addContainerGap(606, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(44)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(UserIDtxtField, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCreateProfile, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
					.addGap(5)
					.addComponent(btnNewButton_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(PassResetbtn)
						.addComponent(txtPassReset, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(76)
					.addComponent(btnDeleteUser)
					.addGap(49)
					.addComponent(btnNewButton_2)
					.addGap(136))
		);
		setLayout(groupLayout);

	}
}
