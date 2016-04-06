package com.cefothe.softuni;

import java.util.Scanner;

public class CountAllWords {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] elements = scan.nextLine().toLowerCase().split("[ :,.')-_(!@#$]+");
		scan.close();
		int countMatches = elements.length;
		System.out.println(countMatches);

	}

}
