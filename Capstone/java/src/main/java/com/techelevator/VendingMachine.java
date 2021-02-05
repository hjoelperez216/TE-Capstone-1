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
		Scanner userInput = new Scanner(System.in);
		while (userInput.equals("1")) {
		machineMoney.addMoney();
		}
		userInput.close();
		return machineMoney.addMoney();
	}
	public purchaseItems() {
	achineInv.purchaseItems();
	}
}