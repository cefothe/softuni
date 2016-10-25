package ocp.chapter1.enums;

/**
 * Created by stefanangelov on 10/25/16.
 */
public enum Season3 {
    WINTER {
        public void printHours(){ System.out.println("9am-3pm");}
    }, SPRING{
        public void printHours(){System.out.println("9am-5pm");}
    }, SUMMER{
        public void printHours(){System.out.println("9am-7pm");}
    }, FALL{
        public void printHours(){System.out.println("9am-5pm");}
    };

    public abstract void printHours();
}
