package com.cefothe.exam.system.split.factory;

import com.cefothe.exam.system.split.SplitSystem;
import com.cefothe.exam.system.split.hardware.Hardware;
import com.cefothe.exam.system.split.hardware.HeavyHardware;
import com.cefothe.exam.system.split.hardware.PowerHardware;

import java.util.List;

/**
 * Created by stefanangelov on 7/10/16.
 */
public enum  HardwareFactory {

    F;

    public Hardware createHardware(List<String> argumerns){
        String hardwareType = argumerns.get(0);
        Hardware hardware = null;
        switch (hardwareType){
             case "RegisterPowerHardware":
                hardware = new PowerHardware(argumerns.get(1),Integer.parseInt(argumerns.get(2)), Integer.parseInt(argumerns.get(3)));
                break;
            case "RegisterHeavyHardware":
                hardware = new HeavyHardware(argumerns.get(1),Integer.parseInt(argumerns.get(2)), Integer.parseInt(argumerns.get(3)));
                break;
        };
        return  hardware;
    }
}
