package com.cefothe.exam.system.split.hardware;

/**
 * Created by stefanangelov on 7/10/16.
 */
public class PowerHardware extends  Hardware {

    public PowerHardware(String name, int capacity, int memory ) {
        super(HardwareEnum.POWER_HARDWARE,name, capacity, memory);
    }

    @Override
    protected  void calculateCapacity(int capacity) {
        int curentCapacity= capacity - ((capacity *3)/4);
        this.setMaximumCapacity(curentCapacity);
    }

    @Override
    protected  void calculateMemory(int memory) {
        int currentMemory = memory  + ((memory  *3)/4);
        this.setMaximumCapacity(currentMemory);
    }
}
