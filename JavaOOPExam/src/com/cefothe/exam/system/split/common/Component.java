package com.cefothe.exam.system.split.common;

/**
 * Created by stefanangelov on 7/10/16.
 */
public abstract class Component extends  SystemInformation {

    public Component(String name) {
        super(name);
    }

    protected abstract  void calculateMemory(int memory);
    protected abstract void calculateCapacity(int capacity);
}
