package com.cefothe.exam.system.split.hardware;

/**
 * Created by stefanangelov on 7/10/16.
 */
public class HeavyHardware extends  Hardware {

    public HeavyHardware(String name, int capacity, int memory) {
        super(name, capacity, memory);
    }

    @Override
    void calculateCapacity(int capacity) {
        int currentCapacity= capacity - ((capacity *1)/4);
        this.setMaximumCapacity(currentCapacity);
    }

    @Override
    void calculateMemory(int memory) {
        int currentMemory = memory  - ((memory  *1)/2);
        this.setMaximumCapacity(currentMemory);
    }
}
