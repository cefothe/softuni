package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefanangelov on 8/1/16.
 */



public class Main {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<Dog> dogs = new ArrayList<>();
        List<Object> objects = new ArrayList<>();
        objects.add(new Cat());

        print(objects);

        System.out.println((Object) cats.toString());
    }

    public static <T extends Animal> T print(List<? super T> list) {
        return (T)list.get(0);
    }
}
