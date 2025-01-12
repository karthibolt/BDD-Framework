package Utility;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    // Initialize the logger for this class
    private static final Logger logger = LogManager.getLogger(LoggerUtil.class);

    // Method to log info messages
    public static void info(String message) {
        logger.info(message);
    }

    // Method to log debug messages
    public static void debug(String message) {
        logger.debug(message);
    }

    // Method to log error messages
    public static void error(String message) {
        logger.error(message);
    }

    // Method to log warn messages
    public static void warn(String message) {
        logger.warn(message);
    }

    // Method to log fatal messages
    public static void fatal(String message) {
        logger.fatal(message);
    }
}
