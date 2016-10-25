package ocp.chapter1.enums;

/**
 * Created by stefanangelov on 10/25/16.
 */
public enum Season4 {
    WINTER{
        public void printHours(){System.out.println("short hours");}
    }, SUMMER{
        public void printHours(){System.out.println("long hours");}
    }, SPRING, FALL;


    public void printHours(){System.out.println("default hours");}
}
