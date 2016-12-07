package command;

import command.interfaces.Command;
import core.model.TypeGarbage;
import framework.waste.disposal.contracts.GarbageProcessor;
import framework.waste.disposal.contracts.ProcessingData;
import framework.waste.disposal.contracts.Waste;
import provider.DataProvider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class ProcessGarbageCommand extends  AbstactComand {

    public ProcessGarbageCommand(String[] args, DataProvider dataProvider, GarbageProcessor garbageProcessor){
        super(args,dataProvider,garbageProcessor);
    }

    @Override
    public String execute() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        TypeGarbage type = TypeGarbage.getEnumByCommandName(this.getArgs()[3]);
        Waste waste = dataProvider.addProduct(type,this.getArgs()[0], Double.parseDouble(this.getArgs()[1]),Double.parseDouble(this.getArgs()[2]));

        return waste.toString();
    }
}
