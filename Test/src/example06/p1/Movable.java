package example06.p1;

/**
 * Created by stefanangelov on 8/12/16.
 */
public interface Movable {
        int location = 0;
        void move(int by);
        public void moveBack(int by);

        default int getLocation(){
            return location;
        };
        }
