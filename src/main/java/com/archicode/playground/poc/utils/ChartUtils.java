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

    private static final String[] COLORS = {"#1DC7EA","#FB404B","#FFA534","#73CC55"};

    /** Adds value notifications for all chart data */
    public static <X, Y> void createValueNotifications(XYChart<X,Y> chart) {
        for (int i = 0; i < chart.getData().size(); i++) {
            XYChart.Series<X,Y> series = chart.getData().get(i);
            for (XYChart.Data<X,Y> data : series.getData()) {
                setNotificationEvent(data, COLORS[i]);
            }
        }
    }

    /** Sets notification events for chart series data */
    private static <X, Y> void setNotificationEvent(XYChart.Data<X, Y> data, String color) {
        Node node = data.getNode();
        if (node != null) {
            node.setOnMouseEntered(event -> {
                Pane notification = createNotification(data.getYValue().toString(), color);
                notification.setLayoutX(event.getSceneX() - (notification.getPrefWidth() / 2));
                notification.setLayoutY(event.getSceneY() - 40);
                Application.addNode(notification);
            });
        }
    }

    private static Pane createNotification(String value, String color) {
        // Pane
        Pane pane = new Pane();
        pane.setPrefWidth(60);
        pane.setPrefHeight(30);
        pane.setStyle("-fx-background-radius: 20; -fx-background-color: " + color);
        pane.setEffect(new DropShadow(BlurType.THREE_PASS_BOX, Color.GRAY, 10, 0, 0, 0));

        // Label
        Label label = new Label(value);
        label.setPrefWidth(60);
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
