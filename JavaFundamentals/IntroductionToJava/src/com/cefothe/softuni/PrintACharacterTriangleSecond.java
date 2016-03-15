package com.cefothe.softuni;

import java.util.Scanner;

public class PrintACharacterTriangleSecond {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int maxWeigth = Integer.parseInt(scanner.next());
	int i = 1;
	int j = maxWeigth;
	while (j > 0) {
	    if (i < maxWeigth) {
		printElement(i);
		i++;
	    } else {
		printElement(j);
		j--;
	    }
	}
    }

    public static void printElement(int numberOfElement) {
	for (char c = 'a'; c < 'a' + numberOfElement; c++) {
	    System.out.print(c + " ");
	}
	System.out.println();
    }

}
