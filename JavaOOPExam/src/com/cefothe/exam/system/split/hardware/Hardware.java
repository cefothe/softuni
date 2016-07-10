package com.cefothe.exam.system.split.hardware;

import com.cefothe.exam.system.split.common.Component;
import com.cefothe.exam.system.split.software.Software;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by stefanangelov on 7/10/16.
 */
public abstract class Hardware extends Component {

    private int maximumCapacity;
    private int maximumMemory;

    private Set<Software> softwares;

    private HardwareEnum hardwareEnum;


    {
        softwares = new HashSet<>();
    }

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

    public void addSoftware(Software software){
        if(chechMemoryAndCapacity(software)) {
            softwares.add(software);
        }
    }

    private boolean chechMemoryAndCapacity(Software software){
        int currentCapacity = softwares.stream().mapToInt(Software::getCapacityConsumption).sum();
        int currentMomory = softwares.stream().mapToInt(Software::getMemoryConsumption).sum();
            if( isExistSoftware(software.getName()) ||
                currentCapacity+software.getCapacityConsumption()>maximumCapacity ||
                currentMomory +software.getMemoryConsumption()>maximumMemory){
            return false;
        }
        return true;
    }

    private boolean isExistSoftware(String softwareName){
        List<Software> temp = softwares.stream().filter(s->s.getName().equals(softwareName)).collect(Collectors.toList());
        if(temp.isEmpty()){
            return false;
        }
        return true;
     }
}
