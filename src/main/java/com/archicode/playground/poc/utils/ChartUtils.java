package com.archicode.playground.poc.utils;

import com.archicode.playground.poc.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * Utils methods for chart components.
 * @author Tomasz Kozlowski (created on 13.04.2019)
 */
public class ChartUtils {

    /** Arrays of colors used by chart components */
    private static final String[] COLORS = {"#1DC7EA","#FB404B","#FFA534","#73CC55"};
    /** Static lock object for access to chart notifications */
    private static final Object LOCK = new Object();
    /** Active notification */
    private static Pane notification;

    /** Adds value notifications for all chart data */
    public static <X,Y> void createValueNotifications(XYChart<X,Y> chart) {
        for (int i = 0; i < chart.getData().size(); i++) {
            XYChart.Series<X,Y> series = chart.getData().get(i);
            for (XYChart.Data<X,Y> data : series.getData()) {
                setNotificationEvent(data, COLORS[i]);
            }
        }
    }

    /** Sets notification events for chart series data */
    private static <X,Y> void setNotificationEvent(XYChart.Data<X,Y> data, String color) {
        Node node = data.getNode();
        if (node != null) {
            // On mouse entered
            node.setOnMouseEntered(event ->
                showNotification(data, color, event.getSceneX(), event.getSceneY())
            );
            // On mouse exited
            node.setOnMouseExited(event -> closeNotification());
        }
    }

    /** Shows notification with chart data Y value */
    private static <X,Y> void showNotification(XYChart.Data<X,Y> data, String color, double x, double y) {
        synchronized (LOCK) {
            if (notification != null) {
                closeNotification();
            }
            notification = createNotification(data.getYValue().toString(), color);
            notification.setLayoutX(x - (notification.getPrefWidth() / 2));
            notification.setLayoutY(y - 50);
            Application.addNode(notification);
        }
    }

    /** Closes active notification */
    private static void closeNotification() {
        synchronized (LOCK) {
            if (notification != null) {
                Application.removeNode(notification);
                notification = null;
            }
        }
    }

    /** Creates notification pane */
    private static Pane createNotification(String value, String color) {
        // Pane width
        int paneWidth;
        if (value.length() < 5) {
            paneWidth = 60;
        } else if (value.length() < 8) {
            paneWidth = 80;
        } else if (value.length() < 11) {
            paneWidth = 100;
        } else {
            paneWidth = 120;
        }

        // Pane
        Pane pane = new Pane();
        pane.setPrefWidth(paneWidth);
        pane.setPrefHeight(30);
        pane.setStyle("-fx-background-radius: 20; -fx-background-color: " + color);
        pane.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.GRAY, 10, 0, 0, 0));

        // Label
        Label label = new Label(value);
        label.setPrefWidth(paneWidth);
        label.setPrefHeight(30);
        label.setTextFill(Paint.valueOf("#5E5E5E"));
        label.setLayoutX(0);
        label.setLayoutY(0);
        label.setStyle("-fx-font-weight: BOLD;");
        label.setAlignment(Pos.CENTER);

        pane.getChildren().addAll(label);
        return pane;
    }

}
