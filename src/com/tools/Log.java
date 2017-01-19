package com.tools;

import java.util.logging.Logger;

/**
 * Created by pavel on 19.01.17.
 */
public class Log {

    public static Log log;
    Logger logger;

    public static void init(Logger logger) {
        log = new Log(logger);
    }

    private Log(Logger logger) {
        this.logger = logger;
    }

    public void info(String msg) {
        log.logger.info(msg);
    }

}
