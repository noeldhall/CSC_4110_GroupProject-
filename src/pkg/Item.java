package pkg;

//Authored by Nicholas Foster

import java.util.Date;

import javax.swing.JOptionPane;

public class Item implements Data, Comparable<Item> {
	//Disclaimer:
	//Feature 4 was never fully implemented, we did features 1-3 in sprint 1 because we only have 3 team members
	//because of this, this is not fully featured per the documentation, it is merely a skeleton class to be utilized by
	//our database objects so we can implement our features for sprint 2
	String itemID;
	String itemName;
	String vendorID;
	double sellPrice;
	ItemCategory itemType;
	Date expires;
	double unitPrice;
	String unitOfMeasure;
	double balanceOnHand;
	int check = 0;
	
	public Item()
	{
		
	}
	public Item(String[] data) {
		itemID=data[0];
		itemName=data[1];
		vendorID=data[2];
		sellPrice=Double.parseDouble(data[3]);
		itemType=ItemCategory.valueOf(data[4]);
		expires=new Date(data[5]);
		unitPrice=Double.parseDouble(data[6]);
		unitOfMeasure=data[7];
		balanceOnHand=Double.parseDouble(data[8]);
		
	}
	public Item(Item it) {
		//simple copy constructor
		itemID = it.itemID;
		itemName = it.itemName;
		vendorID = it.vendorID;
		sellPrice = it.sellPrice;
		itemType = it.itemType;
		expires = it.expires;
		unitPrice = it.unitPrice;
		unitOfMeasure = it.unitOfMeasure;
		balanceOnHand = it.balanceOnHand;
	}
	
	public String getItemID() {
		return itemID;
	}
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getVendorID() {
		return vendorID;
	}
	public void setVendorID(String vendorID) {
		this.vendorID = vendorID;
	}
	public double getSellPrice() {
		return sellPrice;
	}
	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}
	public ItemCategory getItemType() {
		return itemType;
	}
	public void setItemType(ItemCategory itemType) {
		this.itemType = itemType;
	}
	public Date getExpires() {
		return expires;
	}
	public void setExpires(Date expires) {
		this.expires = expires;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double price) {
		this.unitPrice = price;
	}
	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}
	public double getBalanceOnHand() {
		return balanceOnHand;
	}
	public void setBalanceOnHand(double quantity) {
		
		this.balanceOnHand = quantity;
		
		if (balanceOnHand <= 0)
		{
			ItemDataModel.setState(1);
		}

	}
//	public void update()
//	{
//		if (balanceOnHand <= 0)
//		{
//			check++;
//			if(check > 2 && UserDataModel.currentUser.getUserRole() == Roles.PURCHASER)
//			{
//				JOptionPane.showMessageDialog(null, "More than two items are out of stock.");
//			}
//		}
//	}

	
	public String toString() {
		String data = "";
		data += itemID + "\t";
		data += itemName+"\t";
		data += sellPrice+"\t";
		data += itemType + "\t";
		data += expires.toString() + "\t";
		data+=unitPrice+"\t";
		data+=unitOfMeasure+"\t";
		data+=balanceOnHand+"\t";
		return data;
	}
	@Override
	public int compareTo(Item o) {
		//itemID's are stored as strings but are numeric in nature.
		//by making itemID a primary key of sorts, we can subtract itemID's
		//if 0, they are equivalent objects. if <0, o.itemID is larger. If >0, o.itemID is smaller.
		return Integer.parseInt(o.itemID) - Integer.parseInt(itemID);
	}
	
	
}
