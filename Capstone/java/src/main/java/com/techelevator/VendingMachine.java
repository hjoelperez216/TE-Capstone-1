package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class VendingMachine {
	
	private Inventory machineInv;
	private Money machineMoney;
	private ShoppingCart machineCart;
	private LogKeeper machineLog;
		
	
	Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());
	public static void main() throws IOException{
	
	File logFile = new File("./Log.txt");
	boolean appendToFile = true;
			
		FileWriter aFileWriter = new FileWriter(logFile, appendToFile);
		
		BufferedWriter aBufferedWriter= new BufferedWriter(aFileWriter);
		
		try (PrintWriter diskFileWriter = new PrintWriter(aBufferedWriter))
		{		
		diskFileWriter.println("");
		}
	}
	
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
	public double addMoney() throws IOException {		
		String addMoneyText = timestampNow +machineMoney.addMoneyLogLine;
		machineLog.addToLog(addMoneyText);
		return machineMoney.addMoney();
	
				}
	public void purchaseItems() {
		System.out.println("Please choose a slot: "); // requests input from user
		displayItems(); //shows user the available items
		
		Scanner userInput = new Scanner(System.in);
		String slotChoice = userInput.nextLine().toUpperCase(); //accepts user input
		if (machineMoney.getCurrentBalance()>=machineInv.getPrice(slotChoice)) {
			machineMoney.deductMoney(machineInv.getPrice(slotChoice));
			machineInv.purchaseItem(slotChoice);
		}
		else System.out.println("You do not have enough funds for this selection.");

		}
	
	public String getChange() {
		return machineMoney.makeChange();
		
	}
	public void endMethodProcessing() {
		getChange();
	}
	
	}

	