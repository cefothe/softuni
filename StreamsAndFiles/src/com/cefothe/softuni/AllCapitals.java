package com.cefothe.softuni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class AllCapitals {

	public static void main(String[] args) throws IOException {
		ArrayList<String> stringArray = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("resources/line.txt"))) {
			String line = reader.readLine();
			while (line != null) {
				stringArray.add(line.toUpperCase());
				line = reader.readLine();
			}
		}

		try (FileWriter fileWriter = new FileWriter("resources/linesCapital.txt")) {
			try (PrintWriter printWriter = new PrintWriter(fileWriter, true)) {
				for (String string : stringArray) {
					printWriter.println(string);
				}
			}
		}
	}

}
