package overridingvshiding;

/**
 * Created by stefanangelov on 7/25/16.
 */
public interface Test {

    public int age = 10;
    public static void eatGrass(){
        StringBuilder a = new  StringBuilder(10);
    }
}

interface HasFins{
    public  default double getLongestFinLength(){
        return 4.0;
    }
}
interface  SharkFamily extends  HasFins{
    public double getLongestFinLength();
}
