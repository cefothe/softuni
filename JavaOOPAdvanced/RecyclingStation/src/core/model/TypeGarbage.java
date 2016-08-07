package core.model;

/**
 * Created by stefanangelov on 8/7/16.
 */
public enum TypeGarbage {

    BURNABLE("Recyclable"),RECYClABLE("Burnable"),STORABLE("Storable");

    private String name;

    private  TypeGarbage(String name){
        this.name = name;
    }

}
