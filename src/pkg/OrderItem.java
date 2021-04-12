/**
 * 
 */
package pkg;

import java.util.Date;

/**
 * @author Noel Hall
 *
 */
public class OrderItem {
	
	public OrderItem() {
		
	}
	
	public double calculateSubtotal() {
		return subtotal;
	}
	
	private Date needByDate;
	private Date orderDate;
	private int quantity;
	private Item item;
	private double subtotal;
	public Date getNeedByDate() {
		return needByDate;
	}

	public void setNeedByDate(Date needByDate) {
		this.needByDate = needByDate;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
