package pkg;

import java.util.Date;

public class Item implements Data {
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
	double quantity;
	
	public Item(String[] data) {
		itemID=data[0];
		itemName=data[1];
		vendorID=data[2];
		sellPrice=Double.parseDouble(data[3]);
		itemType=ItemCategory.valueOf(data[4]);
		expires=new Date(data[5]);
		unitPrice=Double.parseDouble(data[6]);
		unitOfMeasure=data[7];
		quantity=Double.parseDouble(data[8]);
		
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
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	public String toString() {
		String data = "";
		data += itemID + "\t";
		data += itemName+"\t";
		data += sellPrice+"\t";
		data += itemType + "\t";
		data += expires.toString() + "\t";
		data+=unitPrice+"\t";
		data+=unitOfMeasure+"\t";
		data+=quantity+"\t";
		return data;
	}
	
	
}
