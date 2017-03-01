package ocp.chapter2.polymorphism.example1;

/**
 * Created by stefanangelov on 11/1/16.
 */
public class Dolphin implements  LivesInOcean {
    @Override
    public void makeSound() {
        System.out.println("whistle");
    }
}
