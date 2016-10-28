package ocp.chapter1.nested.staticinner;

/**
 * Created by stefanangelov on 10/28/16.
 */
public class Enclosing {
    static  class Nested{
        private int price =6;
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}
