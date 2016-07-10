package system.split.factory;

import system.split.hardware.Hardware;
import system.split.hardware.HeavyHardware;
import system.split.hardware.PowerHardware;

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
