import com.zach.LoiathalBot.LoiathalBot;
import com.zach.LoiathalBot.connection.Connector;
import org.apache.log4j.Logger;
import org.jibble.pircbot.IrcException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Created by Loiathal on 12/2/15.
 */


public class LoiathalBotMain {

    static Logger logger = Logger.getLogger(LoiathalBotMain.class);

    static Connector loiathalBotConnector;

    public static void main(String[] args) throws Exception {

            LoiathalBot bot = new LoiathalBot();
            bot.setVerbose(true);

            loiathalBotConnector = new Connector(bot, args[0]);
            loiathalBotConnector.establishConnection();
            //TODO: Set up a connection maintainer that tries again every so often


    }

}
