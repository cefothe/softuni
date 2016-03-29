package com.cefothe.softuni;

import java.util.ArrayList;
import java.util.Scanner;

public class SequencesOfEqualStrings {

	public static void printArrayList(ArrayList<String> list) {
		if (!list.isEmpty()) {
			for (String string : list) {
				System.out.print(string + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] inputs = scanner.nextLine().split(" ");

		ArrayList<String> temp = new ArrayList<String>();
		for (String input : inputs) {
			if (temp.contains(input)) {
				temp.add(input);
			} else {
				printArrayList(temp);
				temp.clear();
				temp.add(input);
			}
		}

		printArrayList(temp);

	}
}
