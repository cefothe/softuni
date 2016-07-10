package com.cefothe.exam.system.split;

import com.cefothe.exam.system.split.hardware.Hardware;
import com.cefothe.exam.system.split.software.Software;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by stefanangelov on 7/10/16.
 */
//TODO: This class should be Singelton
public class SplitSystem {

    private Set<Hardware> hardwares;

    public SplitSystem(){
        hardwares = new HashSet<>();
    }

    public void addHardware(Hardware hardware){
        if(!isHardwareExist(hardware.getName())){
            hardwares.add(hardware);
        }
    }

    private boolean isHardwareExist(String hardwareName){
        List<Hardware> temp = hardwares.stream().filter(s->s.getName().equals(hardwareName)).collect(Collectors.toList());
        if(temp.isEmpty()){
            return false;
        }
        return true;
    }

    public Hardware getHardware(String hardwareName){
        for(Hardware hardware: hardwares){
            if(hardware.getName().equals(hardwareName)){
                return  hardware;
            }
        }
        return null;
    }

}
