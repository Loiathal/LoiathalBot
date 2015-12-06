package com.zach.LoiathalBot.command;

import com.zach.LoiathalBot.security.AccessLevel;
import org.apache.log4j.Logger;

import java.util.HashMap;

/**
 * Created by Loiathal on 12/5/2015.
 */

public class AccessLevelMap {

    public static final AccessLevelMap INSTANCE = new AccessLevelMap();
    static Logger logger = Logger.getLogger(AccessLevelMap.class);


    private HashMap<String, AccessLevel> accessLevelMap;

    private AccessLevelMap() {
        accessLevelMap = new HashMap<String, AccessLevel>();

        initializeAccessLevelMap();     //TODO: Store these commands in the database
    }

    private void initializeAccessLevelMap()
    {
        accessLevelMap.put("StartStream", AccessLevel.OWNER);
    }

}
