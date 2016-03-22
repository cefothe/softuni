package com.cefothe.softuni;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * @author cefothe
 *
 */
public class RandomizeNumbersFromNToM {

    public static int randomNumber(int min, int max) {
	return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int min = scanner.nextInt();
	int max = scanner.nextInt();

	// change max and min
	if (min > max) {
	    int x = max;
	    max = min;
	    min = x;
	}

	ArrayList<String> result = new ArrayList<>();
	for (int i = 0; i <= max - min; i++) {
	    result.add(Integer.toString(randomNumber(min, max)));
	}

	System.out.println(result.toString().replace("[", "").replace("]", "").replace(", ", " "));

    }

}
