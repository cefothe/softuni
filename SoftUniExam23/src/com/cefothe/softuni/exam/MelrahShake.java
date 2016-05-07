package com.cefothe.softuni.exam;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author stefanangelov
 *
 */
public class MelrahShake {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String inputData = scanner.nextLine();
		String pattern = scanner.nextLine();

		while (!inputData.isEmpty() && countStringInString(inputData, pattern) >= 2 && !pattern.isEmpty()) {
			System.out.println("Shaked it.");
			inputData = inputData.substring(0, inputData.indexOf(pattern))
					+ inputData.substring(inputData.indexOf(pattern) + pattern.length(), inputData.length());
			inputData = inputData.substring(0, inputData.lastIndexOf(pattern))
					+ inputData.substring(inputData.lastIndexOf(pattern) + pattern.length(), inputData.length());
			pattern = patternRefactor(pattern);
		}
		System.out.println("No shake.");
		System.out.println(inputData);
	}

	public static String patternRefactor(String pattern) {
		int index = pattern.length() / 2;
		return removeCharAt(pattern, index);
	}

	public static String removeCharAt(String s, int i) {
		StringBuffer buf = new StringBuffer();
		if (i >= 0) {
			buf.append(s.substring(0, i)).append(s.substring(i + 1));

		}
		return buf.toString();
	}

	public static long countStringInString(String inputData, String inputPattern) {
		Pattern pattern = Pattern.compile(Pattern.quote(inputPattern));
		Matcher matcher = pattern.matcher(inputData);
		long count = 0;
		while (matcher.find()) {
			count++;
		}
		return count;
	}
}