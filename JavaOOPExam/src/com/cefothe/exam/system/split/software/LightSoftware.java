package com.cefothe.exam.system.split.software;

/**
 * Created by stefanangelov on 7/10/16.
 */
public class LightSoftware extends  Software {

    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(SoftwareEnum.LIGHT_SOFTWARE ,name, capacityConsumption, memoryConsumption);
    }

    @Override
    protected void calculateMemory(int memory) {
        int currentMemory = memory - memory/2;
        setMemoryConsumption(currentMemory);
    }

    @Override
    protected void calculateCapacity(int capacity) {
        int currentCapacity = capacity + capacity/2;
        setCapacityConsumption(currentCapacity);
    }
}
