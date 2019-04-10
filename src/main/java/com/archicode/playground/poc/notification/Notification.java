package com.archicode.playground.poc.notification;

import javafx.scene.layout.Pane;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Object representing notification.
 * @author Tomasz Kozlowski (created on 10.04.2019)
 */
@Getter
@AllArgsConstructor
public class Notification {

    /** Parent pane for notification */
    private Pane parent;
    /** Message to show in notification */
    private String message;
    /** Notification style type */
    private NotificationType type;

}
