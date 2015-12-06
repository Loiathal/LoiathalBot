package com.zach.LoiathalBot.security;

/**
 * Created by Loiathal on 12/5/2015.
 */
public enum AccessLevel {

    BANNED(0), NEWBIE(50), REGULAR(75), MODERATOR(100), OWNER(200);
    private final int level;

    AccessLevel(int level)
    {
        this.level = level;
    }

    public int accessLevel()
    {
        return level;
    }

}
