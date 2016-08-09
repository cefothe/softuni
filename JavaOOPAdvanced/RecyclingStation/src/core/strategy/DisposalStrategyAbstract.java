package core.strategy;

import framework.waste.disposal.contracts.GarbageDisposalStrategy;
import framework.waste.disposal.contracts.ProcessingData;
import framework.waste.disposal.contracts.Waste;
import framework.waste.disposal.to.TranferObject;

/**
 * Created by stefanangelov on 8/7/16.
 */
public abstract class DisposalStrategyAbstract implements GarbageDisposalStrategy {

    @Override
    public final ProcessingData processGarbage(Waste garbage) {
        double energyBalance = calculateEnergyBalance(garbage);
        double capitalBalance = calculateCapitalBalance(garbage);
        return new TranferObject(energyBalance,capitalBalance);
    }

    protected double calculateTotalGarbageVolume(Waste waste){
        return waste.getWeight() * waste.getVolumePerKg();
    }

    protected abstract double calculateEnergyBalance(Waste waste);
    protected abstract double calculateCapitalBalance(Waste waste);
}
