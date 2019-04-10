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

/**
 * Controller for generating application notification bar.
 * @author Tomasz Kozlowski (created on 08.04.2019)
 */
public class NotificationController {

    /** Notification bar */
    private HBox notificationBar;
    /** Parent pane */
    private Pane parent;

    /** Shows info type notification */
    public void showInfo(Pane parentPane, String message) {
        show(parentPane, message, NotificationType.INFO);
    }

    /** Shows success type notification */
    public void showSuccess(Pane parentPane, String message) {
        show(parentPane, message, NotificationType.SUCCESS);
    }

    /** Shows warning type notification */
    public void showWarning(Pane parentPane, String message) {
        show(parentPane, message, NotificationType.WARNING);
    }

    /** Shows error type notification */
    public void showError(Pane parentPane, String message) {
        show(parentPane, message, NotificationType.DANGER);
    }

    private void show(Pane parentPane, String message, NotificationType type) {
        this.parent = parentPane;
        this.notificationBar = createNotificationBar(message, type);

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
        sequentialTransition.setOnFinished(e -> parent.getChildren().remove(notificationBar));
        sequentialTransition.play();
    }

    private Timeline createTimeline(Number yEndValue, Number opacityEndValue, Interpolator interpolator) {
        Timeline timeline = new Timeline();
        KeyValue yValue = new KeyValue(notificationBar.translateYProperty(), yEndValue, interpolator);
        KeyValue opacityValue = new KeyValue(notificationBar.opacityProperty(), opacityEndValue, interpolator);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(320), yValue, opacityValue);
        timeline.getKeyFrames().add(keyFrame);
        return timeline;
    }

    private HBox createNotificationBar(String message, NotificationType type) {
        HBox bar = new HBox();
        bar.setAlignment(Pos.CENTER);
        bar.setPrefWidth(450);
        bar.setPrefHeight(message.length() > 45 ? 70 : 55);
        bar.setStyle("-fx-background-radius: 10; -fx-background-color: " + type.getColor());

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