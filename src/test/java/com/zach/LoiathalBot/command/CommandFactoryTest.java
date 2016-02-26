package com.zach.LoiathalBot.command;//(c) 2015 Optio Labs, Inc.   Confidential and proprietary information of Optio Labs, Inc.  

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by Zachary McAnally on 1/10/16.
 */
public class CommandFactoryTest {

    CommandFactory commandFactory;

    //This might need to become BeforeClass at some point when there's a real db
    @Before
    public void setUp()
    {
        commandFactory = CommandFactory.INSTANCE;
    }


    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testNonexistentCommandThrowsUnsupportedOperationException()
    {
        thrown.expect(UnsupportedOperationException.class);
        thrown.expectMessage("Command FakeCommand does not exist");
        String commandString = "FakeCommand";

        commandFactory.createCommand(commandString);
    }

    @Test
    public void testStartStreamCommandSucceeds()
    {
        String commandString = "StartStream";
        commandFactory.createCommand(commandString);
    }
}
