package core.strategy;

import core.constants.Constants;
import framework.waste.disposal.contracts.Waste;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class BurnableGarbageStrategy extends DisposalStrategyAbstract {

    @Override
    protected double calculateEnergyBalance(Waste waste) {
        return Constants.BURNABLE_GARBAGE_ENERGY_PRODUCED * calculateTotalGarbageVolume(waste) -
                Constants.BURNABLE_GARBAGE_ENERGY_USED * calculateTotalGarbageVolume(waste);
    }

    @Override
    protected double calculateCapitalBalance(Waste waste) {
        return Constants.BURNABLE_GARBAGE_CAPITAL_EARNED - Constants.BURNABLE_GARBAGE_CAPITAL_USED;
    }
}

