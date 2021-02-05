package com.techelevator;

public class Slot {
	int quantity;
	Item item;
	double price;
	
	public Slot (int quantity, Item item, double price) {
		this.quantity = quantity;
		this.item = item;
		this.price = price;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @return the item
	 */
	public Item getItem() {
		return item;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Slot [quantity=" + quantity + ", item=" + item + ", price=" + price + "]";
	}	
		
}
