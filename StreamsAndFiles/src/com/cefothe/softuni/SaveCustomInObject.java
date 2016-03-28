package com.cefothe.softuni;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	public Course(String field, int numberOfStudent) {
		this.field = field;
		this.numberOfStudent = numberOfStudent;
	}

	public String field;
	public int numberOfStudent;
}

public class SaveCustomInObject {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		try (FileOutputStream outFile = new FileOutputStream("resources/course.save")) {
			try (ObjectOutputStream out = new ObjectOutputStream(outFile)) {
				out.writeObject(new Course("JAVA", 15));
			}
		}
		try (FileInputStream inputFile = new FileInputStream("resources/course.save")) {
			try (ObjectInputStream input = new ObjectInputStream(inputFile)) {
				Course cource = (Course) input.readObject();
				System.out.printf("Field:%s, number: %d", cource.field, cource.numberOfStudent);
			}
		}
	}

}
