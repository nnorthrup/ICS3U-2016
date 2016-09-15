package com.bayviewglen.dayfive;

import java.util.Scanner;

public class scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("write a number that will be squared : ");
		Scanner keyboard;

		keyboard = new Scanner(System.in);

		double digit1 = keyboard.nextInt();
		double square = (digit1 * digit1);
		System.out.print(square);
	}

}
