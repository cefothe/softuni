package com.cefothe.exam.system.split.hardware;

/**
 * Created by stefanangelov on 7/10/16.
 */
public enum  HardwareEnum {

    POWER_HARDWARE("power"),HEAVY_HARDWARE("heavy");

    private String name;

    HardwareEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static HardwareEnum getEnumeration(String name){
        for(HardwareEnum en:values()){
            if(en.getName().equals(name)){
                return en;
            }
        }
        throw  new IllegalArgumentException();
    }
}
