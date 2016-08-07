package generic;

import animal.*;

/**
 * Created by stefanangelov on 8/1/16.
 */
public class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("cat is eating");
    }
}
