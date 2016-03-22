package com.cefothe.softuni;

import java.util.Scanner;

/**
 * 
 * @author cefothe
 *
 */
public class ConvertFromBase7ToDecimal {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String number = scanner.nextLine();
	System.out.println(Integer.toString(Integer.parseInt(number, 7), 10));
    }

}
