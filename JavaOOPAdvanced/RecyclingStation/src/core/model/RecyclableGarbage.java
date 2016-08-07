package core.model;

import core.annotations.Recyclable;

/**
 * Created by stefanangelov on 8/7/16.
 */
@Recyclable
public class RecyclableGarbage extends  WasteAbstract {

    public RecyclableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
