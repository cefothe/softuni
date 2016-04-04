package com.cefothe.softuni;

import java.util.Arrays;
import java.util.Scanner;

public class SortArrayWithStreamApi {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String[] numbers = scanner.nextLine().split("\\s+");
	String sorting = scanner.nextLine();
	if (sorting.equals("Ascending")) {
	    Arrays.stream(numbers).map(d -> Integer.parseInt(d)).sorted((d1, d2) -> d1.compareTo(d2))
		    .forEach(d -> System.out.print(d + " "));
	} else if (sorting.equals("Descending")) {
	    Arrays.stream(numbers).map(d -> Integer.parseInt(d)).sorted((d1, d2) -> d2.compareTo(d1))
		    .forEach(d -> System.out.print(d + " "));
	}
    }

}
