package com.cefothe.softuni;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountSubstringOccurrences {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String input = scanner.nextLine();
		String regex = scanner.nextLine();

		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);

		int countOfWord = 0;
		while (matcher.find()) {
			input = input.substring(matcher.start() + 1);
			matcher = pattern.matcher(input);
			countOfWord++;
		}
		System.out.println(countOfWord);

	}

}
