package com.cefothe.java.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Cart {

	String symbol;
	String suits;

	public Cart(String symbol, String suits) {
		this.suits = suits;
		this.symbol = symbol;
	}

}

public class RoyalFlush {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfRow = Integer.parseInt(scanner.nextLine());
		StringBuilder inputString = new StringBuilder();
		List<Cart> cartList = new ArrayList<Cart>();
		List<String> flush = Arrays.asList(new String[] { "10", "J", "Q", "K", "A" });
		List<String> foundFlush = new ArrayList<String>();
		while (numberOfRow != 0) {
			inputString.append(scanner.nextLine());
			numberOfRow--;
		}

		String PATTERN = "([0-9A-Z]+[cdhs])";
		Pattern patter = Pattern.compile(PATTERN);
		Matcher matcher = patter.matcher(inputString.toString());

		while (matcher.find()) {
			String currentCart = matcher.group();
			cartList.add(new Cart(currentCart.substring(0, currentCart.length() - 1), currentCart.substring(
					currentCart.length() - 1, currentCart.length())));
		}

		for (int index = 0; index < cartList.size(); index++) {
			Cart currentCart = cartList.get(index);
			if (!currentCart.symbol.equals(flush.get(0)))
				continue;
			int indexFlust = 1;
			for (int nextCart = index + 1; nextCart < cartList.size(); nextCart++) {
				Cart nextCartvalue = cartList.get(nextCart);
				if (!nextCartvalue.suits.equals(currentCart.suits)) {
					continue;
				} else {
					if (nextCartvalue.symbol.equals(flush.get(indexFlust))) {
						indexFlust++;
						if (indexFlust == 5)
							break;
					} else {
						break;
					}
				}
			}
			if (indexFlust == 5) {
				switch (currentCart.suits) {
				case "c":
					foundFlush.add("Royal Flush Found - " + "Clubs");
					break;
				case "d":
					foundFlush.add("Royal Flush Found - " + "Diamonds");
					break;
				case "h":
					foundFlush.add("Royal Flush Found - " + "Hearts");
					break;
				case "s":
					foundFlush.add("Royal Flush Found - " + "Spades");
					break;
				}
			}
		}

		for (String found : foundFlush) {
			System.out.println(found);
		}
		System.out.println("Royal's Royal Flushes - " + foundFlush.size() + ".");
	}
}
