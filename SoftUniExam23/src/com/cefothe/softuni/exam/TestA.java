package com.cefothe.softuni.exam;

public class TestA {

	public static void main(String[] args) {

		Integer a = new Integer(1);
		Integer b = new Integer(2);

		TestA test = new TestA();
		test.change(a, b);

		System.out.println(a);
		System.out.println(b);
	}

	void change(Integer a, Integer b) {
		Integer c = a;
		a = b;
		b = c;
	}

}
