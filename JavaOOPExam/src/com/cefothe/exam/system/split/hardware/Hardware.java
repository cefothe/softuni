package com.cefothe.exam.system.split.hardware;

import com.cefothe.exam.system.split.common.Component;
import com.cefothe.exam.system.split.common.SystemInformation;

/**
 * Created by stefanangelov on 7/10/16.
 */
public abstract class Hardware extends Component {

    private int maximumCapacity;
    private int maximumMemory;

    private HardwareEnum hardwareEnum;

    protected Hardware(HardwareEnum hardwareEnum,String name, int capacity, int memory) {
        super(name);
        setHardwareEnum(hardwareEnum);
        calculateCapacity(capacity);
        calculateMemory(memory);
    }

    public int getMaximumCapacity() {
        return maximumCapacity;
    }

    public int getMaximumMemory() {
        return maximumMemory;
    }

    public HardwareEnum getHardwareEnum() {
        return hardwareEnum;
    }

    protected void setHardwareEnum(HardwareEnum hardwareEnum) {
        this.hardwareEnum = hardwareEnum;
    }

    protected void setMaximumCapacity(int maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    protected void setMaximumMemory(int maximumMemory) {
        this.maximumMemory = maximumMemory;
    }

}
