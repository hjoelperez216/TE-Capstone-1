package com.techelevator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

public class Inventory {//create the class
	private String invName;
	private Map <String[], Integer> machineInv; //will have a string array from the data file as key, the value is the quantity in stock
	private static final int DEFAULT_STARTING_STOCK = 5;
	private int currentStock;
	
	
	//create constructors
		//default constructor
	public Inventory () {
		invName = null;
		machineInv = null;
	}
	}
	

//	public Inventory (String invName, String dataFileName) throws FileNotFoundException {
//
//	
//	
//		this.leagueName = leagueName; //.this required because the paramater has the same name as data name
//		//load the data from the file given as an arguement into our leagueMembers
//		//load the data from the file given into leagueMembers using member function
//		loadFile(dataFileName);// run the loadFile method sending the file to be loaded
//}
