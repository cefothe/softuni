package com.cefothe.third;

/**
 * Created by cefothe on 12.07.16.
 */
public class Ferrari implements Car {

    private String driverName;

    public Ferrari(String driverName){
        this.driverName = driverName;
    }

    @Override
    public String getModel() {
        return "488-Spider";
    }

    @Override
    public String getDriverName() {
        return driverName;
    }

    @Override
    public String pushBrake() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }

    @Override
    public String toString(){
        return getModel()+"/"+pushBrake()+"/"+pushGas()+"/"+getDriverName();
    }
}
