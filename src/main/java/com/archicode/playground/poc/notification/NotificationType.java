package com.archicode.playground.poc.notification;

import lombok.Getter;

/**
 * Notification style type.
 * @author Tomasz Kozlowski (created on 10.04.2019)
 */
@Getter
public enum NotificationType {

    INFO("INFO_CIRCLE", "#5BC0DE"),
    SUCCESS("CHECK_CIRCLE", "#73CC55"),
    WARNING("WARNING", "#FFBC67"),
    DANGER("EXCLAMATION_CIRCLE", "#FC727A");

    /** Notification icon */
    private final String icon;
    /** Notification bar color */
    private final String color;

    NotificationType(String icon, String color) {
        this.icon = icon;
        this.color = color;
    }

}
