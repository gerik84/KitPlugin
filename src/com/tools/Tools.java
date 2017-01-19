package com.tools;


import com.controllers.Main;

import java.util.logging.Logger;

/**
 * Created by pavel on 19.01.17.
 */
public class Tools {

    static Tools sInstance;
    DBConnection mDBConnection;
    Logger logger;

    public static <T extends Main> void init(T context) {
        if (sInstance != null)
            throw new RuntimeException("Error init tools");
        sInstance = new Tools(context);
    }

    private <T extends Main> Tools(T context) {
        mDBConnection = DBConnection.init(context);
        logger = context.getLogger();
    }

    public static Tools getInstance() {
        if (sInstance == null)
            throw new NullPointerException("Before need called init method");
        return sInstance;
    }

    public DBConnection getDBConnection() {
        return mDBConnection;
    }

    public static Logger Log() {
        return sInstance.logger;
    }

}
