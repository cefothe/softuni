package overridingvshiding;

/**
 * Created by stefanangelov on 7/26/16.
 */
public class Shark implements  SharkFamily {
    @Override
    public double getLongestFinLength() {
        return 0;
    }
}
