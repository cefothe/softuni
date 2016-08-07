package command;

import command.interfaces.Command;
import provider.DataProvider;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class StatusCommand extends  AbstactComand {

    public StatusCommand(String[] args, DataProvider dataProvider){
        super(args,dataProvider);
    }

    @Override
    public String execute() {
        return null;
    }
}
