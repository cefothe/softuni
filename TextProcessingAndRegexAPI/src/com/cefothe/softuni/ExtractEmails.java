package com.cefothe.softuni;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {

	public static void main(String[] args) {
		String regex = "(?<=\\s|^)([a-z0-9]+[A-Za-z0-9+_.-]+@+[a-z.]*[a-z])";

		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}

}
