package com.cefothe.softuni;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SaveArrayListOfDoubles {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		List<Double> doublesListArray = new ArrayList<>();
		doublesListArray.add(2.3);
		doublesListArray.add(2.4);
		doublesListArray.add(2.5);
		try (FileOutputStream doublesList = new FileOutputStream("resources/doubles.list")) {
			ObjectOutputStream out = new ObjectOutputStream(doublesList);
			out.writeObject(doublesListArray);
			out.flush();
			try (ObjectInputStream load = new ObjectInputStream(new FileInputStream("resources/doubles.list"))) {
				System.out.println(load.readObject());
			}
		}

	}

}
