package com.cefothe.java.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Royalism {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputData = scanner.nextLine();

		List<String> inputArray = new ArrayList<String>(Arrays.asList(inputData.split(" ")));
		List<String> royalOn = new ArrayList<String>();
		List<String> royalOf = new ArrayList<String>();
		for (String input : inputArray) {

			int sumOfAssciCode = 0;
			for (int i = 0; i < input.length(); i++) {
				sumOfAssciCode += input.charAt(i);
				while (true) {
					if (sumOfAssciCode >= 26) {
						sumOfAssciCode -= 26;
					} else {
						break;
					}
				}

			}
			if (sumOfAssciCode == 18) {
				royalOn.add(input);
			} else {
				royalOf.add(input);
			}
		}

		if (royalOn.size() >= royalOf.size()) {
			System.out.println("Royalists - " + royalOn.size());
			printAllElementInList(royalOn);
			System.out.println("All hail Royal!");
		} else {

			printAllElementInList(royalOf);
			System.out.println("Royalism, Declined!");

		}

	}

	public static void printAllElementInList(List<String> data) {
		for (String input : data) {
			System.out.println(input);
		}
	}
}
