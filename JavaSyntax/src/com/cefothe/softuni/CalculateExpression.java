package com.cefothe.softuni;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author cefothe
 *
 */
public class CalculateExpression {

    public static double firstFormula(double a, double b, double c) {
	double base = (Math.pow(a, 2) + Math.pow(b, 2)) / (Math.pow(a, 2) - Math.pow(b, 2));
	double step = (a + b + c) / Math.sqrt(c);
	return Math.pow(base, step);
    }

    public static double secondFormula(double a, double b, double c) {
	double base = Math.pow(a, 2) + Math.pow(b, 2) - Math.pow(c, 3);
	double step = a - b;
	return Math.pow(base, step);
    }

    public static double diff(double a, double b, double c) {
	return Math.abs(Arrays.stream(new double[] { a, b, c }).average().getAsDouble() - Arrays
		.stream(new double[] { firstFormula(a, b, c), secondFormula(a, b, c) }).average().getAsDouble());
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	double a = scanner.nextDouble();
	double b = scanner.nextDouble();
	double c = scanner.nextDouble();

	System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", firstFormula(a, b, c), secondFormula(a, b, c),
		diff(a, b, c));

    }

}
