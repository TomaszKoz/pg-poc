package com.archicode.playground.poc.jfx;

import com.jfoenix.animation.alert.VerticalTransition;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.IOException;

/**
 * @author Tomasz Kozlowski (created on 08.04.2019)
 */

public class NotificationController {

    private Parent notificationPane;

    public void show(Pane pane) {
        try {
            notificationPane = FXMLLoader.load(NotificationController.class.getResource("Notification.fxml"));
            notificationPane.setLayoutX(556);
            notificationPane.setLayoutY(-30);
            notificationPane.setOpacity(0.0);
            notificationPane.toFront();
            pane.getChildren().add(notificationPane);

            Timeline timeline = createTimeline(60, 1.0, Interpolator.EASE_OUT);
            timeline.setOnFinished(this::onNotificationShown);
            timeline.play();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onNotificationShown(ActionEvent event) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Timeline timeline = createTimeline(-30, 0.0, Interpolator.EASE_IN);
        timeline.play();
    }

    private Timeline createTimeline(Number yEndValue, Number opacityEndValue, Interpolator interpolator) {
        Timeline timeline = new Timeline();
        KeyValue yValue = new KeyValue(notificationPane.translateYProperty(), yEndValue, interpolator);
        KeyValue opacityValue = new KeyValue(notificationPane.opacityProperty(), opacityEndValue, interpolator);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(320), yValue, opacityValue);
        timeline.getKeyFrames().add(keyFrame);
        return timeline;
    }

}
