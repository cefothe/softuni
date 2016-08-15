package command.interfaces;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by stefanangelov on 8/7/16.
 */
public interface CommandDispatcher {
    public Command dispatchCommand(String commandName, String[] arguments) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
