package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Inventory {//create the class
	public Map <String, Slot> machineInv; //will have a string id , the value is the quantity in stock
	private static final int DEFAULT_STARTING_STOCK = 5;
	//private int currentStock;
	
	
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
				System.out.println(anElement + " " + theValue);  // Display the person's name and where they live	
			}
		}
		
		public void purchaseItem (String slotChoice) {
			// search the map to confirm the slot number is valid
			if (machineInv.containsKey(slotChoice)){
				//Set<Slot> theSlots = (Set<Slot>) machineInv.values();
				
				slotChoice.
				
				machineInv.containsKey(slotChoice).
				machineInv.decreaseQuantity();
				
			}
			else {
				System.out.println("That selection was not valid. Please select a valid slot.");
			}
			//Set <String> theKeys = machineInv.keySet();
			//for (String anElement : theKeys) {
			//	Slot theValue = machineInv.get(anElement);
			//			if (theValue.equals(slotNumber)) {
							//do the stuff that happens when slot is valid
							// if the slot does exist, dispense the item =>reduce the quantity in Slot (index 0)
							//run the Slot method decrease quantity on the value for the key that equals slotNumber
			//				theValue.decreaseQuantity();
							
						}
					
			}
			
			
