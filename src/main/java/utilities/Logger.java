package utilities;


import org.slf4j.LoggerFactory;


public class Logger {
    public static synchronized void log(String message){
        org.slf4j.Logger logger = LoggerFactory.getLogger(Logger.class);
        logger.info(message);
    }
}
