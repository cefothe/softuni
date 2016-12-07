package ocp.chapter1.coding;

/**
 * Created by stefanangelov on 10/19/16.
 */
public class Lion {
    private int idNumber;
    private int age;
    public String name;

    public Lion(int idNumber, int age, String name) {
        this.idNumber = idNumber;
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Lion)) return false;
        Lion otherLion = (Lion) obj;
        return  this.idNumber == otherLion.idNumber;
    }



}
