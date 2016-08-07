package core.strategy;

import framework.waste.disposal.contracts.GarbageDisposalStrategy;
import framework.waste.disposal.contracts.ProcessingData;
import framework.waste.disposal.contracts.Waste;

/**
 * Created by stefanangelov on 8/7/16.
 */
public abstract class DisposalStrategyAbstract implements GarbageDisposalStrategy {

    protected double calculateTotalGarbageVolume(Waste waste){
        return waste.getWeight() * waste.getVolumePerKg();
    }
}
