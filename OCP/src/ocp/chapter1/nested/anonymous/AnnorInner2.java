package ocp.chapter1.nested.anonymous;

/**
 * Created by stefanangelov on 10/28/16.
 */
public class AnnorInner2 {
    interface SaleTodayOnly{
        int dollarsOff();
    }

    public int admission(int basePrice){
        SaleTodayOnly sale = new SaleTodayOnly() {
            @Override
            public int dollarsOff() {
                return 3;
            }
        };

        return  basePrice- sale.dollarsOff();
    }
}
