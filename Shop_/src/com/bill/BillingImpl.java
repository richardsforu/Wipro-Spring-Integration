package com.bill;

import com.price.F2Inter;
import com.price.PriceMatrix;
import com.price.PriceMatrixImpl;

//Dependent
public class BillingImpl {

	/*
	 * Dedign Issues --------------------- 1. Too many Dependency obj creations -->
	 * Per gets down
	 * 
	 * Why this Problem? ------------------- --> Creating a Dependency obj in
	 * Dependent.
	 * 
	 * Solution? ------------ 1. Do not create Dependency obj in Dependent class. 2.
	 * Insted ask some one to provide --> JNDI --> loc of jndi tightly binded with
	 * dependent clas
	 * 
	 * Best Solution ------------------ -> DO not create, and Do not search , and
	 * ask some one (IOC) -> Inject Dependency obj to Dependent (DI)
	 * 
	 * 
	 * 
	 * 
	 */

	private PriceMatrix price;
	private F2Inter f2;
	

	public void setF2(F2Inter f2) {
		this.f2 = f2;
	}

	public void setPrice(PriceMatrix price) {
		this.price = price;
	}

	public double checkOut(String[] cart) {
		// PriceMatrix price;
		// price= new PriceMatrixImpl();

		double tot = 0.0;
		for (String itemCode : cart) {

			tot = tot + price.getItemPrice(itemCode);

		}

		return tot;

	}

}
