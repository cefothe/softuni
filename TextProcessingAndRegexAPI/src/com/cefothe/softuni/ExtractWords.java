package com.cefothe.softuni;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractWords {

	public static void main(String[] args) {
		String regex = "[a-zA-Z]+";

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			System.out.print(matcher.group() + " ");
		}
	}

}
