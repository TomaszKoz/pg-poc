package com.archicode.playground.poc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Tomasz Kozlowski (created on 22.03.2019)
 */
@SpringBootApplication
public class PocApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        ConfigurableApplicationContext springContext = SpringApplication.run(PocApplication.class);
        com.archicode.playground.poc.Application.init(springContext);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        com.archicode.playground.poc.Application.start(primaryStage, "jfx/Home.fxml");
    }

    @Override
    public void stop() {
        com.archicode.playground.poc.Application.stop();
    }

}
