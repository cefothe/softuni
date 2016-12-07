package ocp.chapter1.enums;

/**
 * Created by stefanangelov on 10/24/16.
 */
public class Main {

    public static void main(String[] args) {
        //Season s = Season.SUMMER;
        Season s = Season.valueOf("SUMMER");
        System.out.println(Season.SUMMER);
        System.out.println(s == Season.SUMMER);

        for(Season season: Season.values()){
            System.out.println(season.name() + " "+ season.ordinal());
        }


        Season summer = Season.SUMMER;
        switch(summer){
            case WINTER:
                System.out.println("GET out the sled;");
                break;
            case SUMMER:
                System.out.println("Time for the pool!");
        }

        OnlyOne firstCall = OnlyOne.ONCE;
        OnlyOne secondCall = OnlyOne.ONCE;

        Season3.WINTER.printHours();

        Season4.SUMMER.printHours();
        Season4.FALL.printHours();
    }
}
