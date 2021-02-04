package com.techelevator;

public class VendingMachine {
	
	private Inventory machineInv;
	private Money machineMoney;
	private ShoppingCart machineCart;
	private LogKeeper machineLog;
	
	public VendingMachine (Inventory machineInv, Money machineMoney, ShoppingCart machineCart, LogKeeper machineLog) {
		this.machineInv		=	machineInv;
		this.machineMoney	=	machineMoney;
		this.machineCart	=	machineCart;
		this.machineLog		=	machineLog;
			}

}
