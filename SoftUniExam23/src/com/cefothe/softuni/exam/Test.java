package com.cefothe.softuni.exam;

class Animal {
	protected void run() {
		System.out.println("running...");
	}
}

class Human extends Animal {
	public void run() {
		System.out.println("run human run");
	}
}

public class Test {
	public static void main(String... args) {
		Human human = new Human();
		human.run();

		Animal animal = new Animal();
		animal.run();
	}
}