package com.archicode.playground.poc.logger;

/**
 * @author Tomasz Kozlowski (created on 13.04.2019)
 */
public class Logger {

    //private Logger logger = LoggerFactory.getLogger(Logger.class); // TODO po dodaniu SPRINGA

    public static void info(String message) {
        System.out.println("INFO: " + message);
    }

    public static void debug(String message) {
        System.out.println("DEBUG: " + message);
    }

    public static void warning(String message) {
        System.out.println("WARNING: " + message);
    }

    public static void error(String message) {
        System.out.println("ERROR: " + message); // TODO z rzuceniem Notyfikacji
    }

}
