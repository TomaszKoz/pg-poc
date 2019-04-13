package com.archicode.playground.poc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Tomasz Kozlowski (created on 22.03.2019)
 */
public class PocApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        com.archicode.playground.poc.Application.start(primaryStage, "jfx/Home.fxml");
    }

}
