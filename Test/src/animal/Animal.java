package animal;

/**
 * Created by stefanangelov on 7/22/16.
 */
public abstract class Animal {

    protected  int age;

    public void eat(){
        System.out.println("Animal is eating");
    }

    public abstract String getName();
}
