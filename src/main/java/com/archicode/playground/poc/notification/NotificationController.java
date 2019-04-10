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

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Controller for generating application notification bar.
 * @author Tomasz Kozlowski (created on 08.04.2019)
 */
public class NotificationController {

    /** Notification bar */
    private HBox notificationBar;

    /** Static lock object for access to notification queue */
    private static final Object LOCK = new Object();
    /** Static collection of notification to show */
    private static final Map<String, Notification> QUEUE = new LinkedHashMap<>();

    /** Shows info type notification */
    public void showInfo(Pane parent, String message) {
        showNotification(parent, message, NotificationType.INFO);
    }

    /** Shows success type notification */
    public void showSuccess(Pane parent, String message) {
        showNotification(parent, message, NotificationType.SUCCESS);
    }

    /** Shows warning type notification */
    public void showWarning(Pane parent, String message) {
        showNotification(parent, message, NotificationType.WARNING);
    }

    /** Shows error type notification */
    public void showError(Pane parent, String message) {
        showNotification(parent, message, NotificationType.DANGER);
    }

    /** Puts notification to queue */
    private void showNotification(Pane parent, String message, NotificationType type) {
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
    private void onNotificationFinished(Notification notification) {
        synchronized (LOCK) {
            // removes notification from queue
            QUEUE.remove(notification.getMessage());
            // removes notification bar from UI component
            notification.getParent().getChildren().remove(notificationBar);
            // if queue is not empty then show first notification
            if (!QUEUE.isEmpty()) {
                String key = QUEUE.keySet().iterator().next();
                showNotificationBar(QUEUE.get(key));
            }
        }
    }

    /** Generates nad shows notification bar */
    private void showNotificationBar(Notification notification) {
        Pane parent = notification.getParent();
        this.notificationBar = createNotificationBar(notification.getMessage(), notification.getType());

        // calculate notification bar position
        double parentWidth = parent.getWidth();
        double barWidth = notificationBar.getPrefWidth();
        double barPositionX = (parentWidth / 2) - (barWidth / 2);
        if (barPositionX < 0) {
            barPositionX = 0;
        }

        notificationBar.setLayoutX(barPositionX);
        notificationBar.setLayoutY(-30);
        notificationBar.setOpacity(0.0);
        notificationBar.toFront();
        parent.getChildren().add(notificationBar);

        // fade in timeline
        Timeline fadeIn = createTimeline(60, 1.0, Interpolator.EASE_OUT);

        // stay still timeline
        Timeline stayStill = new Timeline(new KeyFrame(Duration.seconds(5)));

        // fade out timeline
        Timeline fadeOut = createTimeline(-30, 0.0, Interpolator.EASE_IN);

        SequentialTransition sequentialTransition = new SequentialTransition();
        sequentialTransition.getChildren().addAll(fadeIn, stayStill, fadeOut);
        sequentialTransition.setOnFinished(e -> this.onNotificationFinished(notification));
        sequentialTransition.play();
    }

    /** Creates timeline for notification animation */
    private Timeline createTimeline(Number yEndValue, Number opacityEndValue, Interpolator interpolator) {
        Timeline timeline = new Timeline();
        KeyValue yValue = new KeyValue(notificationBar.translateYProperty(), yEndValue, interpolator);
        KeyValue opacityValue = new KeyValue(notificationBar.opacityProperty(), opacityEndValue, interpolator);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(320), yValue, opacityValue);
        timeline.getKeyFrames().add(keyFrame);
        return timeline;
    }

    /** Creates notification bar */
    private HBox createNotificationBar(String message, NotificationType type) {
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

}
