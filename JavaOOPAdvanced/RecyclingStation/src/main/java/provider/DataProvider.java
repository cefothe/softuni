package provider;

import core.model.TypeGarbage;
import framework.waste.disposal.contracts.Waste;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * Created by stefanangelov on 8/7/16.
 */
public interface DataProvider {

    Waste addProduct(TypeGarbage type, String name, double weight, double  volumePerKg) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
    List<Waste> getShopProducts();
}
