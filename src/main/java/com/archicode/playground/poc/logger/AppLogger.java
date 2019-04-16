package com.archicode.playground.poc.logger;

import com.archicode.playground.poc.notification.Notifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application logger class.
 * @author Tomasz Kozlowski (created on 13.04.2019)
 */
public class AppLogger {

    /** Logger object */
    private static Logger logger = LoggerFactory.getLogger(AppLogger.class);

    /** Log message on level INFO */
    public static void info(String message) {
        logger.info(message);
    }

    /** Log message on level DEBUG */
    public static void debug(String message) {
        logger.debug(message);
    }

    /** Log message on level WARNING */
    public static void warning(String message) {
        logger.warn(message);
    }

    /** Log message on level ERROR and show UI notification */
    public static void error(String message) {
        error(message, true);
    }

    /** Log exception on level ERROR and show UI notification */
    public static void error(Throwable throwable) {
        error(throwable.getMessage(), true);
    }

    /** Log message on level ERROR without UI notification */
    public static void errorSuppress(String message) {
        error(message, false);
    }

    /** Log exception on level ERROR without UI notification */
    public static void errorSuppress(Throwable throwable) {
        error(throwable.getMessage(), false);
    }

    /** Logs message on level ERROR */
    private static void error(String message, boolean showNotification) {
        logger.error(message);
        if (showNotification) {
            Notifications.showError(message);
        }
    }

}
