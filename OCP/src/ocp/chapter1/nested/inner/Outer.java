package ocp.chapter1.nested.inner;

/**
 * Created by stefanangelov on 10/26/16.
 */
public class Outer {
    private String greeting = "Hi";

    public final class Inner{

        public int repeat =3;

        public void go(){
            for(int i=0; i <repeat; i++){
                System.out.println(greeting);
            }
        }
    }

    public void callInner(){
        Inner inner = new Inner();
        inner.go();
    }

    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.callInner();

        Outer.Inner inner = new Outer().new Inner();
        inner.go();
    }
}
