package core.strategy;

import core.constants.Constants;
import framework.waste.disposal.contracts.Waste;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class StorableGarbageStrategy extends  DisposalStrategyAbstract {

    @Override
    protected double calculateEnergyBalance(Waste waste) {
        return Constants.STORABLE_GARBAGE_ENERGY_PRODUCED -
                Constants.STORABLE_GARBAGE_ENERGY_USED * calculateTotalGarbageVolume(waste);
    }

    @Override
    protected double calculateCapitalBalance(Waste waste) {
        return Constants.STORABLE_GARBAGE_CAPITAL_EARNED -
                Constants.STORABLE_GARBAGE_CAPITAL_USED * calculateTotalGarbageVolume(waste);
    }
}
