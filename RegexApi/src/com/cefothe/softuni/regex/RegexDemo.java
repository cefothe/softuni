package com.cefothe.softuni.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String text = " text +358 894-9483";
		Pattern pattern = Pattern.compile("[a-z]+");
		Matcher matcher = pattern.matcher(text);

		while (matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
