package com.techelevator;

import java.util.Scanner;

public class Money {

//private final int DEFAULTBALANCE = 0;
public double currentBalance;

public double startingBalance() {
	return currentBalance = 0;
	
}

public double addMoney () {
	System.out.println("Please enter the amount you are feeding: $1.00, $2.00, $5.00 or $10.00.");
	//String [] acceptableBills = new String [] {"$1.00", "$2.00", "$5.00", "$10.00"};
	Scanner userInput = new Scanner(System.in);
	String userText= userInput.nextLine();
	double userAmount = Double.valueOf(userText);
		if(userAmount == 1.00|| userAmount == 2.00 || userAmount ==5.00 || userAmount ==10.00) {
			Double moneyFed = userAmount;
			currentBalance += moneyFed;
		}
		else {
			System.out.println("The amount entered is invalid. Please enter $1.00, $2.00, $5.00 or $10.00.");
		}
		
		return currentBalance;
	}
	


public void deductMoney(double itemCost) {
	if(currentBalance >= itemCost) {
	currentBalance -= (itemCost);
	}
	else {
		System.out.println("You don't have enough funds for this selection.");
	}
}

public double getCurrentBalance() {
	return currentBalance;
}

public String makeChange() {
	
	
//	int quarter = 25;
//	int dime = 10;
//	int nickel = 5;
//	int quartersReturned = getCurrentBalance()/quarter;
//	int dimesReturned = getCurrentBalance()/dime;
//	int nickelsReturned = getCurrentBalance()/nickel;
	
//	if(getCurrentBalance()%quarter==0) {
//		newBalance = getCurrentBalance()-(quartersReturned*quarter);
//		return quartersReturned;
//	} else if((getCurrentBalance()-(quarter*quartersReturned))%dime==0) {
//		
//	}
	
	double quarter = .25;
	double dime = .10;
	double nickel =.05;
	int quartersReturned = 0;
	int dimesReturned = 0;
	int nickelsReturned = 0;
	
	quartersReturned = (int) (currentBalance/quarter);
	currentBalance = currentBalance -(quartersReturned*quarter);
	dimesReturned = (int) (currentBalance/dime);
	currentBalance = currentBalance - (dimesReturned*dime);
	nickelsReturned = (int) (currentBalance/nickel);
	currentBalance = currentBalance/nickel;
	

	String coinsReturned = "Your change is " + quartersReturned + " quarters, " +dimesReturned + " dimes, and " +nickelsReturned +" nickels.";
	System.out.println(coinsReturned);
	
	
	
	
	
	

	return coinsReturned;



	
	
	
}
}
