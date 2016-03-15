package com.cefothe.softuni;

import java.util.Scanner;

/**
 * 
 * @author cefothe
 *
 */
public class PrintACharacterTriangle {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int maxWeigth = Integer.parseInt(scanner.next());
	int secondCounter = maxWeigth - 1;
	for (int counter = 0; counter < maxWeigth * 2; counter++) {
	    if (counter < maxWeigth) {
		printElement(counter);
	    } else {
		printElement(--secondCounter);
	    }
	}
    }

    public static void printElement(int numberOfElement) {
	char c = 'a';
	for (int i = 0; i <= numberOfElement; i++, c++) {
	    System.out.print(c + " ");
	}
	System.out.println();
    }

}
