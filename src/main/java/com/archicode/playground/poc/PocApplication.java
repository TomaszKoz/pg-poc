package com.archicode.playground.poc;

import javafx.stage.Stage;

/**
 * @author Tomasz Kozlowski (created on 22.03.2019)
 */
public class PocApplication extends javafx.application.Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        Application.init();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Application.start(primaryStage, "jfx/Home.fxml");
    }

    @Override
    public void stop() {
        Application.stop();
    }

}
