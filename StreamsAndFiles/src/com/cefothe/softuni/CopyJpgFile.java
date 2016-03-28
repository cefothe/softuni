package com.cefothe.softuni;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyJpgFile {

	@SuppressWarnings("unused")
	private static void copyFile(File source, File dest) throws FileNotFoundException, IOException {
		try (InputStream input = new FileInputStream(source)) {
			try (OutputStream output = new FileOutputStream(dest)) {
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = input.read(buffer)) > 0) {
					output.write(buffer, 0, bytesRead);
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		copyFile(new File("resources/test.jpg"), new File("resources/my-copied-picture.jpg"));
	}

}
