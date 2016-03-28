package com.cefothe.softuni;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CounterCharacterType {

	public static void main(String[] args) {
		Locale.setDefault(new Locale("en", "EN"));
		File countChars = new File("resources/count-chars.txt");

		try (BufferedReader reader = new BufferedReader(new FileReader("resources/words.txt"))) {
			String line = reader.readLine();
			List<String> lineArray = new ArrayList<>();

			while (line != null) {
				lineArray.add(line);
				line = reader.readLine();
			}

			reader.close();
			System.out.println("words.txt successfully loaded!");

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(countChars))) {

				String[] array = new String[lineArray.size()];
				int countVowels = 0;
				int countConsonants = 0;
				int countPunctuation = 0;

				for (int i = 0; i < lineArray.size(); i++) {
					array[i] = lineArray.get(i);
					String inspectLine = array[i];
					for (int j = 0; j < inspectLine.length(); j++) {
						switch (inspectLine.charAt(j)) {
						case 'a':
							countVowels += 1;
							break;
						case 'e':
							countVowels += 1;
							break;
						case 'i':
							countVowels += 1;
							break;
						case 'o':
							countVowels += 1;
							break;
						case 'u':
							countVowels += 1;
							break;
						case ' ':
							break;
						case '!':
							countPunctuation += 1;
							break;
						case ',':
							countPunctuation += 1;
							break;
						case '.':
							countPunctuation += 1;
							break;
						case '?':
							countPunctuation += 1;
							break;
						default:
							countConsonants += 1;
							break;
						}
					}
				}

				writer.write("Vowels: " + countVowels);
				writer.newLine();
				writer.write("Consonants: " + countConsonants);
				writer.newLine();
				writer.write("Punctuation: " + countPunctuation);

				writer.close();
				System.out.print("count-chars.txt successfully created!");
			}
		} catch (FileNotFoundException fileNotFoundEx) {
			System.out.print("Error: File Not Found!");
		} catch (IOException inputOutputEx) {
			System.out.print("Error: Invalid file!");
		}
	}

}
