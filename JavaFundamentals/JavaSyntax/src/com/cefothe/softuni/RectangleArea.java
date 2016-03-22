package com.cefothe.softuni;

import java.util.Scanner;

/**
 * 
 * @author cefothe
 *
 */
public class RectangleArea {

    public static double calculateRectangleArea(double a, double b) {
	return a * b;
    }

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	double a = scanner.nextDouble();
	double b = scanner.nextDouble();
	System.out.printf("%.f", calculateRectangleArea(a, b));
    }

}
