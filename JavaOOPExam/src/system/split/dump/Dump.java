package system.split.dump;

import system.split.hardware.Hardware;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefanangelov on 7/10/16.
 */
public class Dump {
    List<Hardware> dumpElement;

    public Dump() {
        this.dumpElement = new ArrayList<>();
    }

    public void dump(Hardware hardware){
        dumpElement.add(hardware);
    }

}
