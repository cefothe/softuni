package core.constants;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class Constants {

    // RECYCLABLE GARBAGE
    public static final double RECYCLABLE_GARBAGE_ENERGY_USED = 0.5d;
    public static final double RECYCLABLE_GARBAGE_CAPITAL_EARNED = 400;
    public static final double RECYCLABLE_GARBAGE_CAPITAL_USED = 0;
    public static final double RECYCLABLE_GARBAGE_ENERGY_PRODUCED = 0;

    // BURNABLE GARBAGE
    public static final double BURNABLE_GARBAGE_ENERGY_PRODUCED = 1;
    public static final double BURNABLE_GARBAGE_ENERGY_USED = 0.2d;
    public static final double BURNABLE_GARBAGE_CAPITAL_EARNED = 0;
    public static final double BURNABLE_GARBAGE_CAPITAL_USED = 0;



    //  STORABLE GARBAGE
    public static final double  STORABLE_GARBAGE_ENERGY_PRODUCED = 0;
    public static final double  STORABLE_GARBAGE_ENERGY_USED = 0.13d;
    public static final double  STORABLE_GARBAGE_CAPITAL_EARNED = 0;
    public static final double  STORABLE_GARBAGE_CAPITAL_USED = 0.65d;



    public static final String  TERMINATE ="TimeToRecycle";
    public static final String INPUT_SPLIT_COMMAND = " ";
    public static final String INPUT_SPLIT_ARGUMENTS = "\\|";

    public static  final String WASTE_TO_STRING = "%.2f kg of %s successfully processed!";

}
