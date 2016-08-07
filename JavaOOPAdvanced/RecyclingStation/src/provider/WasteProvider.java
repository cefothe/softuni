package provider;

import core.model.TypeGarbage;
import framework.waste.disposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class WasteProvider implements DataProvider {

    private List<Waste> wastes;

    public WasteProvider(){
        this.wastes = new ArrayList<>();
    }

    @Override
    public Waste addProduct(TypeGarbage type, String name, double weight, double volumePerKg) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?  extends  Waste> classes =  type.getWasterClass();
        Constructor construct = classes.getConstructor(String.class, double.class, double.class);
        Waste waste = (Waste) construct.newInstance(name, weight,volumePerKg);
        this.wastes.add(waste);
        return  waste;
    }

    @Override
    public Iterable<Waste> getShopProducts() {
        return null;
    }
}
