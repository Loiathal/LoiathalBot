package com.zach.LoiathalBot.connection;

import com.zach.LoiathalBot.LoiathalBot;
import org.apache.log4j.Logger;
import org.jibble.pircbot.IrcException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by Loiathal on 12/4/2015.
 */

public class Connector {

    static Logger logger = Logger.getLogger(Connector.class);

    private static String channelName;
    private static String authKey;      //TODO: Store this as a charArray
    private static LoiathalBot bot;

    public Connector(LoiathalBot bot, String channelName)
    {
        this.bot = bot;
        this.channelName = channelName;
        authKey = getAuthKey();
    }


    public void establishConnection() {

        try {
            bot.connect("irc.twitch.tv", 6667, authKey);
        } catch (IOException e){
            logger.error("IO Exception while connecting, ", e);
        } catch (IrcException e) {
            logger.error("IrcException, failed to connect to irc.twitch.tv server", e);
        }

        bot.joinChannel(channelName);
    }

    private String getAuthKey()
    {
        InputStream is = getClass().getClassLoader().getResourceAsStream("twitch.auth");
        if (is == null)
        {
            logger.error("Input stream for twitch.auth is null, exiting");
            throw new RuntimeException();
        }
        InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);

        String auth = null;
        if (reader != null)
        {
            Scanner authScanner = new Scanner(is, "UTF-8").useDelimiter("\\A");      //\A is token for "beginning of input boundary"
            auth = authScanner.hasNext() ? authScanner.next() : "";     //Starts before the first token, put "" if there's nothing
            logger.debug("AUTH TOKEN IS = " + auth);
        }
        else {
            throw new RuntimeException("Unable to open twitch.auth to read key, exiting.");
        }
        if (auth == null)
            throw new RuntimeException("Auth key for twitch channel is null, exiting.");

        return auth;
    }
}
