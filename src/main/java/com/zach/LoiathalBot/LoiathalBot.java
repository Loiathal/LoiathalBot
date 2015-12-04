package com.zach.LoiathalBot;

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
        System.out.println("fuck");
        logger.error("someone sent a message " + message);
    }
}
