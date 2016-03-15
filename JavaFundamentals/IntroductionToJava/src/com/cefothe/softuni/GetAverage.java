package com.cefothe.softuni;

import java.util.Arrays;
import java.util.Scanner;

public class GetAverage {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	double[] NUMBER = new double[3];
	NUMBER[0] = Double.parseDouble(scanner.nextLine());
	NUMBER[1] = Double.parseDouble(scanner.nextLine());
	NUMBER[2] = Double.parseDouble(scanner.nextLine());

	System.out.format("%.2f", Arrays.stream(NUMBER).average().getAsDouble());
    }

}
