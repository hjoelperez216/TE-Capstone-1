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
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.text.DecimalFormat;



public class Inventory {//create the class
	public Map <String, Slot> machineInv; //will have a string id , the value is the quantity in stock
	private static final int DEFAULT_STARTING_STOCK = 5;
	//private int currentStock;
	private DecimalFormat formatter = new DecimalFormat("0.00");
	
	Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());
	//create constructors
		//default constructor
	public Inventory () throws FileNotFoundException {
	machineInv = new TreeMap<String, Slot>();
		loadFile("vendingmachine.csv");
	}
	
private void loadFile (String fileNameToLoad) throws FileNotFoundException {
	File aFile = new File (fileNameToLoad);
	Scanner inputDataFile = new Scanner (aFile);
	String slotID = null;
	String itemName = null;
	Double price = 0.0;
	String type = null;
	
		while (inputDataFile.hasNext()) {
			String aLine = inputDataFile.nextLine();
			String [] valuesInLine = aLine.split("\\|");
			
			slotID = valuesInLine[0];
			itemName = valuesInLine[1];
			price = Double.parseDouble(valuesInLine[2]);
			type = valuesInLine[3];
			//now we have all the data out of the file
			//need to add it to the map
				//need the slot id and the slot
			Item anItem = new Item(itemName, type);
			Slot aSlot = new Slot(DEFAULT_STARTING_STOCK, anItem, price);
			
			machineInv.put(slotID, aSlot);
		} inputDataFile.close();
}
		public void displayInventory() {
			Set<String> theKeys = machineInv.keySet();
			for(String anElement : theKeys) {  // Loop through theKeys one at a time assigning the current key to anElement
				Slot theValue = machineInv.get(anElement);   // get the value for current key and store it in theValue
				System.out.println(anElement + " " + theValue);  	
			}
		}
		
		public void purchaseItem (String slotChoice) throws IOException {
			// search the map to confirm the slot number is valid
			String theName = machineInv.get(slotChoice).itemName();
			double thePrice = machineInv.get(slotChoice).price;
			if (machineInv.containsKey(slotChoice)){
				//Set<Slot> theSlots = (Set<Slot>) machineInv.values();
				machineInv.get(slotChoice).decreaseQuantity();
				String itemType = machineInv.get(slotChoice).itemType();
				//boolean shouldProcess = true;
				//while (shouldProcess) {
				//switch (itemType) {
				
					if (itemType.contains("Chip")){
						System.out.println("Crunch, Crunch, Yum!");	
						System.out.println("You purchased " + theName + " for $" +formatter.format(thePrice)+".");
					}
					else if(itemType.contains("Candy")){  
						System.out.println("Munch, Munch, Yum!");
						System.out.println("You purchased " + theName + " for $" +formatter.format(thePrice)+".");
					}
					else if (itemType.contains("Drink")){
						System.out.println("Glug, Glug, Yum!");
						System.out.println("You purchased " + theName + " for $" +formatter.format(thePrice)+".");
					}
					else if (itemType.contains("Gum")){
						System.out.println("Chew, Chew, Yum!");
						System.out.println("You purchased " + theName + " for $" +formatter.format(thePrice)+".");
					}
					
					
				}				
			else {
				System.out.println("That selection was not valid. Please select a valid slot.");
			}
		}
							
		public double getPrice(String slotChoice) {
			
			double itemPrice = machineInv.get(slotChoice).getPrice();
			return itemPrice;
		}
		
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
					
}
			
			
