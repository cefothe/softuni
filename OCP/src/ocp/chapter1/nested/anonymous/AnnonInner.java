package ocp.chapter1.nested.anonymous;

/**
 * Created by stefanangelov on 10/28/16.
 */
public class AnnonInner {
    abstract class SaleTodayOnly{
        abstract int dollarsOff();
    }

    public int admission(int basePrice){
        SaleTodayOnly sale = new SaleTodayOnly() {
            @Override
            int dollarsOff() {
                return  3;
            }
        };

        return  basePrice - sale.dollarsOff();
    }

    public static void main(String[] args) {
        System.out.println(new AnnonInner().admission(5));
    }
}
