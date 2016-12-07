package framework.waste.disposal;

import core.model.BurnableGarbage;
import core.model.RecyclableGarbage;
import core.model.StorableGarbage;
import core.strategy.BurnableGarbageStrategy;
import core.strategy.RecyclableGarbageStrategy;
import core.strategy.StorableGarbageStrategy;
import framework.waste.disposal.contracts.GarbageDisposalStrategy;
import framework.waste.disposal.contracts.Waste;

/**
 * Created by stefanangelov on 8/7/16.
 */
public enum  StrategyToWaste {
    RECYCLABLE_GARBAGE(RecyclableGarbage.class, new RecyclableGarbageStrategy()),
    BURNABLE_GARBAGE(BurnableGarbage.class, new BurnableGarbageStrategy()),
    STORABLE_GARBAGE(StorableGarbage.class, new StorableGarbageStrategy());

    private Class<? extends Waste> wasteClass;
    private GarbageDisposalStrategy garbageDisposalStrategy;

    private StrategyToWaste(Class<? extends Waste> wasteClass, GarbageDisposalStrategy garbageDisposalStrategy) {
            this.wasteClass= wasteClass;
            this.garbageDisposalStrategy = garbageDisposalStrategy;
    }

    public Class<? extends Waste> getWasteClass() {
        return wasteClass;
    }

    public GarbageDisposalStrategy getGarbageDisposalStrategy() {
        return garbageDisposalStrategy;
    }
}
