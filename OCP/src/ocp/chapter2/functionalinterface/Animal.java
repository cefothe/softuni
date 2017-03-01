package ocp.chapter2.functionalinterface;

/**
 * Created by stefanangelov on 11/1/16.
 */
public class Animal {

    private String species;
    private boolean canHop;
    private boolean canSwim;

    public Animal(String species, boolean canHop, boolean canSwim) {
        this.species = species;
        this.canHop = canHop;
        this.canSwim = canSwim;
    }

    public boolean isCanHop(){
        return  canHop;
    }

    public boolean isCanSwim(){
        return canSwim;
    }

    @Override
    public String toString() {
        return species;
    }

    @FunctionalInterface
    public interface CheckTrait{
        public  boolean test(Animal animal);
    }
}
