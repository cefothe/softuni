package com.cefothe.java.exam;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Employee {
	BigDecimal amount;
	Integer workHoursPerDay;

	public Employee(BigDecimal amount, Integer workHoursPerDa) {
		this.amount = amount;
		this.workHoursPerDay = workHoursPerDa;
	}
}

public class RoyalAccounting {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String PATTERN = "^([A-Za-z][A-Za-z]+);([0-9]+);([0-9]+(\\.[0-9]+)?);([A-Za-z][A-Za-z0-9!.?]+)$";
		Pattern patter = Pattern.compile(PATTERN);
		Map<String, LinkedHashMap<String, Employee>> data = new LinkedHashMap<>();
		String inputData = scanner.nextLine();

		while (!inputData.equals("Pishi kuf i da si hodim")) {
			Matcher matcher = patter.matcher(inputData);
			if (matcher.find()) {
				String employeeName = matcher.group(1);
				String workHoursPerDay = matcher.group(2);
				String dailyPayment = matcher.group(3);
				String team = matcher.group(5);

				if (!data.containsKey(team)) {
					LinkedHashMap<String, Employee> teamMap = new LinkedHashMap<>();
					if (!checkEmploy(data, employeeName)) {
						teamMap.put(employeeName, new Employee(calculateFirstPart(workHoursPerDay, dailyPayment),
								Integer.parseInt(workHoursPerDay)));
						data.put(team, teamMap);
					}
				} else {
					LinkedHashMap<String, Employee> teamMap = data.get(team);
					if (!checkEmploy(data, employeeName)) {
						teamMap.put(employeeName, new Employee(calculateFirstPart(workHoursPerDay, dailyPayment),
								Integer.parseInt(workHoursPerDay)));
						data.put(team, teamMap);
					}
				}

			}
			inputData = scanner.nextLine();
		}
		Map<String, LinkedHashMap<String, Employee>> sortData = data.entrySet().stream().sorted((first, second) -> {
			LinkedHashMap<String, Employee> firstData = first.getValue();
			BigDecimal sumFirst = new BigDecimal(0d);
			for (Entry<String, Employee> resultsFirst : firstData.entrySet()) {
				sumFirst = sumFirst.add(resultsFirst.getValue().amount).multiply(new BigDecimal(30d));
			}
			LinkedHashMap<String, Employee> secondData = second.getValue();
			BigDecimal sumSecond = new BigDecimal(0d);
			for (Entry<String, Employee> resultsSecond : secondData.entrySet()) {
				sumSecond = sumSecond.add(resultsSecond.getValue().amount).multiply(new BigDecimal(30d));

			}
			int result = sumSecond.compareTo(sumFirst);
			return result;
		})// Same collecting method.
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> {
					throw new AssertionError();
				}, LinkedHashMap::new));

		print(sortData);
	}

	public static boolean checkEmploy(Map<String, LinkedHashMap<String, Employee>> data, String newUser) {
		for (Entry<String, LinkedHashMap<String, Employee>> team : data.entrySet()) {
			for (Entry<String, Employee> currentPeople : team.getValue().entrySet()) {
				if (currentPeople.getKey().equals(newUser)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void print(Map<String, LinkedHashMap<String, Employee>> data) {
		for (Entry<String, LinkedHashMap<String, Employee>> team : data.entrySet()) {
			System.out.println("Team - " + team.getKey());
			LinkedHashMap<String, Employee> people = team.getValue().entrySet().stream().sorted((first, second) -> {

				int result = second.getValue().workHoursPerDay.compareTo(first.getValue().workHoursPerDay);
				if (result == 0) {
					result = second.getValue().amount.compareTo(first.getValue().amount);
					if (result == 0) {
						result = first.getKey().compareTo(second.getKey());
					}
				}
				return result;
			})// Same collecting method.
					.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> {
						throw new AssertionError();
					}, LinkedHashMap::new));
			for (Entry<String, Employee> currentPeople : people.entrySet()) {
				System.out.println("$$$" + currentPeople.getKey() + " - " + currentPeople.getValue().workHoursPerDay
						+ " - " + String.format("%.6f", currentPeople.getValue().amount));
			}

		}
	}

	public static BigDecimal calculateFirstPart(String workHoursPerDay, String dailyPayment) {
		BigDecimal calcul = new BigDecimal(0d);
		Integer workHours = Integer.parseInt(workHoursPerDay);
		Double daily = Double.parseDouble(dailyPayment);
		return new BigDecimal(daily).multiply(new BigDecimal(workHoursPerDay)).divide(new BigDecimal(24d), 6,
				RoundingMode.HALF_UP);

	}
}
