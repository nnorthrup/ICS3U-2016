package com.bayviewglen.dayfive;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("Write what you got on you test followed by what it was out of (with a space between the two): ");
		Scanner keyboard;

		keyboard = new Scanner(System.in);
		double digit1 = keyboard.nextDouble();
		double digit2 = keyboard.nextDouble();
		
		double Percent = (digit1 / digit2 * 100);
		
		System.out.print(Percent);
		
	}

}
