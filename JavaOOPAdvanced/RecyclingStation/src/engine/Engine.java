package engine;



import command.CommandInterpreter;
import command.interfaces.Command;
import command.interfaces.CommandDispatcher;
import core.constants.Constants;
import io.reader.ConsoleReader;
import io.reader.Reader;
import io.writer.ConsoleWriter;
import io.writer.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by stefanangelov on 8/7/16.
 */
public class Engine implements EngineInterface {

    private Reader consoleReader;

    private Writer consoleWriter;

    private Boolean isRunning;

    private CommandDispatcher commandInterpreter;

    public Engine(){
        this.consoleReader = new ConsoleReader();
        this.consoleWriter = new ConsoleWriter();
        this.commandInterpreter = new CommandInterpreter();
    }

    @Override
    public void run() throws IOException {
        this.isRunning = true;

        while (this.isRunning) {

            String inputLine = this.consoleReader.readLine();

            this.processInput(inputLine);
        }
    }

    private void processInput(String input) {
        String[] splittedArgs = input.split(Constants.INPUT_SPLIT_COMMAND);

        String commandName = splittedArgs[0];

        if(commandName.equals(Constants.TERMINATE)) {
            this.isRunning = false;
            return;
        }
        String[] commandArgs = new String[]{};

        if(splittedArgs.length>1) {
            String commandArg = splittedArgs[1];
            commandArgs = commandArg.split(Constants.INPUT_SPLIT_ARGUMENTS);
        }
        try {
            Command comand = commandInterpreter.dispatchCommand(commandName, commandArgs);
            comand.execute();
        } catch (NoSuchMethodException |IllegalAccessException |InvocationTargetException|InstantiationException e) {
          throw  new IllegalArgumentException("Invalid input");
        }

    }
}
