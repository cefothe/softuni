package ocp.chapter1.enums;

/**
 * Created by stefanangelov on 10/25/16.
 */
public enum Season2 {

    WINTER("Low"), SPRING("Medium"), SUMMER("High");

    private String expectedVisitors;

    private Season2(String expectedVisitors){
        this.expectedVisitors= expectedVisitors;
    }
}
