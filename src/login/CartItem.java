/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author sajit
 */
public class CartItem {
   private String product;
	private int quantity;
	private double price;
 
	//constructor
	public CartItem()
	{
		product = "";
		quantity = 0;
		price = 0.0;
	}
	public String getProduct()
	{
	return product;
	}
	public double getPrice()
	{
	return price;
	}
	public int getQuantity()
	{
	return quantity;
	}
 
	//constructor with parameters
	public CartItem(String inProduct, int inQuant, double inPrice)
	{
		product = new String(inProduct);
		quantity = inQuant;
		price = inPrice;
	}
	//getter setter public methods for each instance data
	public boolean equals(CartItem item)
	{
		//write the code for the equals method
		//return true;
		boolean result = false;
		if (this.product.equalsIgnoreCase(item.getProduct()) && this.price == item.getPrice())
			result = true;
		else
			result = false;
 
		return result;
	}
 
	public String toString()
	{
		//write code for toString method
		String result="";
 
		return result;
	} 
}
