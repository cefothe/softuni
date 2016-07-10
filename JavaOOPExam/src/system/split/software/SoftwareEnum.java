package system.split.software;

/**
 * Created by stefanangelov on 7/10/16.
 */
public enum SoftwareEnum {

    EXPRESS_SOFTWARE("express"),LIGHT_SOFTWARE("light");

    private String name;

    SoftwareEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static SoftwareEnum getEnumeration(String name){
        for(SoftwareEnum en:values()){
            if(en.getName().equals(name)){
                return en;
            }
        }
        throw  new IllegalArgumentException();
    }
}
