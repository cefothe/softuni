package com.cefothe.softuni.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This class contain main table information
 * 
 * @author stefanangelov
 *
 */
class Table {
	public int rows;
	public int cols;

	public void fillingRowsAndCols(String input) {
		String[] inputs = input.split(" ");
		rows = Integer.parseInt(inputs[0]);
		cols = Integer.parseInt(inputs[1]);
	}

}

class Shot {
	public int row;
	public int coll;
	public int radius;

	public void fillingShotValues(String input) {

		String[] shotData = input.split(" ");
		row = Integer.parseInt(shotData[0]);
		coll = Integer.parseInt(shotData[1]);
		radius = Integer.parseInt(shotData[2]);
	}
}

public class Crossfire {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<List<Integer>> table = new ArrayList<>();

		Table tableInformation = new Table();
		tableInformation.fillingRowsAndCols(scanner.nextLine());
		fiillTable(table, tableInformation);

		String inputData = scanner.nextLine();

		while (!inputData.equals("Nuke it from orbit")) {
			Shot current = new Shot();
			current.fillingShotValues(inputData);
			verticallShotRemove(current, table);
			horizontallShotRemove(current, table);
			filterMattrix(table, tableInformation);
			inputData = scanner.nextLine();
		}
		printTable(table, tableInformation);

	}

	public static void filterMattrix(List<List<Integer>> table, Table tableInformation) {
		for (int i = 0; i < tableInformation.rows && i < table.size(); i++) {
			table.get(i).removeAll(Arrays.asList(new Integer[] { -1 }));
		}
		table.removeAll(Arrays.asList(new ArrayList<Integer>()));
	}

	public static boolean isInMatrix(Integer currentRow, Integer currentColl, List<List<Integer>> table) {
		return currentRow >= 0 && currentRow < table.size() && currentColl >= 0
				&& currentColl < table.get(currentRow).size();
	}

	public static void verticallShotRemove(Shot shot, List<List<Integer>> table) {
		for (int index = shot.coll - shot.radius; index <= shot.coll + shot.radius; index++) {
			if (isInMatrix(shot.row, index, table)) {
				table.get(shot.row).set(index, -1);
			}

		}
	}

	public static void horizontallShotRemove(Shot shot, List<List<Integer>> table) {
		for (int index = shot.row - shot.radius; index <= shot.row + shot.radius; index++) {
			if (isInMatrix(index, shot.coll, table)) {
				table.get(index).set(shot.coll, -1);

			}

		}
	}

	/**
	 * Fill table for next rule: first row: 1, 2, 3… n second row: n+1, n+2, n+3… n + n.
	 * 
	 * @param table
	 * @param tableInformation
	 */
	public static void fiillTable(List<List<Integer>> table, Table tableInformation) {
		int counter = 1;
		for (int row = 0; row < tableInformation.rows; row++) {
			List<Integer> cols = new ArrayList<>();
			for (int col = 0; col < tableInformation.cols; col++) {
				cols.add(counter);
				counter++;
			}
			table.add(cols);
		}
	}

	/**
	 * This table on console
	 * 
	 * @param table
	 * @param tableInformation
	 */
	public static void printTable(List<List<Integer>> table, Table tableInformation) {
		for (int rows = 0; rows < table.size() && !table.get(rows).isEmpty(); rows++) {
			List<Integer> cellsData = table.get(rows);
			for (int cell = 0; cell < cellsData.size(); cell++) {
				System.out.print(cellsData.get(cell) + " ");
			}
			System.out.println();
		}
	}
}
