package com.zach.LoiathalBot;

import com.zach.LoiathalBot.command.CommandFactory;
import com.zach.LoiathalBot.command.CommandHandler;
import com.zach.LoiathalBot.command.commands.Command;
import org.apache.log4j.Logger;
import org.jibble.pircbot.PircBot;

/**
 * Created by Zachary McAnally on 12/2/15.
 */

public class LoiathalBot extends PircBot {

    static Logger logger = Logger.getLogger(LoiathalBot.class);

    public LoiathalBot() {
        this.setName("LoiathalBot");
    }

    @Override
    protected void onJoin(String channel, String sender, String login, String hostname)
    {
        super.onJoin(channel, sender, login, hostname);
        logger.debug("someone joined= " + sender);
    }

    @Override
    protected void onMessage(String channel, String sender, String login, String hostname, String message)
    {
        super.onMessage(channel, sender, login, hostname, message);
        logger.debug("someone sent a message " + message);

        if (message.charAt(0) == '!')
        {
            //This is a commands, handle appropriately
            CommandHandler.INSTANCE.handleCommand(sender, login, hostname, message);

        }
    }
}
