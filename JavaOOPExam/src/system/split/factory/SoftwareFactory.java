package system.split.factory;

import system.split.software.ExpressSoftware;
import system.split.software.LightSoftware;
import system.split.software.Software;

import java.util.List;

/**
 * Created by stefanangelov on 7/10/16.
 */
public enum SoftwareFactory {
    F;
    public Software createSoftware(List<String> argumerns){
        String softwareType = argumerns.get(0);
        Software software = null;
        switch (softwareType){
            case "RegisterLightSoftware":
                software = new LightSoftware(argumerns.get(2),Integer.parseInt(argumerns.get(3)),Integer.parseInt(argumerns.get(4)));
                break;
            case "RegisterExpressSoftware":
                software = new ExpressSoftware(argumerns.get(2),Integer.parseInt(argumerns.get(3)),Integer.parseInt(argumerns.get(4)));
                break;
        };
        return  software;
    }
}
