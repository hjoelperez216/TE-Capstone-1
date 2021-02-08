package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Scanner;

public class VendingMachine {
	
	private Inventory machineInv;
	private Money machineMoney;
	private ShoppingCart machineCart;
	
		
	private DecimalFormat formatter = new DecimalFormat("0.00");
	
	Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());
	//public static void main() throws IOException{
	
		public void addToLog (String logLine) throws IOException {
			File logFile = new File("./Log.txt");
			boolean appendToFile = true;
					
			FileWriter aFileWriter = new FileWriter(logFile, appendToFile);
				
			BufferedWriter aBufferedWriter= new BufferedWriter(aFileWriter);
				
			try (PrintWriter diskFileWriter = new PrintWriter(aBufferedWriter))
			{		
			diskFileWriter.println(logLine);
			}
		}
	
	
	public VendingMachine () throws FileNotFoundException {
		this.machineInv		=	new Inventory();
		this.machineMoney	=	new Money();
		this.machineCart	=	new ShoppingCart();
	
		}
	public void displayItems() {
		machineInv.displayInventory();
		
	}
	public double displayMoney() {
		return machineMoney.getCurrentBalance();
	}
	public double addMoney() throws IOException {	
		machineMoney.addMoney();
		addToLog (timestampNow + "FEED MONEY $"+ formatter.format(machineMoney.userAmount)+ " $"+formatter.format(machineMoney.currentBalance));
		return machineMoney.currentBalance;
	
				}
	public void purchaseItems() throws IOException {
		System.out.println("Please choose a slot: "); // requests input from user
		displayItems(); //shows user the available items
		
		Scanner userInput = new Scanner(System.in);
		String slotChoice = userInput.nextLine().toUpperCase(); //accepts user input
		if (machineMoney.getCurrentBalance()>=machineInv.getPrice(slotChoice)) {
			machineMoney.deductMoney(machineInv.getPrice(slotChoice));
			machineInv.purchaseItem(slotChoice);
		addToLog(timestampNow + machineInv.machineInv.get(slotChoice).itemName() 
				+ " " +slotChoice+ " " + "$" +
				formatter.format((machineMoney.currentBalance+machineInv.machineInv.get(slotChoice).price))+ " "+ "$" + formatter.format(machineMoney.currentBalance));
		}
		else System.out.println("You do not have enough funds for this selection.");

		}
	
	public String getChange() throws IOException {
		addToLog(timestampNow + " GIVE CHANGE: " + "$" + formatter.format(machineMoney.currentBalance) + " $0.00");
		return machineMoney.makeChange();
		}
	
	public void salesReport() throws IOException {
		
	}
	public void exitPurchaseMenu() throws IOException {
		getChange();
	}
	
	}

	