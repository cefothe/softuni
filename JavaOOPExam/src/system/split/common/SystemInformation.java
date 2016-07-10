package system.split.common;


/**
 * Created by stefanangelov on 7/10/16.
 */
public abstract class SystemInformation {
    private  String name;


    protected SystemInformation(String name) {
        setName(name);
    }
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }
}
