package com.cefothe.softuni;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterArray {

    public static void main(String[] args) {

	Scanner scanner = new Scanner(System.in);
	String[] words = scanner.nextLine().split("\\s+");
	List<String> filterWord = Arrays.stream(words).filter(w -> w.length() > 3).collect(Collectors.toList());
	if (filterWord.isEmpty()) {
	    System.out.println("(empty)");
	} else {
	    System.out.println(filterWord.toString().replace("[", "").replace("]", "").replace(",", ""));
	}
    }
}
