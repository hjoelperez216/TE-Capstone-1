package com.techelevator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Scanner;

public class LogKeeper {
	static String logText = "";
	public static String addToLog(String textToBeAdded) {
		logText = logText + textToBeAdded;
		return logText;
	}
	Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());
	public static void main() throws IOException{
	File logFile = new File("./Log.txt");
	boolean appendToFile = true;
			
		FileWriter aFileWriter = new FileWriter(logFile, appendToFile);
		
		BufferedWriter aBufferedWriter= new BufferedWriter(aFileWriter);
		
		try (PrintWriter diskFileWriter = new PrintWriter(aBufferedWriter))
		{		
		diskFileWriter.println(logText);
		}
	}
//public void addMoneyEntry (String amountAdded) {
	//diskFileWriter.println(timestampNow + "FEED MONEY" +amountAdded);
	}
	
	
	

