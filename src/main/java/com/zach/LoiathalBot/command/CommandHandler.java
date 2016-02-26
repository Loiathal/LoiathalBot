package com.zach.LoiathalBot.command;

import com.zach.LoiathalBot.command.commands.Command;
import org.apache.log4j.Logger;

import javax.activation.CommandMap;

/**
 * Created by Loiathal on 12/6/2015.
 */
public class CommandHandler {

    static Logger logger = Logger.getLogger(CommandHandler.class);
    public static final CommandHandler INSTANCE = new CommandHandler();


    public void handleCommand(String sender, String login, String hostname, String message)
    {
        String[] commandStringSplit = message.split(" ", 2);        //Get just the command seperate from parameters
        String commandString = commandStringSplit[0];
        commandString = commandString.substring(1);                 //Remove the !
        logger.debug("Command = " + commandString);

        String parameters = null;
        if (commandStringSplit.length > 1)
        {
            parameters = commandStringSplit[1];
        }

        if (!checkAccessLevel(sender, commandString, parameters))
        {
            //TODO: Handle failed accessLevel
        }
        executeCommand(sender, commandString, parameters);
    }

    public boolean checkAccessLevel(String sender, String commandString, String parameters)
    {
        //TODO: Check access level!
        return true;
    }

    public void executeCommand(String sender, String commandString, String parameters)
    {
        try
        {
            Command command = CommandFactory.INSTANCE.createCommand(commandString);
            command.executeCommand(parameters);

        } catch (UnsupportedOperationException e) {
            logger.error("User sender " + "attempted to execute command " + commandString +
                    " with parameters " + parameters);
        }
    }
}
