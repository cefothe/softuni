package command;

import command.enums.ComandEnumeration;
import command.interfaces.Command;
import command.interfaces.CommandDispatcher;
import framework.waste.disposal.contracts.StrategyHolder;
import provider.DataProvider;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class CommandInterpreter  implements CommandDispatcher{

    private DataProvider dataProvider;

    public CommandInterpreter(DataProvider dataProvider){
        this.dataProvider = dataProvider;
    }

    @Override
    public Command dispatchCommand(String commandName, String[] arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<? extends  Command> comand = ComandEnumeration.getEnumByCommandName(commandName).getCommandClass();
        Constructor<? extends Command> constructor = comand.getConstructor(String[].class, DataProvider.class);
        return constructor.newInstance(arguments,this.dataProvider);
    }
}
