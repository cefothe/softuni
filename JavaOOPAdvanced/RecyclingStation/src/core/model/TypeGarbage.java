package core.model;

import command.enums.ComandEnumeration;
import framework.waste.disposal.contracts.Waste;

/**
 * Created by stefanangelov on 8/7/16.
 */
public enum TypeGarbage {

    BURNABLE("Burnable", BurnableGarbage.class),
    RECYClABLE("Recyclable",RecyclableGarbage.class),
    STORABLE("Storable",StorableGarbage.class);

    private String name;
    private Class<? extends Waste> wasterClass;

    private  TypeGarbage(String name,Class<? extends Waste> wasterClass){
        this.name = name;
        this.wasterClass = wasterClass;
    }

    public String getName(){
        return  name;
    }

    public Class<? extends Waste> getWasterClass(){
        return  wasterClass;
    }

    public static TypeGarbage getEnumByCommandName(String commandName){
        for(TypeGarbage e:values()){
            if(e.getName().equals(commandName)){
                return e;
            }
        }
        throw  new IllegalArgumentException("No enum constant with commandName"+ commandName);
    }

}
