package system.split.hardware;

/**
 * Created by stefanangelov on 7/10/16.
 */
public enum  HardwareEnum {

    POWER_HARDWARE("Power",1),HEAVY_HARDWARE("Heavy",2);

    private String name;
    private int order;

    HardwareEnum(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public  int getOrder(){
        return  order;
    }

    public static HardwareEnum getEnumeration(String name){
        for(HardwareEnum en:values()){
            if(en.getName().equals(name)){
                return en;
            }
        }
        throw  new IllegalArgumentException();
    }
}
