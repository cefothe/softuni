package hidingvariables;

/**
 * Created by stefanangelov on 7/22/16.
 */
public class Rodent {
    protected int tailLength = 4;

    public void getRodentDetails() {
        System.out.println("[parentTail="+tailLength+"]");
    }
}
