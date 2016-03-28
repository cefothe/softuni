package com.cefothe.softuni;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		try (BufferedReader reader = new BufferedReader(new FileReader("resources/line.txt"))) {
			String line = reader.readLine();
			while (line != null) {
				int symbolTotalCount = 0;
				for (int i = 0; i < line.length(); i++) {
					symbolTotalCount += line.charAt(i);
				}
				System.out.println(symbolTotalCount);
				line = reader.readLine();
			}
		}

	}

}
