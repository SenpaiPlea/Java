package application.model;

import java.util.concurrent.ThreadLocalRandom;



public class Dice {
	
	
	/*
	 * Attribute: sides (6).
	 * 
	 * Method: roll dice (returns 1–6).
	 */	
	
	public int roll() {
	int rollResult = ThreadLocalRandom.current().nextInt(1, 7); // 1–6
	System.out.println("Roll result is: " + rollResult);
	return rollResult;
	
	}
	
	
	
}
