package com.archicode.playground.poc.notification;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.util.Duration;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Utility class provides functionality for generating application notification bar.
 * @author Tomasz Kozlowski (created on 08.04.2019)
 */
@SuppressWarnings("unused")
public class Notifications {

    /** Static lock object for access to notification queue */
    private static final Object LOCK = new Object();
    /** Static collection of notification to show */
    private static final Map<String, Notification> QUEUE = new LinkedHashMap<>();

    /** Empty private constructor */
    private Notifications() {
    }

    /** Shows info type notification */
    public static void showInfo(Pane parent, String message) {
        showNotification(parent, message, NotificationType.INFO);
    }

    /** Shows success type notification */
    public static void showSuccess(Pane parent, String message) {
        showNotification(parent, message, NotificationType.SUCCESS);
    }

    /** Shows warning type notification */
    public static void showWarning(Pane parent, String message) {
        showNotification(parent, message, NotificationType.WARNING);
    }

    /** Shows error type notification */
    public static void showError(Pane parent, String message) {
        showNotification(parent, message, NotificationType.DANGER);
    }

    /** Puts notification to queue */
    private static void showNotification(Pane parent, String message, NotificationType type) {
        synchronized (LOCK) {
            if (!QUEUE.keySet().contains(message)) {
                Notification notification = new Notification(parent, message, type);
                QUEUE.put(message, notification);
                // if there is only one notification show it
                if (QUEUE.size() == 1) {
                    showNotificationBar(notification);
                }
            }
        }
    }

    /** Removes shown notification from queue and shows next if there is any */
    private static void onNotificationFinished(Notification notification, HBox bar) {
        synchronized (LOCK) {
            // removes notification from queue
            QUEUE.remove(notification.getMessage());
            // removes notification bar from UI component
            notification.getParent().getChildren().remove(bar);
            // if queue is not empty then show first notification
            if (!QUEUE.isEmpty()) {
                String key = QUEUE.keySet().iterator().next();
                showNotificationBar(QUEUE.get(key));
            }
        }
    }

    /** Generates nad shows notification bar */
    private static void showNotificationBar(Notification notification) {
        Pane parent = notification.getParent();
        HBox bar = createNotificationBar(notification.getMessage(), notification.getType());

        // calculate notification bar position
        double parentWidth = parent.getWidth();
        double barWidth = bar.getPrefWidth();
        double barPositionX = (parentWidth / 2) - (barWidth / 2);
        if (barPositionX < 0) {
            barPositionX = 0;
        }

        bar.setLayoutX(barPositionX);
        bar.setLayoutY(-30);
        bar.setOpacity(0.0);
        bar.toFront();
        parent.getChildren().add(bar);

        // fade in timeline
        Timeline fadeIn = createTimeline(bar, 60, 1.0, Interpolator.EASE_OUT);

        // stay still timeline
        Timeline stayStill = new Timeline(new KeyFrame(Duration.seconds(3)));

        // fade out timeline
        Timeline fadeOut = createTimeline(bar,-30, 0.0, Interpolator.EASE_IN);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(fadeIn, stayStill, fadeOut);
        sequentialTransition.setOnFinished(e -> Notifications.onNotificationFinished(notification, bar));
        sequentialTransition.play();
    }

    /** Creates timeline for notification animation */
    private static Timeline createTimeline(HBox bar, Number yEndValue, Number opacityEndValue, Interpolator interpolator) {
        Timeline timeline = new Timeline();
        KeyValue yValue = new KeyValue(bar.translateYProperty(), yEndValue, interpolator);
        KeyValue opacityValue = new KeyValue(bar.opacityProperty(), opacityEndValue, interpolator);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(320), yValue, opacityValue);
        timeline.getKeyFrames().add(keyFrame);
        return timeline;
    }

    /** Creates notification bar */
    private static HBox createNotificationBar(String message, NotificationType type) {
        HBox bar = new HBox();
        bar.setAlignment(Pos.CENTER);
        bar.setPrefWidth(450);
        bar.setPrefHeight(message.length() > 45 ? 70 : 55);
        bar.setStyle("-fx-background-radius: 15; -fx-background-color: " + type.getColor());

        // Icon
        FontAwesomeIconView icon = new FontAwesomeIconView();
        icon.setGlyphName(type.getIcon());
        icon.setSize("30");
        icon.setSmooth(true);
        icon.setFill(Paint.valueOf("WHITE"));

        // Notification message
        Label label = new Label(message);
        label.setPrefWidth(370);
        label.setPrefHeight(70);
        label.setWrapText(true);
        label.setTextFill(Paint.valueOf("WHITE"));
        label.setFont(Font.font(18));
        label.setPadding(new Insets(0, 0, 0, 10));
        HBox.setMargin(label, new Insets(0, 0, 0, 10));

        bar.getChildren().addAll(icon, label);
        return bar;
    }

    /** Private inner class representing notification */
    @Getter
    @AllArgsConstructor
    private static class Notification {
        /** Parent pane for notification */
        private Pane parent;
        /** Message to show in notification */
        private String message;
        /** Notification style type */
        private NotificationType type;
    }

}
