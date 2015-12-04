import com.zach.LoiathalBot.LoiathalBot;
import org.apache.log4j.Logger;
import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import sun.misc.CharacterEncoder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Zachary McAnally on 12/2/15.
 */


public class LoiathalBotMain {

    static Logger logger = Logger.getLogger(LoiathalBotMain.class);


    public static void main(String[] args) throws Exception {

        try {

            logger.debug("first argument = " + args[0]);

            // Now start our bot up.
            LoiathalBot bot = new LoiathalBot();

            connect(bot);
        } catch (Exception e)
        {
            System.out.println("fuck");
            e.printStackTrace();
        }
    }

    public static void connect(LoiathalBot bot) throws IrcException, IOException, URISyntaxException {

        bot.setVerbose(true);

        InputStream is = LoiathalBotMain.class.getResourceAsStream("twitch.auth");
        InputStreamReader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
        String auth = null;
        if (reader != null)
        {
            Scanner authScanner = new Scanner(is, "UTF-8").useDelimiter("\\A");      //\A is token for "beginning of input boundary"
            auth = authScanner.hasNext() ? authScanner.next() : "";
            logger.debug("AUTH TOKEN IS = " + auth);
        }
        else
        {
            logger.error("fuck it's null");
        }

        // Connect to the IRC server.
        bot.connect("irc.twitch.tv", 6667, auth);

        // Join the #pircbot channel.
        bot.joinChannel("#loiathal");

    }
}
