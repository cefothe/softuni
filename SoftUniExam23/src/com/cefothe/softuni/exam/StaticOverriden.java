package com.cefothe.softuni.exam;

class Bear {
	public static void eat() {
		System.out.println("Bear is eating");
	}
}

class Panda extends Bear {
	public static void eat() {
		System.out.println("Panda bear is chewing");
	}

	public static void main(String[] args) {
		Panda.eat();
	}
}

public class StaticOverriden {
	public static void main(String[] args) {
		Bear.eat();
	}
}
