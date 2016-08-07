package core.strategy;

import framework.waste.disposal.contracts.ProcessingData;
import framework.waste.disposal.contracts.Waste;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class BurnableGarbageStrategy extends  DisposalStrategyAbstract {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double totalGarbageVolume = calculateTotalGarbageVolume(garbage);
    }
}
