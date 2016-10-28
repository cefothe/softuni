package ocp.chapter1.nested.local;

/**
 * Created by stefanangelov on 10/26/16.
 */
public class Outer {

    private int lenght = 5 ;

    public void calculate(){
        int width = 20;
        class Inner {
            public void multiply() {
                System.out.println(lenght * width);
            }
        }
        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String[] args) {
        new Outer().calculate();
    }

}
