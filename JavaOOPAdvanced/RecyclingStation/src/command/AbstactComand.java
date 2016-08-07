package command;

import command.interfaces.Command;
import provider.DataProvider;

/**
 * Created by stefanangelov on 8/7/16.
 */
public abstract class AbstactComand implements Command {
    protected DataProvider dataProvider;
    protected String[] args;

    protected AbstactComand(String [] args, DataProvider dataProvider){
        setArgs(args);
        setDataProvider(dataProvider);
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

    private void setDataProvider(DataProvider dataProvider) {
        this.dataProvider = dataProvider;
    }
}
