package core.model;

import core.annotations.Storable;

/**
 * Created by stefanangelov on 8/7/16.
 */
@Storable
public class StorableGarbage extends WasteAbstract {

    public StorableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
