package com.zach.LoiathalBot.command.commands;

import org.apache.log4j.Logger;

/**
 * Created by Loiathal on 12/5/2015.
 */
public class StartStreamCommand implements Command {

    static Logger logger = Logger.getLogger(StartStreamCommand.class);

    public StartStreamCommand() {

    }

    public void executeCommand(String parameters) {
        logger.debug("START STREAM COMMAND EXECUTING");
    }
}
