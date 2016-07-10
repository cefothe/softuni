package com.cefothe.exam.system.split.hardware;

import com.cefothe.exam.system.split.common.SystemInformation;

/**
 * Created by stefanangelov on 7/10/16.
 */
public abstract class Hardware extends SystemInformation {

    private int maximumCapacity;
    private int maximumMemory;

    protected Hardware(String name, int capacity, int memory) {
        super(name);
        calculateCapacity(capacity);
        calculateMemory(memory);
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }
    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

    abstract void calculateCapacity(int capacity);
    abstract  void calculateMemory(int memory);
}
