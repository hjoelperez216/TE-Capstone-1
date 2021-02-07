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
	public static void main(String[] args) throws IOException{
	
//	File myFile = new File("./Log.txt");
//	
//	if (!myFile.exists() || !myFile.isFile()) {
//		System.out.println("path specified for input file is not an existing file");
//		System.exit(16);   // terminate program with a return code 16
//	}
	
	File logFile = new File("Log.txt");
	
	//boolean appendToFile = true;
	
//	if (logFile.exists()) { // if the file exists...
	if (logFile.exists()) {
		
		FileWriter aFileWriter = new FileWriter(logFile);
		
		BufferedWriter aBufferedWriter= new BufferedWriter(aFileWriter);
		
		try (PrintWriter newLogFile = new PrintWriter(logFile))
		{		
		//Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());
		
		newLogFile.println("Hello");
		}
	}else {
		logFile.createNewFile();
	}
	}
	
	

}

