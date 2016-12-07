package ocp.chapter1.enums;

/**
 * Created by stefanangelov on 10/25/16.
 */
public enum OnlyOne {
    ONCE(true);

    private OnlyOne(boolean b){
        System.out.println("constructing");
    }
}
