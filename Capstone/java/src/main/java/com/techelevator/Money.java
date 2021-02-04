package com.techelevator;

public class Money {

//private final int DEFAULTBALANCE = 0;
public int currentBalance;

public void startingBalance() {
	currentBalance = 0;
}

public void moneyAdded(int cashInserted) {
	currentBalance += cashInserted*100;
	
}

public void moneyDeducted(int itemCost) {
	currentBalance -= (itemCost*100);
}

public int getCurrentBalance() {
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
	
	int quarter = 25;
	int dime = 10;
	int nickel =5;
	int quartersReturned = 0;
	int dimesReturned = 0;
	int nickelsReturned = 0;
	
	while(currentBalance >0){
		if (currentBalance>=quarter){
			quartersReturned ++;
			currentBalance = currentBalance - quarter;
		}
		else if (currentBalance>=dime){
			dimesReturned ++;
			currentBalance = currentBalance - dime;
					}else if (currentBalance>=nickel){
			nickelsReturned ++;
			currentBalance = currentBalance - nickel;
		}
	}
	String coinsReturned = "Your change is" + quartersReturned + " quarters, " +dimesReturned + " dimes, and " +nickelsReturned +"nickels.";
	System.out.println(coinsReturned);
	
	
	
	
	
	

	return coinsReturned;



	
	
	
}
}
