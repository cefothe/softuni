package command.enums;

import command.ProcessGarbageCommand;
import command.interfaces.Command;

/**
 * Created by stefanangelov on 8/7/16.
 */
public enum ComandEnumeration {

    PROCESS_GARBAGE("ProcessGarbage", ProcessGarbageCommand.class);

    private String commandName;
    private Class<? extends Command> commandClass;

    private ComandEnumeration(String commandName,Class<? extends Command> commandClass ){
        this.commandName = commandName;
        this.commandClass =commandClass;
    }

    public String getCommandName(){
        return this.commandName;
    }

    public Class<? extends Command> getCommandClass(){
      return  this.commandClass;
    }

    public static ComandEnumeration getEnumByCommandName(String commandName){
        for(ComandEnumeration e:values()){
            if(e.getCommandName().equals(commandName)){
                return e;
            }
        }
        throw  new IllegalArgumentException("No enum constant with commandName"+ commandName);
    }
}
