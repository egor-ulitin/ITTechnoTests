package by.ittechno.reporting;

import org.apache.log4j.Logger;

public class MyLogger {
    private static final Logger logger = Logger.getLogger(MyLogger.class);
    public static void info(String message) {
        logger.info(message);
    }
    public static void error(String message) {
        logger.error(message);
    }
    public static void debug(String message) {
        logger.debug(message);
    }
}
