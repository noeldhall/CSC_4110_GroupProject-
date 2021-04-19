package pkg;

import javax.swing.JOptionPane;

public class ItemsObserver {
	protected static ItemDataModel itemModel = Main.itemDAO;
	
	public void update()
	{
		if(itemModel.getState() > 2 && UserDataModel.currentUser.getUserRole() == Roles.PURCHASER)
		{
			JOptionPane.showMessageDialog(null, "More than two items are out of stock.");
		}
	}

}
