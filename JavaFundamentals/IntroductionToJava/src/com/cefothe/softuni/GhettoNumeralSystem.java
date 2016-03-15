package com.cefothe.softuni;

import java.util.Scanner;

public class GhettoNumeralSystem {

    public static void main(String[] args) {
	String[] toppings = { "Gee", "Bro", "Zuz", "Ma", "Duh", "Yo", "Dis", "Hood", "Jam", "Mack" };
	Scanner scanner = new Scanner(System.in);
	String number = scanner.nextLine();
	StringBuilder result = new StringBuilder();
	for (int i = 0; i < number.length(); i++) {
	    result.append(toppings[Integer.parseInt(number.substring(i, i + 1))]);
	}
	System.out.println(result.toString());
    }
}
