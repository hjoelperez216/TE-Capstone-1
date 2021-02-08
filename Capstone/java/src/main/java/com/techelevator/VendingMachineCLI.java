package com.techelevator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

/**************************************************************************************************************************
*  This is your Vending Machine Command Line Interface (CLI) class
*
*  It is the main process for the Vending Machine
*
*  THIS is where most, if not all, of your Vending Machine interactions should be coded
*  
*  It is instantiated and invoked from the VendingMachineApp (main() application)
*  
*  Your code vending machine related code should be placed in here
***************************************************************************************************************************/
import com.techelevator.view.Menu;         // Gain access to Menu class provided for the Capstone

public class VendingMachineCLI {

    // Main menu options defined as constants

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE      = "Purchase";
	private static final String MAIN_MENU_SALES_REPORT      = "Sales Report";
	private static final String MAIN_MENU_OPTION_EXIT          = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS,
													    MAIN_MENU_OPTION_PURCHASE, 
													    MAIN_MENU_SALES_REPORT,
													    MAIN_MENU_OPTION_EXIT
													    };
	private static final String SUB_MENU_CURRENT_MONEY ="Current Money Provided: ";
	private static final String SUB_MENU_FEED_MONEY ="Feed Money";
	private static final String SUB_MENU_SELECT_PRODUCT ="Select Product";
	private static final String SUB_MENU_FINISH_TRANSACTION ="Finish Transaction";
	private static final String[] SUB_MENU_OPTIONS = { 
			SUB_MENU_FEED_MONEY, 
			SUB_MENU_SELECT_PRODUCT,
			SUB_MENU_FINISH_TRANSACTION
		    };
	
	private DecimalFormat formatter = new DecimalFormat("0.00");
	
	private Menu vendingMenu;              // Menu object to be used by an instance of this class
	
	public VendingMachineCLI(Menu menu) throws FileNotFoundException {  // Constructor - user will pas a menu for this class to use
		this.vendingMenu = menu;           // Make the Menu the user object passed, our Menu
		this.thisMachine = new VendingMachine();
	}
	/**************************************************************************************************************************
	*  VendingMachineCLI main processing loop
	*  
	*  Display the main menu and process option chosen
	*
	*  It is invoked from the VendingMachineApp program
	*
	*  THIS is where most, if not all, of your Vending Machine objects and interactions 
	*  should be coded
	*
	*  Methods should be defined following run() method and invoked from it
	 * @throws FileNotFoundException 
	*
	***************************************************************************************************************************/
	private VendingMachine thisMachine;//instantiates a vending machine, which will also cause the inventory to be loaded
	
	public void run() throws IOException {
		//VendingMachine thisMachine = new VendingMachine(); //instantiates a vending machine, which will also cause the inventory to be loaded
		
		boolean shouldProcess = true;         // Loop control variable
		
		while(shouldProcess) {                // Loop until user indicates they want to exit
			
			String choice = (String)vendingMenu.getChoiceFromOptions(MAIN_MENU_OPTIONS);  // Display menu and get choice
			
			switch(choice) {                  // Process based on user menu choice
			
				case MAIN_MENU_OPTION_DISPLAY_ITEMS:
					displayItems();           // invoke method to display items in Vending Machine
					break;                    // Exit switch statement
			
				case MAIN_MENU_OPTION_PURCHASE:
					purchaseItems();          // invoke method to purchase items from Vending Machine
					break;                    // Exit switch statement
					
				case MAIN_MENU_SALES_REPORT: 
					//salesreport();				//invoke method to produce the sales report from Vending Machine
					break;						//Exit switch statement
					
				case MAIN_MENU_OPTION_EXIT:
					endMethodProcessing();    // Invoke method to perform end of method processing
					shouldProcess = false;    // Set variable to end loop
					break;                    // Exit switch statement
			}	
		}
		return;                               // End method and return to caller
	}
/********************************************************************************************************
 * Methods used to perform processing
 ********************************************************************************************************/
	public void displayItems() {      // static attribute used as method is not associated with specific object instance
		thisMachine.displayItems();
	}
	
	public void purchaseItems() throws IOException {	 // static attribute used as method is not associated with specific object instance
		boolean shouldProcess = true;         // Loop control variable
		//System.out.println(SUB_MENU_CURRENT_MONEY + " $" + formatter.format(thisMachine.displayMoney()));
		while(shouldProcess) {                // Loop until user indicates they want to exit
			
			
			String choice = (String)vendingMenu.getChoiceFromOptions(SUB_MENU_OPTIONS);  // Display menu and get choice
			
			switch(choice) {                  // Process based on user menu choice
			
				case SUB_MENU_FEED_MONEY:
					
					thisMachine.addMoney();   // invoke method to add money in Vending Machine	
					System.out.println(SUB_MENU_CURRENT_MONEY + " $" + formatter.format(thisMachine.displayMoney()));
					break;                    // Exit switch statement
					
			
				case SUB_MENU_SELECT_PRODUCT:
				
					thisMachine.purchaseItems();          // invoke method to purchase items from Vending Machine
					System.out.println(SUB_MENU_CURRENT_MONEY + " $" + formatter.format(thisMachine.displayMoney()));
					break;                    // Exit switch statement
			
				case SUB_MENU_FINISH_TRANSACTION:
					
					
					//thisMachine.getChange();???
					
					thisMachine.endMethodProcessing(); // Invoke method to perform end of method processing
					shouldProcess = false;    // Set variable to end loop
					
					break;                    // Exit switch statement
			}	
		}
		
	}
	public void salesReport() {
		
	}
	
	public void endMethodProcessing() { // static attribute used as method is not associated with specific object instance
		// Any processing that needs to be done before method ends
	}
}
