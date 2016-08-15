package example06.p2;

import example06.p1.Movable;

/**
 * Created by stefanangelov on 8/12/16.
 */
public class Donkey implements Movable {
    int location = 200;

    public void move(int by) {
        location = location+by;
    }
    public void moveBack(int by) {
        location = location-by;
        }
}
