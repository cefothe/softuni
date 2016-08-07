package core.model;


import command.interfaces.Command;
import core.constants.Constants;
import framework.waste.disposal.contracts.Waste;

/**
 * Created by stefanangelov on 8/7/16.
 */
public abstract class WasteAbstract implements Waste {

    protected  String name;
    protected double weight;
    protected  double volumePerKg;

    protected  WasteAbstract(String name, double weight, double  volumePerKg){
        setName(name);
        setWeight(weight);
        setVolumePerKg(volumePerKg);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }


    protected void setName(String name) {
        this.name = name;
    }

    protected void setWeight(double weight) {
        this.weight = weight;
    }

    protected void setVolumePerKg(double volumePerKg) {
        this.volumePerKg = volumePerKg;
    }

    @Override
    public String toString() {
        return String.format(
                Constants.WASTE_TO_STRING,
                getWeight(),
                getName()
        );
    }
}
