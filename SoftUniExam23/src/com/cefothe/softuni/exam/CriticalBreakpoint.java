package com.cefothe.softuni.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CriticalBreakpoint {

	public static Integer[] parseArguments(String arg) {
		Integer[] array = new Integer[4];
		String[] inputData = arg.split(" ");
		// Line: [x1, y1, x2, y2]
		array[0] = Integer.parseInt(inputData[0]);
		array[1] = Integer.parseInt(inputData[1]);
		array[2] = Integer.parseInt(inputData[2]);
		array[3] = Integer.parseInt(inputData[3]);

		return array;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<Integer[]> inputData = new ArrayList<>();
		String inputLine = scanner.nextLine();

		while (!inputLine.equals("Break it.")) {
			inputData.add(parseArguments(inputLine));
			inputLine = scanner.nextLine();
		}

	}

}
