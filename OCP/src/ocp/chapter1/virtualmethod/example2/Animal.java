package ocp.chapter1.virtualmethod.example2;

/**
 * Created by stefanangelov on 10/19/16.
 */
public abstract class Animal {
    public void careFor(){
        play();
    }

    public  void play(){
        System.out.println("pet animal");
    }
}
