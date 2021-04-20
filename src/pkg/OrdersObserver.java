package pkg;

//Authored by Brett Gloomis

import javax.swing.JOptionPane;

public class OrdersObserver {
	protected static CustomerOrderDataModel orderModel = Main.customerOrderDAO;
	
	public void update()
	{
		if(orderModel.getState() > 2 && UserDataModel.currentUser.getUserRole() == Roles.ACCOUNTANT)
		{
			JOptionPane.showMessageDialog(null, "More than two orders are available.");
		}
	}

}