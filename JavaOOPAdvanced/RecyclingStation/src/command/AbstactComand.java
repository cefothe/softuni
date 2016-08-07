package command;

import command.interfaces.Command;
import framework.waste.disposal.contracts.GarbageProcessor;
import provider.DataProvider;

/**
 * Created by stefanangelov on 8/7/16.
 */
public abstract class AbstactComand implements Command {
    protected DataProvider dataProvider;
    protected GarbageProcessor garbageProcessor;
    protected String[] args;

    protected AbstactComand(String [] args, DataProvider dataProvider, GarbageProcessor garbageProcessor){
        setArgs(args);
        setDataProvider(dataProvider);
        setGarbageProcessor(garbageProcessor);
    }

    protected String[] getArgs() {
        return args;
    }

    private void setArgs(String[] args) {
        this.args = args;
    }

    protected DataProvider getDataProvider() {
        return dataProvider;

    }

    private void setGarbageProcessor(GarbageProcessor garbageProcessor) {
        this.garbageProcessor = garbageProcessor;
    }
    private void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }
}
