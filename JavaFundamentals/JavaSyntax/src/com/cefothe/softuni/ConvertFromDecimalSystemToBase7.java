package com.cefothe.softuni;

import java.util.Scanner;

/**
 * 
 * @author cefothe
 *
 */
public class ConvertFromDecimalSystemToBase7 {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	int number = scanner.nextInt();
	System.out.println(Integer.toString(number, 7));
    }

}
