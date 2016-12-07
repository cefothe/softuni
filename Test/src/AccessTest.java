/**
 * Created by stefanangelov on 8/16/16.
 */
public class AccessTest {
    String a = "x";
    static char b = 'x';
    String  c = "x";
    class Inner{
        String  a = "y";
        String  get(){
            String c = "temp";

            c= AccessTest.Inner.this.a;
            return c;
        }
    }

    AccessTest() {
        System.out.println(  new Inner().get()  );
    }

    public static void main(String args[]) {  new AccessTest();  }
}
