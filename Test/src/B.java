import java.time.format.DateTimeFormatter;

/**
 * Created by stefanangelov on 8/12/16.
 */
class A{
    static {
        System.out.println("A");
    }
    A() {}
}
class B extends A {
    static  int i=1_______3;
    static {
        System.out.println(i);
    }
    public static void main(String[] args) {
    }
}