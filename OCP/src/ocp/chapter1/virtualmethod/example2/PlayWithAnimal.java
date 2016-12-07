package ocp.chapter1.virtualmethod.example2;

/**
 * Created by stefanangelov on 10/19/16.
 */
public class PlayWithAnimal {

    public static void main(String[] args) {
        Animal animal = new Lion();
        animal.careFor();
    }
}
