package core.strategy;

import core.constants.Constants;
import framework.waste.disposal.contracts.ProcessingData;
import framework.waste.disposal.contracts.Waste;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class RecyclableGarbageStrategy extends  DisposalStrategyAbstract {



    @Override
    protected double calculateEnergyBalance(Waste garbage) {
        return Constants.RECYCLABLE_GARBAGE_ENERGY_PRODUCED - Constants.RECYCLABLE_GARBAGE_ENERGY_USED * calculateTotalGarbageVolume(garbage);
    }

    @Override
    protected double calculateCapitalBalance(Waste garbage) {
        return Constants.RECYCLABLE_GARBAGE_CAPITAL_EARNED * garbage.getWeight()- Constants.RECYCLABLE_GARBAGE_CAPITAL_USED;
    }
}
