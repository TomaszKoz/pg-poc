package com.archicode.playground.poc;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;

/**
 * Class responsible for configure and start application.
 * @author Tomasz Kozlowski (created on 13.04.2019)
 */
public class Application {

    /** Main application pane component */
    @Getter
    private static Pane mainPane;

    /** Configures and starts application */
    public static void start(Stage primaryStage, String fxmlFile) throws Exception {
        System.setProperty("prism.lcdtext", "false");
        mainPane = FXMLLoader.load(Application.class.getResource("jfx/Home.fxml"));

        // Scene
        Scene scene = new Scene(mainPane);
        scene.getStylesheets().add("css/stylesheet.css");
        scene.getStylesheets().add("css/charts.css");

        // Primary stage
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    /** Returns main application stage */
    public static Stage getStage() {
        return (Stage) Application.mainPane.getScene().getWindow();
    }

    /** Adds node to the main pane */
    public static void addNode(Node node) {
        mainPane.getChildren().add(node);
    }

    /** Removes node from the main pane */
    public static void removeNode(Node node) {
        mainPane.getChildren().remove(node);
    }

}
