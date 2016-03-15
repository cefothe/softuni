package com.cefothe.softuni;

import java.util.Scanner;

public class SumNumbersFrom1ToN {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int numberOfelemnt = Integer.parseInt(scanner.next());
	Long result = 0L;

	for (; 0 < numberOfelemnt; numberOfelemnt--) {
	    result += numberOfelemnt;
	}

	System.out.println(result);
    }

}
