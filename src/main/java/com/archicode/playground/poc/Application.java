package com.archicode.playground.poc;

import com.archicode.playground.poc.logger.AppLogger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lombok.Getter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import sun.reflect.CallerSensitive;

import java.io.IOException;

/**
 * Class responsible for configure and start application.
 * @author Tomasz Kozlowski (created on 13.04.2019)
 */
@SpringBootApplication
@EnableTransactionManagement
public class Application {

    /** Spring application context */
    private static ConfigurableApplicationContext springContext;
    /** FXML files loader */
    private static FXMLLoader fxmlLoader;
    /** Main application pane component */
    @Getter
    private static Pane mainPane;

    /** Initializes application context */
    public static void init() {
        springContext = SpringApplication.run(Application.class);
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setControllerFactory(springContext::getBean);
    }

    /** Configures and starts application */
    public static void start(Stage primaryStage, String fxmlFile) throws Exception {
        // Load FXML document
        mainPane = loadFXML(fxmlFile);

        // Scene
        Scene scene = new Scene(mainPane);
        scene.getStylesheets().add("css/stylesheet.css");
        scene.getStylesheets().add("css/charts.css");

        // Primary stage
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();

        AppLogger.info("Application has been started...");
    }

    /** Stops application */
    public static void stop() {
        springContext.stop();
        AppLogger.info("Application has been stopped...");
    }

    /** Loads a FXML document */
    @CallerSensitive
    public static <T> T loadFXML(String fxmlFilePath) throws IOException {
        if (fxmlLoader == null) {
            throw new IllegalStateException("Try to load FXML document before application initialization");
        }
        fxmlLoader.setLocation(Application.class.getResource(fxmlFilePath));
        return fxmlLoader.load();
    }

    /** Returns main application stage */
    public static Stage getStage() {
        return (Stage) mainPane.getScene().getWindow();
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
