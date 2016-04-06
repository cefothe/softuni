package com.cefothe.softuni;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSpecifiedWord {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine().replaceAll("[ :,.')(!@#$]+", " ");
		String regex = scanner.nextLine();

		Pattern pattern = Pattern.compile("(?<=\\s|^)" + regex + "(?=$|\\s)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);

		int countOfWord = 0;
		while (matcher.find()) {
			countOfWord++;
		}
		System.out.println(countOfWord);

	}

}
