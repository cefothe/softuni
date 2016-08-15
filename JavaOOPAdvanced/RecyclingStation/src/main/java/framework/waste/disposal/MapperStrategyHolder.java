package framework.waste.disposal;

import framework.waste.disposal.contracts.GarbageDisposalStrategy;
import framework.waste.disposal.contracts.StrategyHolder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class MapperStrategyHolder implements StrategyHolder {

    private LinkedHashMap<Class,GarbageDisposalStrategy> strategies;

    public MapperStrategyHolder(){
        this.strategies = new LinkedHashMap<>();

    }

    private void  initializeMap(){
        for(StrategyToWaste e: StrategyToWaste.values()){
            addStrategy(e.getWasteClass(),e.getGarbageDisposalStrategy());
        }
    }
    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        this.strategies.put(annotationClass,strategy);
        return true;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        this.strategies.remove(annotationClass);
        return true;
    }
}
