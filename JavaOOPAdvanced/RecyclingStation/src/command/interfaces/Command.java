package command.interfaces;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by stefanangelov on 8/7/16.
 */
public interface Command {
    String execute() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
