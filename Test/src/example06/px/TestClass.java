package example06.px;

import example06.p1.Movable;
import example06.p2.Donkey;

/**
 * Created by stefanangelov on 8/12/16.
 */
public class TestClass {
    public static void main(String[] args) {
        Movable m = new Donkey();
        m.move(10);
        m.moveBack(20);
        System.out.println(m.getLocation());
        }

    void crazyLoop(){
        int c = 0;
        JACK: while (c < 8){
            JILL: System.out.println(c);
            if (c > 3) break JACK; else c++;
        }
    }
}
