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
        this.initializeMap();
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
        if(this.strategies.put(annotationClass,strategy)!=null)
            return true;
        else return false;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        if(this.strategies.remove(annotationClass)!=null)
         return true;
        else return false;
    }
}
