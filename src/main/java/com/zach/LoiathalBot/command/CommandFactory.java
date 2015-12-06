package com.zach.LoiathalBot.command;

import com.zach.LoiathalBot.command.commands.Command;
import com.zach.LoiathalBot.command.commands.StartStreamCommand;
import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * Created by Loiathal on 12/5/2015.
 */
public class CommandFactory {

    public static final CommandFactory INSTANCE = new CommandFactory();
    static Logger logger = Logger.getLogger(AccessLevelMap.class);

    HashMap<String, Command> commandMap;

    private CommandFactory()
    {
        commandMap = new HashMap();
        initializeCommandFactory();     //TODO: Store these commands in a database
    }

    private void initializeCommandFactory()
    {
        commandMap.put("StartStream", new StartStreamCommand());
    }

    public Command createCommand(String commandString)
    {
        Command command = commandMap.get(commandString);
        if (command == null)
        {
            throw new UnsupportedOperationException();
        }

        return command;
    }
}
