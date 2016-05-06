package com.cefothe.softuni.exam;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author stefanangelov
 *
 */
public class GUnit {

	private static final String PATTERN = "^([A-Z]{1}[a-zA-Z-0-9]+) \\| ([A-Z]{1}[a-zA-Z-0-9]+) \\| ([A-Z]{1}[a-zA-Z-0-9]+)$";

	public static void main(String[] args) {

		Map<String, Map<String, ArrayList<String>>> inputMap = new LinkedHashMap<>();
		inputDATA(inputMap);

		inputMap.entrySet()
				.stream()
				.sorted((first, second) -> {
					Integer result = Integer.valueOf(GUnit.numberOfJunitTest(second.getValue().values()).size())
							.compareTo(Integer.valueOf(GUnit.numberOfJunitTest(first.getValue().values()).size()));

					if (result == 0) {

						result = Integer.valueOf(first.getValue().keySet().size()).compareTo(
								Integer.valueOf(second.getValue().keySet().size()));

						if (result == 0) {
							result = first.getKey().compareTo(second.getKey());
						}
					}

					return result;
				}).forEach(current -> {
					System.out.println(String.format("%s:", current.getKey()));
					current.getValue().entrySet().stream().sorted((first, second) -> {
						Integer result = Integer.valueOf(second.getValue().size()).compareTo(first.getValue().size());
						if (result == 0) {
							result = first.getKey().compareTo(second.getKey());
						}
						return result;
					}).forEach(methods -> {
						System.out.println(String.format("##%s", methods.getKey()));
						methods.getValue().stream().sorted((first, second) -> {
							Integer result = Integer.valueOf(first.length()).compareTo(second.length());
							if (result == 0) {
								result = first.compareTo(second);
							}
							return result;
						}).forEach(test -> {
							System.out.println(String.format("####%s", test));
						});
					});
				});

	}

	private static ArrayList<String> numberOfJunitTest(Collection<ArrayList<String>> values) {
		ArrayList<String> allUnitTestInClass = new ArrayList<>();
		for (ArrayList<String> value : values) {
			for (String string : value) {
				allUnitTestInClass.add(string);
			}

		}
		return allUnitTestInClass;
	}

	private static void inputDATA(Map<String, Map<String, ArrayList<String>>> inputMap) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Pattern patter = Pattern.compile(PATTERN);

		String inputData = scanner.nextLine();
		while (!inputData.equals("It's testing time!")) {
			Matcher matcher = patter.matcher(inputData);
			if (matcher.find()) {
				String className = matcher.group(1);
				String methodName = matcher.group(2);
				String unitTestName = matcher.group(3);

				if (!inputMap.containsKey(className)) {
					Map<String, ArrayList<String>> methodNameMap = new LinkedHashMap<>();
					AddMethodName(methodNameMap, methodName, unitTestName);
					inputMap.put(className, methodNameMap);
				} else {
					Map<String, ArrayList<String>> currentClass = inputMap.get(className);
					if (!currentClass.containsKey(methodName)) {
						AddMethodName(currentClass, methodName, unitTestName);
					} else {
						AddUnitTest(unitTestName, currentClass.get(methodName));
					}
				}
			}
			inputData = scanner.nextLine();
		}
	}

	private static void AddMethodName(Map<String, ArrayList<String>> methodNameMap, String methodName,
			String unitTestName) {
		ArrayList<String> unitTestList = new ArrayList<>();
		AddUnitTest(unitTestName, unitTestList);
		methodNameMap.put(methodName, unitTestList);

	}

	private static void AddUnitTest(String unitTestName, ArrayList<String> unitTestList) {
		if (!unitTestList.contains(unitTestName)) {
			unitTestList.add(unitTestName);
		}
	}
}
