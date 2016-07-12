package com.cefothe;


import com.cefothe.third.Car;
import com.cefothe.third.Ferrari;

import java.lang.instrument.IllegalClassFormatException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalClassFormatException  {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Ferrari ferrari = new Ferrari(line);

        System.out.println(ferrari);

        String ferrariName = Ferrari.class.getSimpleName();
        String carInterface = Car.class.getSimpleName();
        boolean isCreated = Car.class.isInterface();
        if (!isCreated) {
            throw new IllegalClassFormatException("No interface created!");
        }
    }
}
