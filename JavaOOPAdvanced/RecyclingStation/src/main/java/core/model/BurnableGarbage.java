package core.model;

import core.annotations.Burnable;

/**
 * Created by stefanangelov on 8/7/16.
 */
@Burnable
public class BurnableGarbage extends WasteAbstract {

    public BurnableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
