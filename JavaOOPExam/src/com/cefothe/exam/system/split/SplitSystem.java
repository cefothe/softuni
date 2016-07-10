package com.cefothe.exam.system.split;

import com.cefothe.exam.system.split.common.SystemInformation;
import com.cefothe.exam.system.split.hardware.Hardware;
import com.cefothe.exam.system.split.software.Software;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.cefothe.exam.system.split.common.Configuration.SYSTEM_ANALYSIS;

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

    public void systemAnalysis(){
        System.out.println(SYSTEM_ANALYSIS);
        System.out.println("Hardware Components: "+ hardwares.size());
        System.out.println("Software Components: "+ calculateNumberOfSoftware());
        System.out.println("Total Operational Memory: "+calculateUseMemory()+" / "+calculateMaxMemory());
        System.out.println("Total Capacity Taken: "+calculateUseCapacity()+" / "+calculateMaxCapacity());
    }

    private int calculateMaxCapacity(){
        return  hardwares.stream().mapToInt(Hardware::getMaximumCapacity).sum();
    }

    private int calculateMaxMemory(){
        return  hardwares.stream().mapToInt(Hardware::getMaximumMemory).sum();
    }

    private int calculateUseCapacity(){
        return  hardwares.stream().mapToInt(Hardware::useCapacity).sum();
    }

    private int calculateUseMemory(){
        return  hardwares.stream().mapToInt(Hardware::useMomory).sum();
    }

    private int calculateNumberOfSoftware(){
        int number = hardwares.stream().mapToInt(Hardware::getNumberOfSoftware).sum();
        return  number;
    }


}
