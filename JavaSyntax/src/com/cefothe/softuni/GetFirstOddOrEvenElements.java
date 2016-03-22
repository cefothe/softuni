package com.cefothe.softuni;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author cefothe
 *
 */

public class GetFirstOddOrEvenElements {

    public static String convertArrayToString(ArrayList<String> result) {
	return result.toString().replace("[", "").replace("]", "").replace(", ", " ");
    }

    public static String oddElement(String[] numbers, int count) {
	int counter = 0;
	ArrayList<String> results = new ArrayList<>();

	for (int i = 0; i < numbers.length; i++) {
	    if (Integer.parseInt(numbers[i]) % 2 == 1) {
		counter++;
		results.add(numbers[i]);
	    }
	    if (counter == count) {
		break;
	    }
	}
	return convertArrayToString(results);
    }

    public static String evenElement(String[] numbers, int count) {
	int counter = 0;
	ArrayList<String> results = new ArrayList<>();

	for (int i = 0; i < numbers.length; i++) {
	    if (Integer.parseInt(numbers[i]) % 2 == 0) {
		counter++;
		results.add(numbers[i]);
	    }
	    if (counter == count) {
		break;
	    }
	}
	return convertArrayToString(results);
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String[] numbers = scanner.nextLine().trim().split(" ");
	String[] command = scanner.nextLine().trim().split(" ");
	int count = Integer.parseInt(command[1]);
	switch (command[2]) {
	case "odd":
	    System.out.println(oddElement(numbers, count));
	    break;
	case "even":
	    System.out.println(evenElement(numbers, count));
	    break;
	default:
	    throw new IllegalArgumentException("We don't support this operations");
	}
    }

}
