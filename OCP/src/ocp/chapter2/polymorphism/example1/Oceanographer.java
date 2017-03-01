package ocp.chapter2.polymorphism.example1;

/**
 * Created by stefanangelov on 11/1/16.
 */
public class Oceanographer {
    public void checkSound(LivesInOcean animal){
        animal.makeSound();
    }

    public static void main(String[] args) {
        Oceanographer oceanographer = new Oceanographer();
        oceanographer.checkSound(new Dolphin());
        oceanographer.checkSound(new Whale());
    }
}
