package com.zach.LoiathalBot.command;//(c) 2015 Optio Labs, Inc.   Confidential and proprietary information of Optio Labs, Inc.  

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Zachary McAnally on 1/10/16.
 */
public class CommandHandlerTest {

    String user;
    String login;
    String hostname;
    String message;

    CommandHandler commandHandler = CommandHandler.INSTANCE;

    @Before
    public void setUp()
    {
        user = "someUser";
        login = "someUser";
        hostname = "#loiathal";
    }



}
