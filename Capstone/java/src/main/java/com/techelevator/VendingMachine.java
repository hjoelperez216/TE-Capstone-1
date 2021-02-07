package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachine {
	
	private Inventory machineInv;
	private Money machineMoney;
	private ShoppingCart machineCart;
	private LogKeeper machineLog;
		
	
	public VendingMachine () throws FileNotFoundException {
		this.machineInv		=	new Inventory();
		this.machineMoney	=	new Money();
		this.machineCart	=	new ShoppingCart();
		this.machineLog		=	new LogKeeper();
		}
	public void displayItems() {
		machineInv.displayInventory();
		
	}
	public double displayMoney() {
		return machineMoney.getCurrentBalance();
	}
	public double addMoney() {		
								
		return machineMoney.addMoney();
				}
	public void purchaseItems() {
		System.out.println("Please choose a slot: "); // requests input from user
		displayItems(); //shows user the available items
		
		Scanner userInput = new Scanner(System.in);
		String slotChoice = userInput.nextLine().toUpperCase(); //accepts user input
		machineInv.purchaseItem(slotChoice);
		machineMoney.deductMoney(machineInv.getPrice(slotChoice));
		
		
		//need to run a purchase item method in Inventory, using slotChoice as input
		
		//return machineMoney.purchaseItem(slotChoice);
		//need to run a purchase item method in Money using the price of the item
		//need to add the selected item to the shopping cart
		//need to add the selected item to LogKeeper?
		}
	}

	