package com.cefothe.softuni;

import java.util.Arrays;
import java.util.Scanner;

public class SortArrayOfNumbers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int counter = Integer.parseInt(scanner.nextLine());
		int[] numbers = new int[counter];

		for (int i = 0; i < counter; i++) {
			numbers[i] = scanner.nextInt();
		}
		Arrays.sort(numbers);
		for (int i = 0; i < counter; i++) {
			System.out.print(numbers[i] + " ");
		}

	}
}
