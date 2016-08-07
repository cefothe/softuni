package provider;

import framework.waste.disposal.contracts.Waste;

/**
 * Created by stefanangelov on 8/7/16.
 */
public interface DataProvider {
    Waste addProduct(String name, double weight, double  volumePerKg);
}
