package com.cefothe.softuni;

import java.util.Scanner;

/**
 * 
 * @author cefothe
 *
 */
public class CharacterMultiplier {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String firstString = scanner.next();
	String secondString = scanner.next();
	Long totalSumOfCharactersMultiplication = multiplyingTheCharacters(firstString, secondString);
	System.out.print(totalSumOfCharactersMultiplication);

    }

    public static Long multiplyingTheCharacters(String firstString, String secondString) {
	Long totalSum = 0L;
	for (int i = 0; i < firstString.length(); i++) {
	    totalSum += firstString.charAt(i) * secondString.charAt(i);
	}
	totalSum += remainingCharacterCodes(firstString, secondString);

	return totalSum;
    }

    public static Long remainingCharacterCodes(String firstString, String secondString) {
	Long totalSumOfRemainder = 0L;
	if (firstString.length() > secondString.length()) {
	    totalSumOfRemainder += calculationSum(firstString, secondString);
	} else if (secondString.length() > firstString.length()) {
	    totalSumOfRemainder += calculationSum(secondString, firstString);
	}
	return totalSumOfRemainder;
    }

    public static Long calculationSum(String first, String second) {
	Long total = 0L;
	String remainder = first.substring(second.length());
	for (int i = 0; i < remainder.length(); i++) {
	    total += remainder.charAt(i);
	}

	return total;
    }
}
