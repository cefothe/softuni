package com.cefothe.java.exam;

import java.math.BigDecimal;
import java.util.Scanner;

public class RoyalNonStop {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigDecimal totalMoney = new BigDecimal(0);

		/**
		 * row, cols
		 */
		Integer[] matrix = parseArgs(scanner.nextLine().split(" "));

		/**
		 * productsPrice[0] - lukanka productsPrice[1] - rakija
		 */
		Double[] productsPrice = parseArgsDouble(scanner.nextLine().split(" "));

		int numberOfCustomer = 0;

		String inputData = scanner.nextLine();
		while (!inputData.equals("Royal Close")) {
			Integer[] customerCordonats = parseArgs(inputData.split(" "));
			totalMoney = totalMoney.add(calculateCustomerAmount(customerCordonats, productsPrice, matrix));
			inputData = scanner.nextLine();
			numberOfCustomer++;

		}
		System.out.println(String.format("%.6f", totalMoney));
		System.out.println(numberOfCustomer);
	}

	private static BigDecimal goTop(Integer[] customerCordonats, Double[] productsPrice, Integer[] matrix) {
		BigDecimal currentPrice = new BigDecimal(0d);
		for (int currentRow = customerCordonats[0]; currentRow >= 1; currentRow--) {
			if (currentRow == 0 && customerCordonats[1] == 0) {

			} else {
				if (isEven(currentRow)) {
					currentPrice = currentPrice.add(new BigDecimal(currentRow + 1).multiply(
							new BigDecimal(customerCordonats[1] + 1)).multiply(new BigDecimal(productsPrice[0])));
				} else {
					currentPrice = currentPrice.add(new BigDecimal(currentRow + 1).multiply(
							new BigDecimal(customerCordonats[1] + 1)).multiply(new BigDecimal(productsPrice[1])));
				}
			}
		}
		return currentPrice;
	}

	private static BigDecimal goLeft(Integer[] customerCordonats, Double[] productsPrice, Integer[] matrix) {
		BigDecimal currentPrice = new BigDecimal(0d);
		for (int currentCell = customerCordonats[1]; currentCell >= 1; currentCell--) {
			if (currentCell == 0 && customerCordonats[0] == 0) {

			} else {
				if (isEven(customerCordonats[0])) {
					currentPrice = currentPrice.add(new BigDecimal(currentCell + 1).multiply(
							new BigDecimal(customerCordonats[0] + 1)).multiply(new BigDecimal(productsPrice[0])));
				} else {
					currentPrice = currentPrice.add(new BigDecimal(currentCell + 1).multiply(
							new BigDecimal(customerCordonats[0] + 1)).multiply(new BigDecimal(productsPrice[1])));
				}
			}
		}
		return currentPrice;
	}

	private static BigDecimal calculateCustomerAmount(Integer[] customerCordonats, Double[] productsPrice,
			Integer[] matrix) {
		BigDecimal customerPrice = new BigDecimal(0d);
		if (customerCordonats[0] >= customerCordonats[1]) {
			customerPrice = customerPrice.add(goLeft(customerCordonats, productsPrice, matrix));
			customerCordonats[1] = 0;
			customerPrice = customerPrice.add(goTop(customerCordonats, productsPrice, matrix));
		} else {
			if (customerCordonats[0] >= customerCordonats[1]) {
				customerPrice = customerPrice.add(goTop(customerCordonats, productsPrice, matrix));
				customerCordonats[0] = 0;
				customerPrice = customerPrice.add(goLeft(customerCordonats, productsPrice, matrix));
			}
		}
		return customerPrice;

	}

	public static Boolean isEven(Integer i) {
		return (i % 2) == 0;
	}

	private static Integer[] parseArgs(String[] inputArgs) {
		Integer[] parsedResults = new Integer[inputArgs.length];
		for (int i = 0; i < inputArgs.length; i++) {
			parsedResults[i] = Integer.parseInt(inputArgs[i]);
		}
		return parsedResults;
	}

	private static Double[] parseArgsDouble(String[] inputArgs) {
		Double[] parsedResults = new Double[inputArgs.length];
		for (int i = 0; i < inputArgs.length; i++) {
			parsedResults[i] = Double.parseDouble(inputArgs[i]);
		}
		return parsedResults;
	}

}
